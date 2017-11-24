/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Categoria;

/**
 *
 * @author Samuel Vieira
 */
public class CategoriaDAO {
    public boolean incluirCategoria(Categoria categoria) {
        int resposta = 0;
        try {
            String sql = "insert into bdmaster.categoria(nome) values (?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, categoria.getNome());
            resposta = p.executeUpdate();
        } catch(SQLException e) {
        } finally {
            if (resposta > 0){
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void pesquisarCategoria(Categoria categoria) {
        try {
            String sql = "SELECT * FROM bdmaster.categoria WHERE numero = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, categoria.getNome());      //????
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                categoria.setNome(rs.getString("nome"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarCategoria(Categoria categoria) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.categoria SET nome = ? WHERE nome = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, categoria.getNome());
            resposta = p.executeUpdate();
            System.out.println("Resposta: " + resposta);
        } catch(SQLException e){
            
        } finally {
            if(resposta > 0){
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean excluirCategoria(Categoria categoria) {
        int resposta = 0;
        try{
            String sql = "DELETE FROM bdmaster.categoria WHERE nome = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, categoria.getNome());
            resposta = p.executeUpdate();
        } catch(SQLException e){
        } finally {
            if(resposta > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
    
}
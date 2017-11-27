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
import java.util.ArrayList;
import model.Canal;

/**
 *
 * @author Samuel Vieira
 */
public class CanalDAO {
    public boolean incluirCanal(Canal canal) {
        int resposta = 0;
        try {
            String sql = "insert into bdmaster.canal(nome, preco, numero) values (?, ?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, canal.getNome());
            p.setFloat(2, canal.getPreco());
            p.setInt(3, canal.getNumero());
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
    
    public void pesquisarCanal(Canal canal) {
        try {
            String sql = "SELECT * FROM bdmaster.canal WHERE numero = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, canal.getNumero());
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                canal.setNome(rs.getString("nome"));
                canal.setNumero(rs.getInt("numero"));
                canal.setPreco(rs.getFloat("preco"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarCanal(Canal canal) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.canal SET nome = ?, preco = ?, numero = ? WHERE numero = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, canal.getNome());
            p.setFloat(2, canal.getPreco());
            p.setInt(3, canal.getNumero());
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
    
    public boolean excluirCanal(Canal canal) {
        int resposta = 0;
        try{
            String sql = "DELETE FROM bdmaster.canal WHERE numero = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, canal.getNumero());
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
    
    public ArrayList<Canal> pesquisarCanaisCategoria(String nomeCategoria){
        ArrayList<Canal> canais = new ArrayList<Canal>();
        try{
            String sql = "SELECT * FROM bdmaster.canal WHERE fk_categoria = "
                    + "(SELECT idCategoria FROM bdmaster.categoria WHERE nome = ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, nomeCategoria);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                Canal canal = new Canal();
                canal.setNome(rs.getString("nome"));
                canal.setNumero(rs.getInt("numero"));
                canal.setPreco(rs.getFloat("preco"));
                canais.add(canal);
            }
        } catch(SQLException e){  
        }
        return canais;
    }
    
    public boolean excluirCanaisCategoria(int idCategoria){
        int resposta = 0;
        try{
           String sql = "DELETE FROM bdmaster.canal WHERE fk_categoria = ?";
           Connection conn = ConnectionFactory.getConnection();
           PreparedStatement p = conn.prepareStatement(sql);
           p.setInt(1, idCategoria);
           resposta = p.executeUpdate();
        } catch(SQLException e){  
        } finally{
            if(resposta > 0){
                return true;
            } else {
                return false;
            }
        }
    }
    
}
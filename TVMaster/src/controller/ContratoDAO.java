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
import model.Contrato;

/**
 *
 * @author Samuel Vieira
 */
public class ContratoDAO {
    public boolean incluirContrato(Contrato contrato) {
        int resposta = 0;
        try {
            String sql = "insert into bdmaster.contrato(receptores, endereco, estado, cidade, cpf) values (?, ?, ?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, contrato.getReceptores());
            p.setString(2, contrato.getEndereco());
            p.setInt(3, contrato.getEstado());
            p.setString(4, contrato.getCidade());
            p.setString(5, contrato.getCpf());
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
    
    public void pesquisarContrato(Contrato contrato) {
        try {
            String sql = "SELECT * FROM bdmaster.contrato WHERE numero = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            System.out.println(contrato.getNumero());
            p.setInt(1, contrato.getNumero());
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                contrato.setNumero(rs.getInt("numero"));
                contrato.setReceptores(rs.getInt("receptores"));
                contrato.setCpf(rs.getString("cpf"));
                contrato.setEndereco(rs.getString("endereco"));
                contrato.setEstado(rs.getInt("estado"));
                contrato.setCidade(rs.getString("cidade"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarContrato(Contrato contrato) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.contrato SET endereco = ?, receptores = ?, cidade = ?, estado = ? WHERE cpf = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, contrato.getEndereco());
            p.setInt(2, contrato.getReceptores());
            p.setString(3, contrato.getCidade());
            p.setInt(4, contrato.getEstado());
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
    
    public boolean excluirContrato(Contrato contrato) {
        int resposta = 0;
        try{
            String sql = "DELETE FROM bdmaster.contrato WHERE numero = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, contrato.getNumero());
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

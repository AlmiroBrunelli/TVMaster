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
            String sql = "insert into bdmaster.contrato(receptores, rua,"
                    + "estadoContrato, cidade, fk_cliente)"
                    + "values (?, ?, ?, ?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            System.out.println("a");
            p.setInt(1, contrato.getReceptores());
            System.out.println("b");
            p.setString(2, contrato.getEndereco());
            System.out.println("c");
            p.setInt(3, contrato.getEstado());
            System.out.println("d");
            p.setString(4, contrato.getCidade());
            System.out.println("e");
            p.setString(5, contrato.getCpf());
            System.out.println("f");
            resposta = p.executeUpdate();
            System.out.println("resposta:" + resposta);
            System.out.println("g");
        } catch(SQLException e) {
            throw new RuntimeException(e);
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
            String sql = "SELECT * FROM bdmaster.contrato WHERE numero = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, contrato.getNumero());
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                contrato.setReceptores(rs.getInt("receptores"));
                contrato.setCpf(rs.getString("fk_cliente"));
                contrato.setEndereco(rs.getString("rua"));
                contrato.setEstado(rs.getInt("estadoContrato"));
                contrato.setCidade(rs.getString("cidade"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarContrato(Contrato contrato) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.contrato SET rua = ?, receptores = ?, cidade = ? WHERE fk_cliente = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, contrato.getEndereco());
            p.setInt(2, contrato.getReceptores());
            p.setString(3, contrato.getCidade());
            p.setString(4, contrato.getCpf());
            resposta = p.executeUpdate();
        } catch(SQLException e){
        } finally {
            if(resposta > 0){
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean alterarEstadoContrato(Contrato contrato) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.contrato SET estadoContrato = ? WHERE fk_cliente = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, contrato.getEstado());
            p.setString(2, contrato.getCpf());
            resposta = p.executeUpdate();
        } catch(SQLException e){
            throw new RuntimeException(e);
        } finally {
            if(resposta > 0) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void pesquisarNumeroContrato(Contrato contrato){
        try {
            String sql = "select max(numero) as 'numero' from bdmaster.contrato;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                contrato.setNumero(rs.getInt("numero"));
            } 
        } catch(SQLException e) {
        }
    }
    
}

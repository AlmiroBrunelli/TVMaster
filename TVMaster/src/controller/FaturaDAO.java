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
import model.Fatura;

/**
 *
 * @author Samuel Vieira
 */
public class FaturaDAO {
    public boolean incluirFatura(Fatura fatura) {
        int resposta = 0;
        try {
            String sql = "insert into bdmaster.fatura(valor, mes, pago) values (?, ?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setFloat(1, fatura.getValor());
            p.setString(2, fatura.getMes());
            p.setBoolean(3, fatura.isPago());
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
    
    public void pesquisarFatura(Fatura fatura) {
        try {
            String sql = "SELECT * FROM bdmaster.fatura WHERE numero = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, fatura.getNumero());
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                fatura.setValor(rs.getFloat("valor"));
                fatura.setNumero(rs.getInt("numero"));
                fatura.setMes(rs.getString("mes"));
                fatura.setPago(rs.getBoolean("pago"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarFatura(Fatura fatura) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.fatura SET pago = ?, valor = ? WHERE numero = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setBoolean(1, fatura.isPago());
            p.setFloat(2, fatura.getValor());
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
    
    public boolean excluirFatura(Fatura fatura) {
        int resposta = 0;
        try{
            String sql = "DELETE FROM bdmaster.fatura WHERE numero = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, fatura.getNumero());
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
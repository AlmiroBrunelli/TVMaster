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
import model.Chamado;

/**
 *
 * @author Samuel Vieira
 */
public class ChamadoDAO {
    public boolean incluirChamado(Chamado chamado) {
        int resposta = 0;
        try {
            String sql = "insert into bdmaster.chamado(motivo, solucao, data, fk_contrato, fk_tecnico, situacao) values (?, ?, ?, ?, ?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, chamado.getMotivo());
            p.setString(2, chamado.getSolucao());
            p.setInt(3, chamado.getData());
            p.setInt(4, chamado.getContrato());
            p.setString(5, chamado.getTecnico().getCpf());
            p.setBoolean(6, chamado.isSituacao());
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
    
    public void pesquisarChamado(Chamado chamado) {
        try {
            String sql = "SELECT * FROM bdmaster.chamado WHERE protocolo = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, chamado.getProtocolo());
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                chamado.setMotivo(rs.getString("motivo"));
                chamado.setSituacao(rs.getBoolean("situacao"));
                chamado.setData(rs.getInt("data"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarChamado(Chamado chamado) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.chamado SET solucao = ?, fk_tecnico = ?, situacao = ? WHERE protocolo = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, chamado.getSolucao());
            p.setString(2, chamado.getTecnico().getCpf());
            p.setBoolean(3, chamado.isSituacao());
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
    
    public boolean excluirChamado(Chamado chamado) {
        int resposta = 0;
        try{
            String sql = "DELETE FROM bdmaster.chamado WHERE protocolo = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, chamado.getProtocolo());
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
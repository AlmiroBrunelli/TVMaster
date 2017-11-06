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
import model.Cliente;
import model.Contrato;

/**
 *
 * @author Samuel Vieira
 */
public class ClienteDAO {
    public boolean incluirCliente(Cliente cliente) {
        int resposta = 0;
        try {
            String sql = "insert into bdmaster.cliente(nome, email, cpf, telefone) values (?, ?, ?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEmail());
            p.setString(3, cliente.getCpf());
            p.setString(4, cliente.getTelefone());
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
    
    public void pesquisarCliente(Cliente cliente) {
        try {
            String sql = "SELECT * FROM bdmaster.cliente WHERE cpf = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cliente.getCpf());
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarCliente(Cliente cliente) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.cliente SET nome = ?, email = ?, telefone = ? WHERE cpf = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cliente.getNome());
            p.setString(2, cliente.getEmail());
            p.setString(3, cliente.getTelefone());
            p.setString(4, cliente.getCpf());
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
    
    public boolean excluirCliente(Cliente cliente) {
        int resposta = 0;
        try{
            String sql = "DELETE FROM bdmaster.cliente WHERE cpf = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, cliente.getCpf());
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

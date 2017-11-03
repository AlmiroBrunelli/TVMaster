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
            p.setInt(3, Integer.parseInt(cliente.getCpf()));
            p.setInt(4, cliente.getTelefone());
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
            String sql = "select * from bdmaster.cliente where cpf = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, Integer.parseInt(cliente.getCpf()));
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getInt("telefone"));
            } 
        } catch(SQLException e) {
        }
    }
    
}

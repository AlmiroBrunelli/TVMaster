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
import model.Funcionario;

/**
 *
 * @author Samuel Vieira
 */
public class FuncionarioDAO {
    public boolean incluirFuncionario(Funcionario funcionario) {
        int resposta = 0;
        try {
            String sql = "insert into bdmaster.funcionario(matricula, tipo, nome, email, cpf, telefone, cidade) values (?, ?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, funcionario.getMatricula());
            p.setInt(2, funcionario.getTipo());
            p.setString(3, funcionario.getNome());
            p.setString(4, funcionario.getEmail());
            p.setString(5, funcionario.getCpf());
            p.setString(6, funcionario.getTelefone());            
            p.setString(7, funcionario.getCidade());            
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
    
    public void pesquisarFuncionario(Funcionario funcionario) {
        try {
            String sql = "SELECT * FROM bdmaster.funcionario WHERE matricula = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, funcionario.getMatricula());
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                funcionario.setNome(rs.getString("nome"));
                funcionario.setMatricula(rs.getInt("matricula"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setTipo(rs.getInt("tipo"));
                funcionario.setCpf(rs.getString("cpf"));
                funcionario.setTelefone(rs.getString("telefone"));
                funcionario.setCidade(rs.getString("cidade"));
            } 
        } catch(SQLException e) {
        }
    }
    
    public boolean alterarFuncionario(Funcionario funcionario) {
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.funcionario SET nome = ?, tipo = ?, email = ?, telefone = ?, cidade = ? WHERE matricula = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, funcionario.getNome());
            p.setInt(2, funcionario.getTipo());
            p.setString(3, funcionario.getEmail());
            p.setString(4, funcionario.getTelefone());
            p.setString(5, funcionario.getCidade());
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
    
    public boolean excluirFuncionario(Funcionario funcionario) {
        int resposta = 0;
        try{
            String sql = "DELETE FROM bdmaster.funcionario WHERE matricula = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, funcionario.getMatricula());
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
    
    public boolean validarSenha(Funcionario funcionario){
        try {
            Funcionario func = new Funcionario();
            String sql = "SELECT * FROM bdmaster.funcionario WHERE matricula = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, funcionario.getMatricula());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                func.setSenha(rs.getString("senha"));
            }
            if(funcionario.getSenha().equals(func.getSenha())){
                return true;
            }
        } catch(SQLException e) {
        }
        return false;
    }
    
}
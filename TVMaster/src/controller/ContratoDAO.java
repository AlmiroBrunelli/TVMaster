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
    public void pesquisarContrato(Contrato contrato) {
        try{
            String sql = "SELECT * FROM bdmaster.contrato WHERE fk_cliente = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, Integer.parseInt(contrato.getCpf()));
            ResultSet rs = p.executeQuery();
            while(rs.next()) {
                contrato.setCidade(rs.getString("cidade"));
                contrato.adicionarReceptor(rs.getInt("receptores"));
            }
        } catch(SQLException e){
        }
    }
}

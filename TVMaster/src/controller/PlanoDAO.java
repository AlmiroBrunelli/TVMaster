package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Plano;

public class PlanoDAO {
    public boolean incluirPlano(Plano plano){
        int resposta = 0;
        try{
            String sql = "insert into bdmaster.canal(nome, quantidadeCategorias) values(?, ?);";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, plano.getNome());
            p.setString(2, Integer.toString(plano.getQuantidadeCategorias()));
            resposta = p.executeUpdate();
        } catch(SQLException e){  
            throw new RuntimeException(e);
        } finally{
            if (resposta > 0){
                return true;
            } else {
                return false;
            }
        }
    }
    
    public void pesquisarPlano(int numeroContrato, Plano plano){
        try{
            String sql = "SELECT * FROM bdmaster.plano WHERE idplano = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, plano.getTipo());
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                plano.setNome(rs.getString("nome"));
                plano.setQuantidadeCategorias(rs.getInt("quantidadeCategorias"));
                plano.setTipo(rs.getInt("idplano"));
                plano.setDesconto(rs.getFloat("desconto"));
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Plano> listarPlanos(){
        try{
            String sql = "SELECT * FROM bdmaster.canal";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            ResultSet rs = p.executeQuery();
            ArrayList<Plano> planos = new ArrayList<Plano>();
            while(rs.next()){
                Plano plano = new Plano(rs.getFloat("desconto"),
                        rs.getInt("quantidadeCategorias"), rs.getInt("idplano"), 
                        rs.getString("nome"));
                planos.add(plano);
            }
            return planos;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
}

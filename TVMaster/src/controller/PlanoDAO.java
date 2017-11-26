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
            String sql = "select plano.nome, plano.quantidadeCategorias, plano.desconto, plano_contrato.fk_tipo from bdmaster.plano_contrato, bdmaster.plano where plano_contrato.fk_plano_contrato = ? AND plano_contrato.fk_tipo = plano.idplano;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setInt(1, numeroContrato);
            ResultSet rs = p.executeQuery();
            while(rs.next()){
                plano.setNome(rs.getString("nome"));
                plano.setQuantidadeCategorias(rs.getInt("quantidadeCategorias"));
                plano.setTipo(rs.getInt("fk_tipo"));
                plano.setDesconto(rs.getFloat("desconto"));
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
    
    public ArrayList<Plano> listarPlanos(){
        try{
            String sql = "SELECT * FROM bdmaster.plano";
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
    
    public boolean alterarTipoPlano(int numeroContrato, Plano plano){
        int resposta = 0;
        try{
            String sql = "UPDATE bdmaster.plano_contrato SET fk_tipo = (SELECT plano.idplano from bdmaster.plano WHERE plano.nome = ?) WHERE fk_plano_contrato = ?;";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, plano.getNome());
            p.setInt(2, numeroContrato);
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
    
}

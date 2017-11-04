package model;

import controller.ClienteDAO;
import java.util.ArrayList;

public class Cliente extends Pessoa{
    private ArrayList <Contrato> contratos = new ArrayList <Contrato>();

    public Cliente(String nome, String email, String cpf, int telefone, ArrayList<Contrato> contratos) {
        super(nome, email, cpf, telefone);
        this.contratos = contratos;
    }

    public Cliente() {
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }
    
    public void adicionarContrato(Contrato contrato) {
        contratos.add(contrato);
    }
    
    public Contrato pesquisarContrato(int numero) {
        for(Contrato atual : contratos){
            if (atual.getNumero() == numero){
                return atual;
            }
        }
        return null;
    }
    
    public void pesquisar(){
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.pesquisarCliente(this);
    }
    
}

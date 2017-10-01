package model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private ArrayList <Contrato> contratos = new ArrayList <Contrato>();

    public Cliente(String nome, String email, int cpf, int telefone, ArrayList<Contrato> contratos) {
        super(nome, email, cpf, telefone);
        this.contratos = contratos;
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
    
}

package model;

import java.util.ArrayList;

public class Cliente {
    private ArrayList <Contrato> contratos = new ArrayList <Contrato>();

    public Cliente() {
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(Contrato contratos) {
        this.contratos.add(contratos);
    }
    
    public void alterarContratos(int numeroContrato){
        for (Contrato atual : contratos){
            if (atual.numero == numeroContrato){
                
            }
        }
    }
    private Contrato pesquisarContrato(int numero) {
        for(Contrato atual : contratos){
            if (atual.getNumero() == numero){
                return atual;
            }
        }
        return null;
    }
    public String adicionarReceptor(int quantidade, int numero){
        Contrato contrato = pesquisarContrato(numero);
        if ((contrato.getReceptores() + quantidade) <= 4){
            contrato.setReceptores(contrato.getReceptores() + quantidade);
            return "Receptor adicionado com sucesso";
        }
        return "O contrato não pode ter mais que 4 receptores e você já possui " + contrato.getReceptores();
    }
    
    
}

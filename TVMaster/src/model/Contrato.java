package model;

import java.util.ArrayList;

public class Contrato {
    int numero, receptores, estado;
    String endereco, cidade;
    Plano plano;
    ArrayList <Chamado> chamados = new ArrayList<Chamado>();
    ArrayList <Fatura> faturas = new ArrayList<Fatura>();

    public Contrato(int numero, int receptores, String endereco, int estado, String cidade, Plano plano) {
        this.numero = numero;
        this.receptores = receptores;
        this.endereco = endereco;
        this.estado = estado;
        this.cidade = cidade;
        this.plano = plano;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getReceptores() {
        return receptores;
    }

    public void setReceptores(int receptores) {
        this.receptores = receptores;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Plano getPlano() {
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }
    
    public String verificarInadimplencia(){
        int naoPagas = 0;
        for(Fatura atual : faturas){
            if (!atual.isPago()){
                naoPagas ++;
            }
        }
        if (naoPagas >= 3 && this.estado != 1){
            this.estado = 2;        //Estado 0 = ativo,  1 = inativo, 2 = inadimplente
            return "O contrato encontra-se em dívida de " + naoPagas + " parcelas e por este motivo foi bloqueado!";
        }
        if (this.estado != 1){
            this.estado = 0;
            return "O contrato possui " + naoPagas + " parcelas não pagas e está ativo!";
        }
        return "O contrato encontra-se inativo e possui " + naoPagas + " parcelas em atraso!";
        
    }
    
    public void criarFatura(String mes){
        float valor = plano.getPreco();
        Fatura nova = new Fatura(valor, mes);
        faturas.add(nova);
    }
    
    public Fatura buscarFatura(){
        for (Fatura atual : faturas){
            if (!atual.isPago()){
                return atual;
            }
        }
        return null;
    }
    public boolean adicionarReceptor(int quantidade){
        if ((getReceptores() + quantidade) <= 4){
            setReceptores(getReceptores() + quantidade);
            return true;
        }
        return false;
    }
    public boolean removerReceptor(int quantidade){
        if ((getReceptores() - quantidade) >= 1){
            setReceptores(getReceptores() - quantidade);
            return true;
        }
        return false;
    }
    
    public boolean cancelarContrato(){
        if (getEstado() == 1){      //Estado 0 = ativo,  1 = inativo, 2 = inadimplente
            return false;
        }
        setEstado(1);
        return true;
    }
    public boolean reativarContrato(){
        if (getEstado() == 0){      //Estado 0 = ativo,  1 = inativo, 2 = inadimplente
            return false;
        }
        setEstado(0);
        return true;
    }
}

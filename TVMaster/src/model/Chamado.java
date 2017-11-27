package model;

public class Chamado {
    private String motivo, solucao;
    private int data, protocolo, contrato;
    private Funcionario tecnico;
    private boolean situacao;
    private Cliente solicitante;

    public Chamado(String motivo, int data, int protocolo, boolean situacao, Cliente solicitante) {
        this.motivo = motivo;
        this.solucao = solucao;
        this.data = data;
        this.protocolo = protocolo;
        this.situacao = situacao;
        this.solicitante = solicitante;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getContrato() {
        return contrato;
    }

    public void setContrato(int contrato) {
        this.contrato = contrato;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getProtocolo() {
        return protocolo;
    }

    public Funcionario getTecnico() {
        return tecnico;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public Cliente getSolicitante() {
        return solicitante;
    }
    
    public String fecharChamado(){
        if (this.situacao){
            this.situacao = false;
            return "O chamado foi fechado com sucesso!";
        }
        return "O chamado já encontrava-se fechado!";
    }
    
    public void alocarTecnico(Funcionario tecnico){
        this.tecnico = tecnico;
    }
 
}


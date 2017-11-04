package model;

public class Tecnico extends Funcionario{
    private String cidade;

    public Tecnico(String cidade, int matricula, int tipo, String nome, String email, String cpf, int telefone){
        super(matricula, tipo, nome, email, cpf, telefone);
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
}

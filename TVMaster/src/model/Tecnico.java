package model;

public class Tecnico extends Funcionario{
    private String cidade;

    public Tecnico(String cidade, int matricula, int tipo, String nome, String email, int cpf, int telefone){
        super(matricula, tipo, nome, email, cpf, telefone);
        this.cidade = cidade;
    }
}

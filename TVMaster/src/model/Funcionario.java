package model;

public class Funcionario extends Pessoa{
    private int matricula, tipo;
    private String cidade;

    public Funcionario(int matricula, int tipo, String nome, String email, String cpf, String telefone, String cidade) {
        super(nome, email, cpf, telefone);
        this.matricula = matricula;
        this.tipo = tipo;
        this.cidade = cidade;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    
    
}

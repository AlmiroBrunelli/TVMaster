package model;

public class Funcionario extends Pessoa{
    private int matricula, tipo;

    public Funcionario(int matricula, int tipo, String nome, String email, String cpf, int telefone) {
        super(nome, email, cpf, telefone);
        this.matricula = matricula;
        this.tipo = tipo;
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
    
}

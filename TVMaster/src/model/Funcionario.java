package model;

import controller.FuncionarioDAO;

public class Funcionario extends Pessoa{
    private int matricula, tipo;
    private String cidade, senha;

    public Funcionario(int matricula, String senha) {
        this.matricula = matricula;
        this.senha = senha;
    }

    public Funcionario(int matricula, int tipo, String nome, String email, String cpf, String telefone, String cidade) {
        super(nome, email, cpf, telefone);
        this.matricula = matricula;
        this.tipo = tipo;
        this.cidade = cidade;
    }

    public Funcionario() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
    
    public boolean validar(){
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.validarSenha(this);
    }
}

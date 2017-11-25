package model;

import controller.PlanoDAO;
import java.util.ArrayList;
import static tvmaster.TVMaster.format;

public class Plano {
    private float desconto, preco;
    protected ArrayList<Categoria> categorias;
    private String nome;
    private int tipo, quantidadeCategorias;

    public Plano(float desconto, int quantidadeCategorias, int tipo, String nome) {
        this.desconto = desconto;
        this.quantidadeCategorias = quantidadeCategorias;
        this.tipo = tipo;
        this.nome = nome;
    }

    public Plano() {
    }

    public int getQuantidadeCategorias() {
        return quantidadeCategorias;
    }

    public void setQuantidadeCategorias(int quantidadeCategorias) {
        this.quantidadeCategorias = quantidadeCategorias;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    protected void setPreco(float preco) {
        this.preco = preco;
    }
    private Categoria pesquisarCategoria(String nome) {
        for(Categoria atual : categorias){
            if (atual.getNome().equals(nome)){
                return atual;
            }
        }
        return null;
    }
    
    public boolean adicionarCategoria(Categoria categoria) {
        if(pesquisarCategoria(categoria.getNome()) == null && categorias.size() < quantidadeCategorias){
            categorias.add(categoria);
            setPreco(calcularPreco());
            return true;
        }
        System.out.println("O limite de categorias foi atingido!");
        return false;
    }
    
    public boolean removerCategoria(Categoria categoria) {
        Categoria categoriaArray = pesquisarCategoria(categoria.getNome());
        if(categoriaArray != null) {
            categorias.remove(categoriaArray);
            setPreco(calcularPreco());
            return true;
        }
        return false;
    }
    public float calcularPreco() {
        float totalPlano = 0f;
        for(Categoria atual : categorias) {
            totalPlano += atual.getPreco();
        }
        // retirar format depois dos testes
        System.out.println("Desconto: " + format((totalPlano * desconto)));
        return (totalPlano - (totalPlano * desconto));
    }
    
    public void pesquisar(int numeroContrato){
        PlanoDAO planoDAO = new PlanoDAO();
        planoDAO.pesquisarPlano(numeroContrato, this);
    }
    
    public ArrayList<Plano> listar(){
        PlanoDAO planoDAO = new PlanoDAO();
        return planoDAO.listarPlanos();
    }
}

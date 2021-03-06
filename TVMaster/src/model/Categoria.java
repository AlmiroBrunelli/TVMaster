package model;

import controller.CategoriaDAO;
import java.util.ArrayList;

public class Categoria {
    private String nome;
    private float preco;
    private int id;
    private ArrayList<Canal> canais;

    public Categoria() {
    }
    
    public Categoria(String nome){
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Categoria(String nome, ArrayList<Canal> canais){
        this.nome = nome;
        this.canais = canais;
        calcularPreco();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void calcularPreco() {
        float total = 0f;
        for(Canal atual : canais) {
            total += atual.getPreco();
        }
        this.preco = total;
    }
    
    private Canal pesquisarCanal(String nome) {
        for(Canal atual : canais){
            if (atual.getNome().equals(nome)){
                return atual;
            }
        }
        return null;
    }
    
    public boolean adicionarCanal(Canal canal) {
        if(pesquisarCanal(canal.getNome()) == null){
            canais.add(canal);
            calcularPreco();
            return true;
        }
        return false;
    }
    
    public boolean removerCanal(Canal canal) {
        Canal canalArray = pesquisarCanal(canal.getNome());
        if(canalArray != null) {
            canais.remove(canalArray);
            calcularPreco();
            return true;
        }
        return false;
    }
    
    public ArrayList<Categoria> listar(int numeroContrato){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.listarCategoriasContrato(numeroContrato);
    }
    
    public boolean adicionar(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.incluirCategoria(this);
    }
    
    public void pesquisar(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        categoriaDAO.pesquisarCategoria(this);
    }
    
    public boolean excluir(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.excluirCategoria(this);
    }
    
    public boolean atualizar(){
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        return categoriaDAO.alterarCategoria(this);
    }
}

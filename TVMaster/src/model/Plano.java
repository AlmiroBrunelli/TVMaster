package model;

import java.util.ArrayList;
import static tvmaster.TVMaster.format;

public abstract class Plano {
    private final float desconto;
    protected ArrayList<Categoria> categorias;
    private float preco;
    private int tipo;

    public Plano(float preco, final float desconto) {
        this.preco = preco;
        this.desconto = desconto;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
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
        if(pesquisarCategoria(categoria.getNome()) == null && categorias.size() < 3){
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
}

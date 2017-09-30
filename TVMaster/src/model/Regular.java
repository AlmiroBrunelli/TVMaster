package model;

import java.util.ArrayList;

public class Regular extends PlanoDeCategoria{
    
    public Regular(ArrayList<Categoria> categorias, float desconto){
        super(desconto, categorias);
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
        if(pesquisarCategoria(categoria.getNome()) == null && super.categorias.size() < 3){
            super.categorias.add(categoria);
            super.setPreco(calcularDesconto());
            return true;
        }
        System.out.println("O limite de categorias foi atingido!");
        return false;
    }
    
    public boolean removerCategoria(Categoria categoria) {
        Categoria categoriaArray = pesquisarCategoria(categoria.getNome());
        if(categoriaArray != null) {
            categorias.remove(categoriaArray);
            super.setPreco(calcularDesconto());
            return true;
        }
        return false;
    }
    
}

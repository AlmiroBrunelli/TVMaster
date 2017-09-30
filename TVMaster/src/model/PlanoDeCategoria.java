package model;

import java.util.ArrayList;
import static model.TVMaster.format;

public abstract class PlanoDeCategoria extends Plano{
    private final float desconto;
    protected ArrayList<Categoria> categorias;

    public PlanoDeCategoria(float desconto, ArrayList<Categoria> categorias) {
        super(0);
        this.desconto = desconto;
        this.categorias = categorias;
        super.setPreco(calcularDesconto());
    }
    
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
  
    public float calcularDesconto() {
        float totalPlano = 0f;
        for(Categoria atual : categorias) {
            totalPlano += atual.getPreco();
        }
        // retirar format depois dos testes
        System.out.println("Desconto: " + format((totalPlano * desconto)));
        return (totalPlano - (totalPlano * desconto));
    }
    
}

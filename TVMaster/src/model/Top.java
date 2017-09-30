package model;

import java.util.ArrayList;

public class Top extends Plano{
    ArrayList<Canal> canais;

    public Top(ArrayList<Canal> canais) {
        super(0);
        this.canais = canais;
        super.setPreco(calcularPreco());
    }

    public ArrayList<Canal> getCanais() {
        return canais;
    }
    
    private Canal pesquisarCanal(String nome) {
        for(Canal atual : canais){
            if(atual.getNome().equals(nome)){
                return atual;
            }
        }
        return null;
    }
    
    public boolean adicionarCanal(Canal canal) {
        if(pesquisarCanal(canal.getNome()) == null) {
            this.canais.add(canal);
            super.setPreco(calcularPreco());
            return true;
        }
        return false;
    }
    
    public boolean removerCanal(Canal canal) {
        Canal canalArray = pesquisarCanal(canal.getNome());
        if(canalArray != null) {
            this.canais.remove(canalArray);
            super.setPreco(calcularPreco());
            return true;
        }
        return false;
    }
    
    private float calcularPreco() {
        float totalPlano = 0f;
        for(Canal atual : canais) {
            totalPlano += atual.getPreco();
        }
        return totalPlano;
    }
    
}

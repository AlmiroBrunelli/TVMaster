package model;

public abstract class Plano {
    private float preco;

    public Plano(float preco) {
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    protected void setPreco(float preco) {
        this.preco = preco;
    }
    
}

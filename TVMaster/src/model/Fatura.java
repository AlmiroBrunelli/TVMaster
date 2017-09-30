package model;

public class Fatura {
    private float valor;
    private int numero;
    private String mes;
    private boolean pago;

    public Fatura(float valor, String mes) {
        this.valor = valor;
        this.mes = mes;
        this.pago = false;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public boolean isPago() {
        return pago;
    }

    public String setPago() {
        if(this.pago){
            return "A fatura já havia sido paga!";
        }
        this.pago = true;
        return "Fatura paga com sucesso!";
    }
    
}

package model;

public class ItensVenda {
    private Produto produto;
    private int quantidade;
    private double precoUnitario;
    private double precoTotal;

    public ItensVenda(Produto produto,int quantidade,double precoUnitario,double precoTotal) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.precoTotal = precoTotal;

    }
}
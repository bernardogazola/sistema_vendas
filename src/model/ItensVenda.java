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

    // REVER
    private double calcularPrecoTotal() {
        return this.quantidade * this.precoUnitario;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public void setPrecoTotal(double precoTotal) {
        this.precoTotal = precoTotal;
    }
}
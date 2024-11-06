package model;

public class Produto {
    private int idProduto;
    private String nome;
    private double preco;
    private int quantidadeEstoque;

    public Produto(int idProduto,String nome,double preco,int quantidadeEstoque) {
        this.idProduto = idProduto;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;


    }
}
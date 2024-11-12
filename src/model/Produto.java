package model;

import exception.EstoqueInsuficienteException;

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

    public String toCSV() {
        return idProduto + "," + nome + "," + preco + "," + quantidadeEstoque;
    }

    public static Produto fromCSV(String csvLinha) {
        String[] dados = csvLinha.split(",");
        return new Produto(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]), Integer.parseInt(dados[3]));
    }

    public void atualizarEstoque(int quantidade) throws EstoqueInsuficienteException {
        if (quantidadeEstoque < quantidade) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto " + nome);
        }
        quantidadeEstoque -= quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
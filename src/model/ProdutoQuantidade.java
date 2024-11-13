package model;

import javax.swing.*;

public class ProdutoQuantidade {
    private Produto produto;
    private JTextField quantidadeField;

    public ProdutoQuantidade(Produto produto, JTextField quantidadeField) {
        this.produto = produto;
        this.quantidadeField = quantidadeField;
    }

    public Produto getProduto() {
        return produto;
    }

    public JTextField getQuantidadeField() {
        return quantidadeField;
    }
}
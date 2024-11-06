package model;

import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Venda> historicoCompras;
    private String email;
    private int pontosFidelidade;

    public Cliente(int id, String nome, String cpf, String telefone, String email, int pontosFidelidade) {
        super(id,nome,cpf,telefone);
        this.email = email;
        this.historicoCompras = new ArrayList<>();
        this.pontosFidelidade = pontosFidelidade;

    }
}
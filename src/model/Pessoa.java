package model;

public abstract class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;

    public Pessoa(int id,String nome,String cpf,String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;

    }
}
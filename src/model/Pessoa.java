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

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public abstract void exibirInfo();
}
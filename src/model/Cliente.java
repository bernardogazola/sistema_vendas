package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private String email;

    public Cliente(int id, String nome, String cpf, String telefone, String email) {
        super(id,nome,cpf,telefone);
        this.email = email;
    }

    @Override
    public String exibirInfo() {
        return "Cliente: " + getNome() + " | CPF: " + getCpf() + " | Email: " + email;
    }

    public String toCSV() {
        return getId() + "," + getNome() + "," + getCpf() + "," + getTelefone() + "," + email;
    }

    public static Cliente fromCSV(String csvLinha) {
        String[] dados = csvLinha.split(",");
        return new Cliente(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4]);
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }

}
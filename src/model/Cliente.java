package model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa {
    private ArrayList<Venda> historicoCompras;
    private String email;
    private int pontosFidelidade;

    public Cliente(int id, String nome, String cpf, String telefone, String email) {
        super(id,nome,cpf,telefone);
        this.email = email;
        this.historicoCompras = new ArrayList<>();
        this.pontosFidelidade = 0;

    }

    public ArrayList<Venda> getHistoricoCompras() {
        return historicoCompras;
    }

    public String getEmail() {
        return email;
    }

    public int getPontosFidelidade() {
        return pontosFidelidade;
    }

    public void adicionarCompra(Venda venda) {
        historicoCompras.add(venda);
    }

    @Override
    public String exibirInfo() {
        return "Cliente: " + getNome() + " | CPF: " + getCpf() + " | Email: " + email;
    }

    public String toCSV() {
        return getId() + "," + getNome() + "," + getCpf() + "," + getTelefone() + "," + email + "," + pontosFidelidade;
    }

    public static Cliente fromCSV(String csvLinha) {
        String[] dados = csvLinha.split(",");
        return new Cliente(Integer.parseInt(dados[0]), dados[1], dados[2], dados[3], dados[4]);
    }

    public static int getUltimoId(List<Cliente> clientes) {
        return clientes.size();
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }

}
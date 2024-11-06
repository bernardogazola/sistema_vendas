package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Vendedor extends Funcionario {
    private double metaMensal;
    private ArrayList<Venda> vendasRealizadas;

    public Vendedor(int id, String nome, String cpf, String telefone, double salario, LocalDate dataContratacao,double metaMensal) {
        super(id, nome, cpf, telefone, salario, dataContratacao);
        this.metaMensal = metaMensal;
        this.vendasRealizadas = new ArrayList<>();
    }

    public double getMetaMensal() {
        return metaMensal;
    }
    public ArrayList<Venda> getVendasRealizadas() {
        return vendasRealizadas;
    }

    public void registrarVenda(Venda venda) {
        vendasRealizadas.add(venda);
    }

    @Override
    public double calcularComissao(Venda venda) {
        return venda.getTotal() * 0.05;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Vendedor: " + getNome() + " | CPF: " + getCpf() + " | Meta Mensal: " + metaMensal);
    }
}
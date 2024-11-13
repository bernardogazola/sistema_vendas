package model;

import java.time.LocalDate;

public class Vendedor extends Funcionario {
    private double metaMensal;

    public Vendedor(int id, String nome, String cpf, String telefone, double salario, LocalDate dataContratacao,double metaMensal) {
        super(id, nome, cpf, telefone, salario, dataContratacao);
        this.metaMensal = metaMensal;
    }

    public double getMetaMensal() {
        return metaMensal;
    }

    @Override
    public double calcularComissao(Venda venda) {
        return venda.getTotal() * 0.05;
    }

    @Override
    public String exibirInfo() {
       return "Vendedor: " + getNome() + " | CPF: " + getCpf() + " | Meta Mensal: " + metaMensal;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome();
    }
}
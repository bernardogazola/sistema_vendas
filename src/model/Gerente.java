package model;

import java.time.LocalDate;

public class Gerente extends Funcionario {
    private double bonusMensal;

    public Gerente(int id, String nome, String cpf, String telefone, double salario, LocalDate dataContratacao,double bonusMensal) {
        super(id, nome, cpf, telefone, salario, dataContratacao);
        this.bonusMensal = bonusMensal;
    }

    public double getBonusMensal() {
        return bonusMensal;
    }

    @Override
    public double calcularComissao(Venda venda) {
        return venda.getTotal() * 0.1;
    }

    @Override
    public String exibirInfo() {
        return "Gerente: " + getNome() + " | Bônus Mensal: " + bonusMensal;
    }
}

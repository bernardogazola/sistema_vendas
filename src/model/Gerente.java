package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Gerente extends Funcionario {
    private double bonusMensal;
    private ArrayList<Vendedor> vendedoresSupervisionados;

    public Gerente(int id, String nome, String cpf, String telefone, double salario, LocalDate dataContratacao,double bonusMensal) {
        super(id, nome, cpf, telefone, salario, dataContratacao);
        this.bonusMensal = bonusMensal;
        this.vendedoresSupervisionados = new ArrayList<>();
    }

    public double getBonusMensal() {
        return bonusMensal;
    }

    @Override
    public double calcularComissao(Venda venda) {
        return venda.getTotal() * 0.1;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Gerente: " + getNome() + " | Bônus Mensal: " + bonusMensal);
    }
}

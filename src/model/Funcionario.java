package model;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
    private double salario;
    private LocalDate dataContratacao;

    public Funcionario(int id,String nome,String cpf,String telefone,double salario,LocalDate dataContratacao) {
        super(id,nome,cpf,telefone);
        this.salario = salario;
        this.dataContratacao = dataContratacao;
    }

    public double getSalario() {
        return salario;
    }
    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public double calcularComissao(Venda venda) {
        return venda.getTotal() * 0.03;
    }

    @Override
    public String exibirInfo() {
        return "Funcionario: " + getNome() + " | CPF: " + getCpf() + " | Salário: " + salario;
    }
}
import java.time.LocalDate;

public abstract class Funcionario extends Pessoa {
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

    @Override
    public void exibirInfo() {
        System.out.println("Funcionario: " + getNome() + " | CPF: " + getCpf() + " | Salario: " + getSalario());
    }

    public abstract double calcularComissao(Venda venda);
}
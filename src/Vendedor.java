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

    // EM DESENVOLVIMENTO
    @Override
    public double calcularComissao(Venda venda) {
        // EM DESENVOLVIMENTO
        return 0;
    }
}
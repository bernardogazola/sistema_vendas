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
}

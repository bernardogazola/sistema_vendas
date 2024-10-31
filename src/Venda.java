import java.time.LocalDate;
import java.util.ArrayList;

public class Venda {
    private int idVenda;
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<ItensVenda> itensVenda;
    private double total;
    private LocalDate dataVenda;

    public Venda(int idVenda,Cliente cliente,Funcionario funcionario,double total,LocalDate dataVenda) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.itensVenda = new ArrayList<>();
        this.total = total;
        this.dataVenda = dataVenda;
    }
}
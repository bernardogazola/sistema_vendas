import java.util.ArrayList;

public class Cliente extends Pessoa {
    private ArrayList<Venda> historicoCompras;
    private String email;
    private int pontosFidelidade;

    public Cliente(int id, String nome, String cpf, String telefone, String email, int pontosFidelidade) {
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
    public void exibirInfo() {
        System.out.println("Cliente: " + getNome() + " | CPF: " + getCpf() + " | Email: " + email);
    }
}
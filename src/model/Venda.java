package model;

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
    public void adicionarItem(ItensVenda item, boolean atualizarTotal) {
        itensVenda.add(item);
        if (atualizarTotal) {
            total += item.getPrecoTotal();
        }
    }

    public double getTotal() {
        return total;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public ArrayList<ItensVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(ArrayList<ItensVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }
}
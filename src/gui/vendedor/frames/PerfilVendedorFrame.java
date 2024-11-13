package gui.vendedor.frames;

import filemanager.FileManager;
import model.Venda;
import model.Vendedor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PerfilVendedorFrame extends JFrame {

    public PerfilVendedorFrame(Vendedor vendedor) {
        setTitle("Perfil do Vendedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel perfilPanel = new JPanel();
        perfilPanel.setLayout(new BoxLayout(perfilPanel, BoxLayout.Y_AXIS));
        perfilPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        perfilPanel.add(new JLabel(vendedor.exibirInfo()));
        perfilPanel.add(new JLabel("Telefone: " + vendedor.getTelefone()));
        perfilPanel.add(new JLabel("Salário: R$ " + vendedor.getSalario()));
        perfilPanel.add(new JLabel("Data de Contratação: " + vendedor.getDataContratacao()));

        double totalVendas = 0.0;
        double totalComissao = 0.0;
        try {
            List<Venda> vendas = FileManager.lerVendasDoVendedor(vendedor.getId());
            for (Venda venda : vendas) {
                totalVendas += venda.getTotal();
                totalComissao += vendedor.calcularComissao(venda);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar vendas: " + e.getMessage());
        }

        perfilPanel.add(new JLabel("Total de Vendas: R$ " + totalVendas));

        double progresso = (totalVendas / vendedor.getMetaMensal()) * 100;
        double restante = vendedor.getMetaMensal() - totalVendas;
        String status = restante > 0 ? "Falta R$ " + restante + " para atingir a meta." : "Meta atingida!";

        JLabel progressoLabel = new JLabel(String.format("Progresso: %.2f%% (%s)", progresso, status));
        perfilPanel.add(progressoLabel);

        perfilPanel.add(new JLabel(String.format("Total de Comissão: R$ %.2f", totalComissao)));

        add(perfilPanel, BorderLayout.CENTER);
    }
}

package gui.gerente.frames;

import filemanager.venda.VendaFileManager;
import model.Gerente;
import model.Venda;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class PerfilGerenteFrame extends JFrame {

    public PerfilGerenteFrame(Gerente gerente) {
        setTitle("Perfil do Gerente");
        setSize(425, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel perfilPanel = new JPanel();
        perfilPanel.setLayout(new BoxLayout(perfilPanel, BoxLayout.Y_AXIS));
        perfilPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        perfilPanel.add(new JLabel(gerente.exibirInfo()));
        perfilPanel.add(new JLabel("CPF: " + gerente.getCpf()));
        perfilPanel.add(new JLabel("Telefone: " + gerente.getTelefone()));
        perfilPanel.add(new JLabel("Salário: R$ " + gerente.getSalario()));
        perfilPanel.add(new JLabel("Data de Contratação: " + gerente.getDataContratacao()));
        perfilPanel.add(new JLabel("Bônus Mensal: R$ " + gerente.getBonusMensal()));

        double totalVendas = 0.0;
        double totalComissao = 0.0;

        try {
            VendaFileManager vendaFileManager = new VendaFileManager();
            List<Venda> vendas = vendaFileManager.lerVendasDoFuncionario(gerente.getId());

            for (Venda venda : vendas) {
                totalVendas += venda.getTotal();
                totalComissao += gerente.calcularComissao(venda);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar vendas: " + e.getMessage());
        }

        perfilPanel.add(new JLabel("Total de Vendas: R$ " + totalVendas));
        perfilPanel.add(new JLabel(String.format("Total de Comissão: R$ %.2f", totalComissao)));

        add(perfilPanel, BorderLayout.CENTER);
    }
}


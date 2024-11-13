package gui.vendedor.frames;

import filemanager.venda.VendaFileManager;
import model.Venda;
import model.Vendedor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class HistoricoVendasFrame extends JFrame {

    public HistoricoVendasFrame(Vendedor vendedor) {
        setTitle("Histórico de Vendas");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Histórico de Vendas de " + vendedor.getNome(), JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel vendasPanel = new JPanel();
        vendasPanel.setLayout(new BoxLayout(vendasPanel, BoxLayout.Y_AXIS));

        try {
            VendaFileManager vendaFileManager = new VendaFileManager();
            List<Venda> vendas = vendaFileManager.lerVendasDoVendedor(vendedor.getId());

            if (vendas.isEmpty()) {
                vendasPanel.add(new JLabel("Nenhuma venda encontrada."));
            } else {
                for (Venda venda : vendas) {
                    String vendaInfo = "ID: " + venda.getIdVenda() + " | Total: R$" + venda.getTotal() + " | Data: " + venda.getDataVenda();
                    JLabel lblVenda = new JLabel(vendaInfo);
                    vendasPanel.add(lblVenda);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar histórico de vendas: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(vendasPanel);
        add(scrollPane, BorderLayout.CENTER);
    }
}

package gui.gerente.frames;

import filemanager.usuario.VendedorFileManager;
import filemanager.venda.VendaFileManager;
import model.Gerente;
import model.Venda;
import model.Vendedor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class HistoricoVendasFrame extends JFrame {

    private JComboBox<Vendedor> vendedorComboBox;
    private JPanel vendasPanel;

    public HistoricoVendasFrame(Gerente gerente) {

        setTitle("Histórico de Vendas");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Histórico de Vendas", JLabel.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(lblTitulo, BorderLayout.NORTH);

        JPanel topPanel = new JPanel(new FlowLayout());
        JButton btnVerMeuHistorico = new JButton("Ver Meu Histórico");
        btnVerMeuHistorico.addActionListener(e -> carregarHistoricoVendas(gerente.getId(), gerente.getNome()));
        topPanel.add(btnVerMeuHistorico);

        topPanel.add(new JLabel("Selecionar Vendedor:"));
        vendedorComboBox = new JComboBox<>();

        try {
            VendedorFileManager vendedorFileManager = new VendedorFileManager();
            List<Vendedor> vendedores = vendedorFileManager.ler();
            for (Vendedor vendedor : vendedores) {
                vendedorComboBox.addItem(vendedor);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar vendedores: " + e.getMessage());
        }

        topPanel.add(vendedorComboBox);

        JButton btnCarregarHistorico = new JButton("Ver Histórico do Vendedor");
        btnCarregarHistorico.addActionListener(e -> {
            Vendedor vendedorSelecionado = (Vendedor) vendedorComboBox.getSelectedItem();
            if (vendedorSelecionado != null) {
                carregarHistoricoVendas(vendedorSelecionado.getId(), vendedorSelecionado.getNome());
            }
        });
        topPanel.add(btnCarregarHistorico);

        add(topPanel, BorderLayout.NORTH);

        vendasPanel = new JPanel();
        vendasPanel.setLayout(new BoxLayout(vendasPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(vendasPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void carregarHistoricoVendas(int idFuncionario, String funcionarioNome) {
        vendasPanel.removeAll();

        try {
            VendaFileManager vendaFileManager = new VendaFileManager();
            List<Venda> vendas = vendaFileManager.lerVendasDoFuncionario(idFuncionario);

            if (vendas.isEmpty()) {
                vendasPanel.add(new JLabel("Nenhuma venda encontrada para " + funcionarioNome + "."));
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

        vendasPanel.revalidate();
        vendasPanel.repaint();
    }
}
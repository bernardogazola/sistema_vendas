package gui.gerente;
import gui.MainFrame;
import gui.cliente.ClienteCadastroFrame;
import gui.gerente.frames.*;
import model.Gerente;

import javax.swing.*;

public class GerenteDashboardFrame extends JFrame {
    public GerenteDashboardFrame(Gerente gerente) {
        setTitle("Dashboard - Gerente");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem-vindo, Gerente " + gerente.getNome());
        lblBemVindo.setBounds(50, 50, 300, 30);
        add(lblBemVindo);

        JButton btnCadastroCliente = new JButton("Cadastrar Cliente");
        btnCadastroCliente.setBounds(50, 100, 300, 30);
        btnCadastroCliente.addActionListener(e -> new ClienteCadastroFrame().setVisible(true));

        JButton btnCadastrarVendedor = new JButton("Cadastrar vendedor");
        btnCadastrarVendedor.setBounds(50, 150, 300, 30);
        btnCadastrarVendedor.addActionListener(e -> new CadastrarVendedorFrame().setVisible(true));

        JButton btnRealizarVenda = new JButton("Realizar Venda");
        btnRealizarVenda.setBounds(50, 200, 300, 30);
        btnRealizarVenda.addActionListener(e -> new VendaGerenteFrame(gerente).setVisible(true));

        JButton btnEstoqueProdutos = new JButton("Estoque Produtos");
        btnEstoqueProdutos.setBounds(50, 250, 300, 30);
        btnEstoqueProdutos.addActionListener(e -> new ProdutoEstoqueFrame().setVisible(true));

        JButton btnHistoricoVendas = new JButton("Histórico de Vendas");
        btnHistoricoVendas.setBounds(50, 300, 300, 30);
        btnHistoricoVendas.addActionListener(e -> new HistoricoVendasFrame(gerente).setVisible(true));

        JButton btnVerPerfil = new JButton("Ver Perfil");
        btnVerPerfil.setBounds(50, 350, 300, 30);
        btnVerPerfil.addActionListener(e -> new PerfilGerenteFrame(gerente).setVisible(true));

        add(btnCadastroCliente);
        add(btnCadastrarVendedor);
        add(btnRealizarVenda);
        add(btnEstoqueProdutos);
        add(btnHistoricoVendas);
        add(btnVerPerfil);

        // LOGOUT
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(50, 400, 300, 30);
        btnLogout.addActionListener(e -> {
            dispose();
            new MainFrame().setVisible(true);
        });
        add(btnLogout);
    }
}

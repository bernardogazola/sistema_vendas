package gui;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Sistema de Gestão de Vendas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JButton btnLoginGerente = new JButton("Entrar como Gerente");
        btnLoginGerente.setBounds(50, 30, 300, 30);
        btnLoginGerente.addActionListener(e -> new GerenteDashboardFrame().setVisible(true));

        JButton btnLoginVendedor = new JButton("Entrar como Vendedor");
        btnLoginVendedor.setBounds(50, 80, 300, 30);
        btnLoginVendedor.addActionListener(e -> new VendedorDashboardFrame().setVisible(true));

        JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
        btnCadastrarCliente.setBounds(50, 130, 300, 30);
        btnCadastrarCliente.addActionListener(e -> new ClienteCadastroFrame().setVisible(true));

        add(btnLoginGerente);
        add(btnLoginVendedor);
        add(btnCadastrarCliente);
    }
}
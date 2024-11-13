package gui.gerente;
import gui.MainFrame;
import gui.gerente.frames.EstoqueGerenciamentoFrame;
import gui.gerente.frames.ProdutoEstoqueFrame;
import model.Gerente;

import javax.swing.*;

public class GerenteDashboardFrame extends JFrame {
    public GerenteDashboardFrame(Gerente gerente) {
        setTitle("Dashboard - Gerente");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem-vindo, Gerente " + gerente.getNome());
        lblBemVindo.setBounds(50, 50, 300, 30);
        add(lblBemVindo);

        JButton btnCadastrarVendedor = new JButton("Cadastrar vendedor");
        btnCadastrarVendedor.setBounds(75, 100, 150, 30);
        //btnCadastrarVendedor.addActionListener(e -> );

        JButton btnAdicionarProduto = new JButton("Adicionar produto");
        btnAdicionarProduto.setBounds(75, 150, 150, 30);
        btnAdicionarProduto.addActionListener(e -> new EstoqueGerenciamentoFrame().setVisible(true));

        JButton btnEstoqueProdutos = new JButton("Estoque Produtos");
        btnEstoqueProdutos.setBounds(75, 200, 150, 30);
        btnEstoqueProdutos.addActionListener(e -> new ProdutoEstoqueFrame().setVisible(true));

        add(btnCadastrarVendedor);
        add(btnAdicionarProduto);
        add(btnEstoqueProdutos);

        // LOGOUT
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(50, 250, 300, 30);
        btnLogout.addActionListener(e -> {
            dispose();
            new MainFrame().setVisible(true);
        });
        add(btnLogout);
    }
}

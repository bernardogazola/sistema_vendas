package gui.vendedor;
import gui.MainFrame;
import gui.cliente.ClienteCadastroFrame;
import gui.vendedor.frames.HistoricoVendasFrame;
import gui.vendedor.frames.PerfilVendedorFrame;
import gui.vendedor.frames.VendaFrame;
import model.Vendedor;

import javax.swing.*;

public class VendedorDashboardFrame extends JFrame {
    public VendedorDashboardFrame(Vendedor vendedor) {
        setTitle("Dashboard - Vendedor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem-vindo, Vendedor " + vendedor.getNome());
        lblBemVindo.setBounds(50, 50, 300, 30);
        add(lblBemVindo);

        JButton btnCadastroCliente = new JButton("Cadastrar Cliente");
        btnCadastroCliente.setBounds(50, 100, 300, 30);
        btnCadastroCliente.addActionListener(e -> new ClienteCadastroFrame().setVisible(true));

        JButton btnRealizarVenda = new JButton("Realizar Venda");
        btnRealizarVenda.setBounds(50, 150, 300, 30);
        btnRealizarVenda.addActionListener(e -> new VendaFrame(vendedor).setVisible(true));

        JButton btnHistoricoVendas = new JButton("Histórico de Vendas");
        btnHistoricoVendas.setBounds(50, 200, 300, 30);
        btnHistoricoVendas.addActionListener(e -> new HistoricoVendasFrame(vendedor).setVisible(true));

        JButton btnVerPerfil = new JButton("Ver Perfil");
        btnVerPerfil.setBounds(50, 250, 300, 30);
        btnVerPerfil.addActionListener(e -> new PerfilVendedorFrame(vendedor).setVisible(true));
        add(btnVerPerfil);

        add(btnCadastroCliente);
        add(btnRealizarVenda);
        add(btnHistoricoVendas);

        //LOGOUT
        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(50, 300, 300, 30);
        btnLogout.addActionListener(e -> {
            dispose();
            new MainFrame().setVisible(true);
        });
        add(btnLogout);
    }
}

package gui.vendedor;
import model.Vendedor;

import javax.swing.*;

public class VendedorDashboardFrame extends JFrame {
    public VendedorDashboardFrame(Vendedor vendedor) {
        setTitle("Dashboard - Vendedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem-vindo, Vendedor " + vendedor.getNome());
        lblBemVindo.setBounds(50, 50, 300, 30);
        add(lblBemVindo);

        JButton btnRealizarVenda = new JButton("Realizar Venda");
        btnRealizarVenda.setBounds(50, 100, 300, 30);
        btnRealizarVenda.addActionListener(e -> {
            //new VendaFrame().setVisible(true);
        });

        add(btnRealizarVenda);
    }
}

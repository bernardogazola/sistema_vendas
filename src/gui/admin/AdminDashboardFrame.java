package gui.admin;

import gui.MainFrame;
import gui.admin.frames.RegistroFrame;

import javax.swing.*;

public class AdminDashboardFrame extends JFrame {
    public AdminDashboardFrame() {
        setTitle("Dashboard - Admin");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblBemVindo = new JLabel("Bem-vindo, Administrador");
        lblBemVindo.setBounds(50, 50, 300, 30);
        add(lblBemVindo);

        JButton btnRegistrarUsuario = new JButton("Registrar Usuário");
        btnRegistrarUsuario.setBounds(75, 100, 150, 30);
        btnRegistrarUsuario.addActionListener(e -> new RegistroFrame().setVisible(true));

        add(btnRegistrarUsuario);


        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(75, 150, 150, 30);
        btnLogout.addActionListener(e -> {
            dispose();
            new MainFrame().setVisible(true);
        });
        add(btnLogout);
    }
}
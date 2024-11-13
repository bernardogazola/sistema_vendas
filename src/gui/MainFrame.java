package gui;

import filemanager.FileManager;
import gui.admin.AdminDashboardFrame;
import gui.gerente.GerenteDashboardFrame;
import gui.vendedor.VendedorDashboardFrame;
import model.Gerente;
import model.Vendedor;

import javax.swing.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class MainFrame extends JFrame {

    public MainFrame() {
        setTitle("Login do Sistema de Gestão de Vendas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lblUsername = new JLabel("Usuário:");
        lblUsername.setBounds(50, 30, 100, 25);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 30, 200, 25);

        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(50, 70, 100, 25);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 70, 200, 25);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(150, 110, 100, 30);
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (Objects.equals(username, "admin") && password.equals("admin")) {
                dispose();
                AdminDashboardFrame adminDashboardFrame = new AdminDashboardFrame();
                adminDashboardFrame.setVisible(true);
            } else {
                try {
                    Object usuario = autenticar(username, password);
                    if (usuario instanceof Gerente) {
                        GerenteDashboardFrame gerenteFrame = new GerenteDashboardFrame((Gerente) usuario);
                        gerenteFrame.setVisible(true);
                        dispose();
                    } else if (usuario instanceof Vendedor) {
                        VendedorDashboardFrame vendedorFrame = new VendedorDashboardFrame((Vendedor) usuario);
                        vendedorFrame.setVisible(true);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos.");
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao acessar o arquivo de login: " + ex.getMessage());
                }
            }

        });

        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);
    }

    private Object autenticar(String username, String password) throws IOException {
        List<String> logins = FileManager.lerDados("logins.txt");
        for (String linha : logins) {
            String[] partes = linha.split(",");
            if (partes.length == 4) {
                int id = Integer.parseInt(partes[0]);
                String tipo = partes[1];
                String loginUsuario = partes[2];
                String senha = partes[3];

                if (loginUsuario.equals(username) && senha.equals(password)) {
                    if (tipo.equals("Gerente")) {
                        return buscarGerente(id);
                    } else if (tipo.equals("Vendedor")) {
                        return buscarVendedor(id);
                    }
                }
            }
        }
        return null;
    }

    private Gerente buscarGerente(int id) throws IOException {
        List<Gerente> gerentes = FileManager.lerGerentes();
        for (Gerente gerente : gerentes) {
            if (gerente.getId() == id) {
                return gerente;
            }
        }
        return null;
    }

    private Vendedor buscarVendedor(int id) throws IOException {
        List<Vendedor> vendedores = FileManager.lerVendedores();
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null;
    }
}


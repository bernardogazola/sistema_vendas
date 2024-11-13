package gui;

import filemanager.usuario.GerenteFileManager;
import filemanager.usuario.UsuarioFileManager;
import filemanager.usuario.VendedorFileManager;
import gui.admin.AdminDashboardFrame;
import gui.gerente.GerenteDashboardFrame;
import gui.vendedor.VendedorDashboardFrame;
import model.Credencial;
import model.Funcionario;
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
        setLocationRelativeTo(null);
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

    private Funcionario autenticar(String username, String password) throws IOException {
        UsuarioFileManager usuarioFileManager = new UsuarioFileManager();
        List<Credencial> credenciais = usuarioFileManager.ler();

        for (Credencial credencial : credenciais) {
            if (credencial.getUsername().equals(username) && credencial.getPassword().equals(password)) {
                int id = credencial.getId();
                String tipo = credencial.getTipo();
                if ("Gerente".equals(tipo)) {
                    return buscarGerente(id);
                } else if ("Vendedor".equals(tipo)) {
                    return buscarVendedor(id);
                }
            }
        }
        return null;
    }

    private Gerente buscarGerente(int id) throws IOException {
        GerenteFileManager gerenteFileManager = new GerenteFileManager();
        List<Gerente> gerentes = gerenteFileManager.ler();

        for (Gerente gerente : gerentes) {
            if (gerente.getId() == id) {
                return gerente;
            }
        }
        return null;
    }

    private Vendedor buscarVendedor(int id) throws IOException {
        VendedorFileManager vendedorFileManager = new VendedorFileManager();
        List<Vendedor> vendedores = vendedorFileManager.ler();

        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == id) {
                return vendedor;
            }
        }
        return null;
    }
}


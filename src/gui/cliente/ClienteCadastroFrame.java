package gui.cliente;

import filemanager.FileManager;
import model.Cliente;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

public class ClienteCadastroFrame extends JFrame {
    public ClienteCadastroFrame() {
        setTitle("Cadastro de Cliente");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 20, 80, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(100, 20, 160, 25);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(10, 50, 80, 25);
        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(100, 50, 160, 25);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(10, 80, 80, 25);
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(100, 80, 160, 25);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(10, 110, 80, 25);
        JTextField txtEmail = new JTextField();
        txtEmail.setBounds(100, 110, 160, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(100, 150, 80, 30);
        btnSalvar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String telefone = txtTelefone.getText();
            String email = txtEmail.getText();

            // REVER MANEIRA MELHOR
            List<Cliente> clientes;
            try {
                clientes = FileManager.lerClientes();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Cliente cliente = new Cliente(Cliente.getUltimoId(clientes) + 1, nome, cpf, telefone, email);

            try {
                FileManager.salvarCliente(cliente);
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + ex.getMessage());
            }
        });

        add(lblNome);
        add(txtNome);
        add(lblCpf);
        add(txtCpf);
        add(lblTelefone);
        add(txtTelefone);
        add(lblEmail);
        add(txtEmail);
        add(btnSalvar);
    }
}

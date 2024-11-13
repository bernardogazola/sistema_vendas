package gui.gerente.frames;

import filemanager.FileManager;
import model.Vendedor;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class CadastrarVendedorFrame extends JFrame {

    public CadastrarVendedorFrame() {
        setTitle("Cadastrar Vendedor");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblUsername = new JLabel("Usuário:");
        lblUsername.setBounds(20, 20, 100, 25);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 20, 200, 25);

        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(20, 60, 100, 25);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 60, 200, 25);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 100, 100, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 100, 200, 25);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(20, 140, 100, 25);
        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(150, 140, 200, 25);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 180, 100, 25);
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(150, 180, 200, 25);

        JLabel lblSalario = new JLabel("Salário:");
        lblSalario.setBounds(20, 220, 100, 25);
        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(150, 220, 200, 25);

        JLabel lblDataContratacao = new JLabel("Data de Contratação (AAAA-MM-DD):");
        lblDataContratacao.setBounds(20, 260, 200, 25);
        JTextField txtDataContratacao = new JTextField();
        txtDataContratacao.setBounds(250, 260, 100, 25);

        JLabel lblMetaMensal = new JLabel("Meta Mensal:");
        lblMetaMensal.setBounds(20, 300, 100, 25);
        JTextField txtMetaMensal = new JTextField();
        txtMetaMensal.setBounds(150, 300, 200, 25);

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(150, 340, 100, 30);
        btnCadastrar.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String telefone = txtTelefone.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            LocalDate dataContratacao = LocalDate.parse(txtDataContratacao.getText());
            double metaMensal = Double.parseDouble(txtMetaMensal.getText());

            try {
                // Gera um novo ID para o vendedor
                int id = FileManager.gerarNovoId();

                // Salva o login no arquivo logins.txt
                FileManager.salvarLogin(id, "Vendedor", username, password);

                // Cria um novo objeto Vendedor e salva no arquivo vendedores.txt
                Vendedor vendedor = new Vendedor(id, nome, cpf, telefone, salario, dataContratacao, metaMensal);
                FileManager.salvarVendedor(vendedor);

                JOptionPane.showMessageDialog(this, "Vendedor cadastrado com sucesso!");
                dispose();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar vendedor: " + ex.getMessage());
            }
        });

        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(lblNome);
        add(txtNome);
        add(lblCpf);
        add(txtCpf);
        add(lblTelefone);
        add(txtTelefone);
        add(lblSalario);
        add(txtSalario);
        add(lblDataContratacao);
        add(txtDataContratacao);
        add(lblMetaMensal);
        add(txtMetaMensal);
        add(btnCadastrar);
    }
}

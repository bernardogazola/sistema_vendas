package gui.admin.frames;

import filemanager.usuario.GerenteFileManager;
import filemanager.usuario.UsuarioFileManager;
import filemanager.usuario.VendedorFileManager;
import model.Credencial;
import model.Gerente;
import model.Vendedor;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDate;

public class RegistroFrame extends JFrame {

    public RegistroFrame() {
        setTitle("Registro de Usuário");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsername = new JLabel("Usuário:");
        lblUsername.setBounds(20, 20, 100, 25);
        JTextField txtUsername = new JTextField();
        txtUsername.setBounds(150, 20, 200, 25);

        JLabel lblPassword = new JLabel("Senha:");
        lblPassword.setBounds(20, 60, 100, 25);
        JPasswordField txtPassword = new JPasswordField();
        txtPassword.setBounds(150, 60, 200, 25);

        JLabel lblTipoUsuario = new JLabel("Tipo de Usuário:");
        lblTipoUsuario.setBounds(20, 100, 100, 25);
        JComboBox<String> cbTipoUsuario = new JComboBox<>(new String[]{"Gerente", "Vendedor"});
        cbTipoUsuario.setBounds(150, 100, 200, 25);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 140, 100, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 140, 200, 25);

        JLabel lblCpf = new JLabel("CPF:");
        lblCpf.setBounds(20, 180, 100, 25);
        JTextField txtCpf = new JTextField();
        txtCpf.setBounds(150, 180, 200, 25);

        JLabel lblTelefone = new JLabel("Telefone:");
        lblTelefone.setBounds(20, 220, 100, 25);
        JTextField txtTelefone = new JTextField();
        txtTelefone.setBounds(150, 220, 200, 25);

        JLabel lblSalario = new JLabel("Salário:");
        lblSalario.setBounds(20, 260, 100, 25);
        JTextField txtSalario = new JTextField();
        txtSalario.setBounds(150, 260, 200, 25);

        JLabel lblDataContratacao = new JLabel("Data de Contratação (AAAA-MM-DD):");
        lblDataContratacao.setBounds(20, 300, 200, 25);
        JTextField txtDataContratacao = new JTextField();
        txtDataContratacao.setBounds(250, 300, 100, 25);

        JLabel lblBonusMensal = new JLabel("Bônus Mensal:");
        lblBonusMensal.setBounds(20, 340, 100, 25);
        JTextField txtBonusMensal = new JTextField();
        txtBonusMensal.setBounds(150, 340, 200, 25);

        JLabel lblMetaMensal = new JLabel("Meta Mensal:");
        lblMetaMensal.setBounds(20, 340, 100, 25);
        JTextField txtMetaMensal = new JTextField();
        txtMetaMensal.setBounds(150, 340, 200, 25);

        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(lblTipoUsuario);
        add(cbTipoUsuario);
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

        add(lblBonusMensal);
        add(txtBonusMensal);
        lblBonusMensal.setVisible(true);
        txtBonusMensal.setVisible(true);

        add(lblMetaMensal);
        add(txtMetaMensal);
        lblMetaMensal.setVisible(false);
        txtMetaMensal.setVisible(false);

        cbTipoUsuario.addActionListener(e -> {
            boolean isGerente = cbTipoUsuario.getSelectedItem().equals("Gerente");
            lblBonusMensal.setVisible(isGerente);
            txtBonusMensal.setVisible(isGerente);
            lblMetaMensal.setVisible(!isGerente);
            txtMetaMensal.setVisible(!isGerente);
        });

        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(150, 400, 100, 30);

        btnRegistrar.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String telefone = txtTelefone.getText();
            double salario;
            LocalDate dataContratacao;

            try {
                salario = Double.parseDouble(txtSalario.getText());
                dataContratacao = LocalDate.parse(txtDataContratacao.getText());

                UsuarioFileManager usuarioFileManager = new UsuarioFileManager();
                int id = usuarioFileManager.gerarNovoId();
                Credencial credencial = new Credencial(id, cbTipoUsuario.getSelectedItem().toString(), username, password);
                usuarioFileManager.salvar(credencial);

                if ("Gerente".equals(cbTipoUsuario.getSelectedItem())) {
                    double bonusMensal = Double.parseDouble(txtBonusMensal.getText());
                    GerenteFileManager gerenteFileManager = new GerenteFileManager();
                    Gerente gerente = new Gerente(id, nome, cpf, telefone, salario, dataContratacao, bonusMensal);
                    gerenteFileManager.salvar(gerente);
                } else {
                    double metaMensal = Double.parseDouble(txtMetaMensal.getText());
                    VendedorFileManager vendedorFileManager = new VendedorFileManager();
                    Vendedor vendedor = new Vendedor(id, nome, cpf, telefone, salario, dataContratacao, metaMensal);
                    vendedorFileManager.salvar(vendedor);
                }

                JOptionPane.showMessageDialog(this, "Registro realizado com sucesso!");
                dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para salário e datas.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao registrar: " + ex.getMessage());
            }
        });

        add(btnRegistrar);
    }
}


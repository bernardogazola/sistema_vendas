package gui.gerente.frames;
import filemanager.produto.ProdutoFileManager;
import model.Produto;
import javax.swing.*;
import java.io.IOException;

public class EstoqueGerenciamentoFrame extends JFrame {
    public EstoqueGerenciamentoFrame() {
        setTitle("Adicionar Produto");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JLabel lblNome = new JLabel("Nome do Produto:");
        lblNome.setBounds(10, 20, 150, 25);
        JTextField txtNome = new JTextField();
        txtNome.setBounds(150, 20, 200, 25);

        JLabel lblPreco = new JLabel("Preço:");
        lblPreco.setBounds(10, 60, 150, 25);
        JTextField txtPreco = new JTextField();
        txtPreco.setBounds(150, 60, 200, 25);

        JLabel lblQuantidade = new JLabel("Quantidade:");
        lblQuantidade.setBounds(10, 100, 150, 25);
        JTextField txtQuantidade = new JTextField();
        txtQuantidade.setBounds(150, 100, 200, 25);

        JButton btnSalvarProduto = new JButton("Salvar Produto");
        btnSalvarProduto.setBounds(150, 150, 150, 30);

        btnSalvarProduto.addActionListener(e -> {
            String nome = txtNome.getText();
            double preco;
            int quantidade;

            try {
                preco = Double.parseDouble(txtPreco.getText());
                quantidade = Integer.parseInt(txtQuantidade.getText());

                ProdutoFileManager produtoFileManager = new ProdutoFileManager();
                int novoId = produtoFileManager.gerarNovoId();
                Produto produto = new Produto(novoId, nome, preco, quantidade);

                produtoFileManager.salvar(produto);
                JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
                dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos para preço e quantidade.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar produto: " + ex.getMessage());
            }
        });

        add(lblNome);
        add(txtNome);
        add(lblPreco);
        add(txtPreco);
        add(lblQuantidade);
        add(txtQuantidade);
        add(btnSalvarProduto);
    }
}
package gui.gerente.frames;

import filemanager.produto.ProdutoFileManager;
import model.Produto;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ProdutoEstoqueFrame extends JFrame {
    private List<Produto> produtos;

    public ProdutoEstoqueFrame() {
        setTitle("Gerenciamento de Estoque de Produtos");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnAdicionarProduto = new JButton("Adicionar Produto");
        btnAdicionarProduto.addActionListener(e -> new EstoqueGerenciamentoFrame().setVisible(true));
        topPanel.add(btnAdicionarProduto);
        add(topPanel, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        try {
            ProdutoFileManager produtoFileManager = new ProdutoFileManager();
            produtos = produtoFileManager.ler();
            for (Produto produto : produtos) {
                JPanel produtoPanel = new JPanel();
                produtoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

                JLabel lblNome = new JLabel(produto.getNome() + " - Estoque: " + produto.getQuantidadeEstoque());
                lblNome.setPreferredSize(new Dimension(300, 25));

                JButton btnAlterar = new JButton("Alterar Estoque");
                btnAlterar.addActionListener(e -> abrirAlterarEstoqueDialog(produto, lblNome, produtoFileManager));

                produtoPanel.add(lblNome);
                produtoPanel.add(btnAlterar);

                panel.add(produtoPanel);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage());
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void abrirAlterarEstoqueDialog(Produto produto, JLabel lblNome, ProdutoFileManager produtoFileManager) {
        String quantidadeStr = JOptionPane.showInputDialog(this, "Informe a nova quantidade em estoque para o produto " + produto.getNome() + ":");
        if (quantidadeStr != null) {
            try {
                int novaQuantidade = Integer.parseInt(quantidadeStr);
                produto.setQuantidadeEstoque(novaQuantidade);

                lblNome.setText(produto.getNome() + " - Estoque: " + produto.getQuantidadeEstoque());

                produtoFileManager.salvarProdutosAtualizados(produtos);

                JOptionPane.showMessageDialog(this, "Quantidade atualizada com sucesso!");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um número válido.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar o produto: " + ex.getMessage());
            }
        }
    }
}
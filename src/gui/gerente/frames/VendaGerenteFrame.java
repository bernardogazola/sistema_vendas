package gui.gerente.frames;

import exception.EstoqueInsuficienteException;
import filemanager.cliente.ClienteFileManager;
import filemanager.produto.ProdutoFileManager;
import filemanager.venda.VendaFileManager;
import model.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaGerenteFrame extends JFrame {
    private JComboBox<Cliente> clienteComboBox;
    private JPanel produtosPanel;
    private JLabel subtotalLabel;
    private List<ProdutoQuantidade> produtoQuantidades = new ArrayList<>();

    public VendaGerenteFrame(Gerente gerente) {
        setTitle("Realizar Venda (Gerente)");
        setSize(600, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        try {
            ClienteFileManager clienteFileManager = new ClienteFileManager();
            ProdutoFileManager produtoFileManager = new ProdutoFileManager();

            List<Cliente> clientes = clienteFileManager.ler();
            List<Produto> produtos = produtoFileManager.ler();

            JPanel clientePanel = new JPanel(new FlowLayout());
            clientePanel.add(new JLabel("Cliente:"));
            clienteComboBox = new JComboBox<>(clientes.toArray(new Cliente[0]));
            clientePanel.add(clienteComboBox);

            add(clientePanel, BorderLayout.NORTH);

            produtosPanel = new JPanel(new GridLayout(produtos.size(), 1));
            for (Produto produto : produtos) {
                JPanel produtoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                JLabel lblProduto = new JLabel(produto.getNome() + " - Estoque: " + produto.getQuantidadeEstoque() + " - Preço: R$" + produto.getPreco());
                JTextField txtQuantidade = new JTextField("0", 5);

                txtQuantidade.getDocument().addDocumentListener(new DocumentListener() {
                    @Override
                    public void insertUpdate(DocumentEvent e) {
                        atualizarSubtotal();
                    }

                    @Override
                    public void removeUpdate(DocumentEvent e) {
                        atualizarSubtotal();
                    }

                    @Override
                    public void changedUpdate(DocumentEvent e) {
                        atualizarSubtotal();
                    }
                });

                produtoPanel.add(lblProduto);
                produtoPanel.add(new JLabel("Quantidade:"));
                produtoPanel.add(txtQuantidade);
                produtosPanel.add(produtoPanel);

                produtoQuantidades.add(new ProdutoQuantidade(produto, txtQuantidade));
            }

            JScrollPane scrollPane = new JScrollPane(produtosPanel);
            add(scrollPane, BorderLayout.CENTER);

            subtotalLabel = new JLabel("Subtotal: R$ 0.00");
            JPanel subtotalPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            subtotalPanel.add(subtotalLabel);

            JButton btnRealizarVenda = new JButton("Realizar Venda");
            btnRealizarVenda.addActionListener(e -> realizarVenda(gerente, produtoFileManager));
            subtotalPanel.add(btnRealizarVenda);

            add(subtotalPanel, BorderLayout.SOUTH);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage());
        }
    }

    private void atualizarSubtotal() {
        double subtotal = 0.0;

        for (ProdutoQuantidade pq : produtoQuantidades) {
            Produto produto = pq.getProduto();
            String quantidadeStr = pq.getQuantidadeField().getText();
            if (!quantidadeStr.isEmpty()) {
                try {
                    int quantidade = Integer.parseInt(quantidadeStr);
                    subtotal += quantidade * produto.getPreco();
                } catch (NumberFormatException e) {
                    // Ignora valores inválidos
                }
            }
        }

        subtotalLabel.setText(String.format("Subtotal: R$ %.2f", subtotal));
    }

    private void realizarVenda(Gerente gerente, ProdutoFileManager produtoFileManager) {
        Cliente cliente = (Cliente) clienteComboBox.getSelectedItem();

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Selecione um cliente.");
            return;
        }

        try {
            VendaFileManager vendaFileManager = new VendaFileManager();
            int idVenda = vendaFileManager.gerarNovoId();
            Venda venda = new Venda(idVenda, cliente, gerente, 0, LocalDate.now());

            List<Produto> todosProdutos = produtoFileManager.ler();

            for (ProdutoQuantidade pq : produtoQuantidades) {
                Produto produtoSelecionado = pq.getProduto();
                String quantidadeStr = pq.getQuantidadeField().getText();
                if (!quantidadeStr.isEmpty()) {
                    int quantidade = Integer.parseInt(quantidadeStr);
                    if (quantidade > 0 && quantidade <= produtoSelecionado.getQuantidadeEstoque()) {
                        double precoTotal = produtoSelecionado.getPreco() * quantidade;
                        ItensVenda itemVenda = new ItensVenda(produtoSelecionado, quantidade, produtoSelecionado.getPreco(), precoTotal);
                        venda.adicionarItem(itemVenda, true);

                        for (Produto produto : todosProdutos) {
                            if (produto.getIdProduto() == produtoSelecionado.getIdProduto()) {
                                produto.atualizarEstoque(quantidade);
                                break;
                            }
                        }
                    }
                }
            }

            vendaFileManager.salvar(venda);
            produtoFileManager.salvarProdutosAtualizados(todosProdutos);

            JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
            dispose();

        } catch (IOException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Erro ao realizar venda: " + e.getMessage());
        } catch (EstoqueInsuficienteException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
}

package filemanager.venda;

import filemanager.FileManager;
import filemanager.Constants;
import filemanager.utils.IdGenerator;
import model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendaFileManager extends FileManager<Venda> {

    @Override
    public int gerarNovoId() throws IOException {
        return IdGenerator.gerarNovoId(Constants.CAMINHO_VENDAS);
    }

    @Override
    public void salvar(Venda venda) throws IOException {
        String vendaDados = venda.getIdVenda() + "," + venda.getCliente().getId() + "," + venda.getFuncionario().getId() +
                "," + venda.getTotal() + "," + venda.getDataVenda().toString();
        salvarDados(Constants.CAMINHO_VENDAS, vendaDados);

        for (ItensVenda item : venda.getItensVenda()) {
            String itemDados = venda.getIdVenda() + "," + item.getProduto().getIdProduto() + "," +
                    item.getQuantidade() + "," + item.getPrecoUnitario() + "," + item.getPrecoTotal();
            salvarDados(Constants.CAMINHO_ITENS_VENDAS, itemDados);
        }
    }

    @Override
    public List<Venda> ler() throws IOException {
        List<Venda> vendas = new ArrayList<>();
        List<String> linhasVendas = lerDados(Constants.CAMINHO_VENDAS);

        for (String linha : linhasVendas) {
            String[] dados = linha.split(",");
            if (dados.length >= 5) {
                int idVenda = Integer.parseInt(dados[0]);
                int idCliente = Integer.parseInt(dados[1]);
                int idFuncionario = Integer.parseInt(dados[2]);
                double total = Double.parseDouble(dados[3]);
                LocalDate dataVenda = LocalDate.parse(dados[4]);

                Cliente cliente = new Cliente(idCliente, "", "", "", "");
                Vendedor vendedor = new Vendedor(idFuncionario, "", "", "", 0, dataVenda, 0);

                Venda venda = new Venda(idVenda, cliente, vendedor, total, dataVenda);
                vendas.add(venda);
            }
        }

        List<String> linhasItens = lerDados(Constants.CAMINHO_ITENS_VENDAS);
        for (String linhaItem : linhasItens) {
            String[] dadosItem = linhaItem.split(",");
            if (dadosItem.length >= 5) {
                int idVenda = Integer.parseInt(dadosItem[0]);
                int idProduto = Integer.parseInt(dadosItem[1]);
                int quantidade = Integer.parseInt(dadosItem[2]);
                double precoUnitario = Double.parseDouble(dadosItem[3]);
                double precoTotal = Double.parseDouble(dadosItem[4]);

                Produto produto = new Produto(idProduto, "", precoUnitario, quantidade);
                ItensVenda item = new ItensVenda(produto, quantidade, precoUnitario, precoTotal);

                for (Venda venda : vendas) {
                    if (venda.getIdVenda() == idVenda) {
                        venda.adicionarItem(item, false);
                        break;
                    }
                }
            }
        }

        return vendas;
    }

    public List<Venda> lerVendasDoFuncionario(int idFuncionario) throws IOException {
        List<Venda> todasVendas = ler();
        List<Venda> vendasFuncionario = new ArrayList<>();

        for (Venda venda : todasVendas) {
            if (venda.getFuncionario().getId() == idFuncionario) {
                vendasFuncionario.add(venda);
            }
        }

        return vendasFuncionario;
    }
}
package filemanager.produto;

import filemanager.FileManager;
import filemanager.Constants;
import filemanager.utils.IdGenerator;
import model.Produto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoFileManager extends FileManager<Produto> {

    @Override
    public int gerarNovoId() throws IOException {
        return IdGenerator.gerarNovoId(Constants.CAMINHO_PRODUTOS);
    }

    @Override
    public void salvar(Produto produto) throws IOException {
        salvarDados(Constants.CAMINHO_PRODUTOS, produto.toCSV());
    }

    @Override
    public List<Produto> ler() throws IOException {
        List<String> linhas = lerDados(Constants.CAMINHO_PRODUTOS);
        List<Produto> produtos = new ArrayList<>();
        for (String linha : linhas) {
            produtos.add(Produto.fromCSV(linha));
        }
        return produtos;
    }

    public void salvarProdutosAtualizados(List<Produto> produtos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Constants.CAMINHO_PRODUTOS))) {
            for (Produto produto : produtos) {
                writer.write(produto.toCSV());
                writer.newLine();
            }
        }
    }
}

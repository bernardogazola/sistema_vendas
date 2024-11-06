package filemanager;

import model.Cliente;
import model.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void salvarDados(String caminhoArquivo, String dados) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write(dados);
            writer.newLine();
        }
    }

    public static List<String> lerDados(String caminhoArquivo) throws IOException {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        }
        return linhas;
    }

    // CLIENTE
    public static void salvarCliente(Cliente cliente) throws IOException {
        salvarDados("clientes.txt", cliente.toCSV());
    }

    public static List<Cliente> lerClientes() throws IOException {
        List<String> linhas = lerDados("clientes.txt");
        List<Cliente> clientes = new ArrayList<>();
        for (String linha : linhas) {
            clientes.add(Cliente.fromCSV(linha));
        }
        return clientes;
    }

    // PRODUTO
    public static void salvarProduto(Produto produto) throws IOException {
        salvarDados("produtos.txt", produto.toCSV());
    }

    public static List<Produto> lerProdutos() throws IOException {
        List<String> linhas = lerDados("produtos.txt");
        List<Produto> produtos = new ArrayList<>();
        for (String linha : linhas) {
            produtos.add(Produto.fromCSV(linha));
        }
        return produtos;
    }

    // VENDA ------ TODO
}


package filemanager;

import model.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static void salvarProdutosAtualizados(List<Produto> produtos) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("produtos.txt"))) {
            for (Produto produto : produtos) {
                writer.write(produto.toCSV());
                writer.newLine();
            }
        }
    }

    // VENDA ------ TODO

    //AUTH
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static int gerarNovoId() throws IOException {
        int maxId = 0;
        List<Gerente> gerentes = lerGerentes();
        for (Gerente g : gerentes) {
            if (g.getId() > maxId) maxId = g.getId();
        }
        List<Vendedor> vendedores = lerVendedores();
        for (Vendedor v : vendedores) {
            if (v.getId() > maxId) maxId = v.getId();
        }
        return maxId + 1;
    }

    public static void salvarLogin(int id, String tipo, String username, String password) throws IOException {
        String dados = id + "," + tipo + "," + username + "," + password;
        salvarDados("logins.txt", dados);
    }

    public static void salvarGerente(Gerente gerente) throws IOException {
        String dados = gerente.getId() + "," + gerente.getNome() + "," + gerente.getCpf() + "," +
                gerente.getTelefone() + "," + gerente.getSalario() + "," +
                gerente.getDataContratacao().format(DATE_FORMATTER) + "," + gerente.getBonusMensal();
        salvarDados("gerentes.txt", dados);
    }

    public static void salvarVendedor(Vendedor vendedor) throws IOException {
        String dados = vendedor.getId() + "," + vendedor.getNome() + "," + vendedor.getCpf() + "," +
                vendedor.getTelefone() + "," + vendedor.getSalario() + "," +
                vendedor.getDataContratacao().format(DATE_FORMATTER) + "," + vendedor.getMetaMensal();
        salvarDados("vendedores.txt", dados);
    }

    public static List<Gerente> lerGerentes() throws IOException {
        List<Gerente> gerentes = new ArrayList<>();
        List<String> linhas = lerDados("gerentes.txt");

        for (String linha : linhas) {
            String[] partes = linha.split(",");
            if (partes.length == 7) {
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String cpf = partes[2];
                String telefone = partes[3];
                double salario = Double.parseDouble(partes[4]);
                LocalDate dataContratacao = LocalDate.parse(partes[5], DATE_FORMATTER);
                double bonusMensal = Double.parseDouble(partes[6]);

                Gerente gerente = new Gerente(id, nome, cpf, telefone, salario, dataContratacao, bonusMensal);
                gerentes.add(gerente);
            }
        }
        return gerentes;
    }

    public static List<Vendedor> lerVendedores() throws IOException {
        List<Vendedor> vendedores = new ArrayList<>();
        List<String> linhas = lerDados("vendedores.txt");

        for (String linha : linhas) {
            String[] partes = linha.split(",");
            if (partes.length == 7) {
                int id = Integer.parseInt(partes[0]);
                String nome = partes[1];
                String cpf = partes[2];
                String telefone = partes[3];
                double salario = Double.parseDouble(partes[4]);
                LocalDate dataContratacao = LocalDate.parse(partes[5], DATE_FORMATTER);
                double metaMensal = Double.parseDouble(partes[6]);

                Vendedor vendedor = new Vendedor(id, nome, cpf, telefone, salario, dataContratacao, metaMensal);
                vendedores.add(vendedor);
            }
        }
        return vendedores;
    }
}


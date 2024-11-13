package filemanager;

import java.time.format.DateTimeFormatter;

public class Constants {
    public static final String
            CAMINHO_CLIENTES = "clientes.txt",
            CAMINHO_PRODUTOS = "produtos.txt",
            CAMINHO_VENDAS = "vendas.txt",
            CAMINHO_ITENS_VENDAS = "itensVendas.txt",
            CAMINHO_LOGINS = "logins.txt",
            CAMINHO_GERENTES = "gerentes.txt",
            CAMINHO_VENDEDORES = "vendedores.txt";

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
}
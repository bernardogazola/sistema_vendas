package filemanager.cliente;

import filemanager.FileManager;
import filemanager.Constants;
import filemanager.utils.IdGenerator;
import model.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ClienteFileManager extends FileManager<Cliente> {

    @Override
    public int gerarNovoId() throws IOException {
        return IdGenerator.gerarNovoId(Constants.CAMINHO_CLIENTES);
    }

    @Override
    public void salvar(Cliente cliente) throws IOException {
        salvarDados(Constants.CAMINHO_CLIENTES, cliente.toCSV());
    }

    @Override
    public List<Cliente> ler() throws IOException {
        List<String> linhas = lerDados(Constants.CAMINHO_CLIENTES);
        List<Cliente> clientes = new ArrayList<>();
        for (String linha : linhas) {
            clientes.add(Cliente.fromCSV(linha));
        }
        return clientes;
    }
}

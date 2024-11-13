package filemanager;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class FileManager<T> implements DataManager<T> {

    protected void salvarDados(String caminhoArquivo, String dados) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, true))) {
            writer.write(dados);
            writer.newLine();
        }
    }

    protected List<String> lerDados(String caminhoArquivo) throws IOException {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        }
        return linhas;
    }

    @Override
    public abstract int gerarNovoId() throws IOException;

    @Override
    public abstract void salvar(T objeto) throws IOException;

    @Override
    public abstract List<T> ler() throws IOException;
}

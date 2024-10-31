package filemanager;

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
}


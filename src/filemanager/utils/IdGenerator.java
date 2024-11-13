package filemanager.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IdGenerator {

    public static int gerarNovoId(String caminhoArquivo) throws IOException {
        int maxId = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                if (id > maxId) {
                    maxId = id;
                }
            }
        }

        return maxId + 1;
    }
}

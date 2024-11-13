package filemanager.usuario;

import filemanager.FileManager;
import filemanager.Constants;
import filemanager.utils.IdGenerator;
import model.Credencial;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioFileManager extends FileManager<Credencial> {

    @Override
    public int gerarNovoId() throws IOException {
        return IdGenerator.gerarNovoId(Constants.CAMINHO_LOGINS);
    }

    @Override
    public void salvar(Credencial credencial) throws IOException {
        String dados = credencial.getId() + "," + credencial.getTipo() + "," + credencial.getUsername() + "," + credencial.getPassword();
        salvarDados(Constants.CAMINHO_LOGINS, dados);
    }

    @Override
    public List<Credencial> ler() throws IOException {
        List<String> linhas = lerDados(Constants.CAMINHO_LOGINS);
        List<Credencial> credenciais = new ArrayList<>();

        for (String linha : linhas) {
            String[] dados = linha.split(",");
            if (dados.length == 4) {
                int id = Integer.parseInt(dados[0]);
                String tipo = dados[1];
                String username = dados[2];
                String password = dados[3];
                credenciais.add(new Credencial(id, tipo, username, password));
            }
        }

        return credenciais;
    }
}
package filemanager.usuario;

import filemanager.FileManager;
import filemanager.Constants;
import filemanager.utils.IdGenerator;
import model.Gerente;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenteFileManager extends FileManager<Gerente> {

    @Override
    public int gerarNovoId() throws IOException {
        return IdGenerator.gerarNovoId(Constants.CAMINHO_GERENTES);
    }

    @Override
    public void salvar(Gerente gerente) throws IOException {
        String dados = gerente.getId() + "," + gerente.getNome() + "," + gerente.getCpf() + "," +
                gerente.getTelefone() + "," + gerente.getSalario() + "," +
                gerente.getDataContratacao().format(Constants.DATE_FORMATTER) + "," + gerente.getBonusMensal();
        salvarDados(Constants.CAMINHO_GERENTES, dados);
    }

    @Override
    public List<Gerente> ler() throws IOException {
        List<String> linhas = lerDados(Constants.CAMINHO_GERENTES);
        List<Gerente> gerentes = new ArrayList<>();

        for (String linha : linhas) {
            String[] dados = linha.split(",");
            if (dados.length == 7) {
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String cpf = dados[2];
                String telefone = dados[3];
                double salario = Double.parseDouble(dados[4]);
                LocalDate dataContratacao = LocalDate.parse(dados[5], Constants.DATE_FORMATTER);
                double bonusMensal = Double.parseDouble(dados[6]);

                Gerente gerente = new Gerente(id, nome, cpf, telefone, salario, dataContratacao, bonusMensal);
                gerentes.add(gerente);
            }
        }

        return gerentes;
    }
}


package filemanager.usuario;

import filemanager.FileManager;
import filemanager.Constants;
import filemanager.utils.IdGenerator;
import model.Vendedor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VendedorFileManager extends FileManager<Vendedor> {

    @Override
    public int gerarNovoId() throws IOException {
        return IdGenerator.gerarNovoId(Constants.CAMINHO_VENDEDORES);
    }

    @Override
    public void salvar(Vendedor vendedor) throws IOException {
        String dados = vendedor.getId() + "," + vendedor.getNome() + "," + vendedor.getCpf() + "," +
                vendedor.getTelefone() + "," + vendedor.getSalario() + "," +
                vendedor.getDataContratacao().format(Constants.DATE_FORMATTER) + "," + vendedor.getMetaMensal();
        salvarDados(Constants.CAMINHO_VENDEDORES, dados);
    }

    @Override
    public List<Vendedor> ler() throws IOException {
        List<String> linhas = lerDados(Constants.CAMINHO_VENDEDORES);
        List<Vendedor> vendedores = new ArrayList<>();

        for (String linha : linhas) {
            String[] dados = linha.split(",");
            if (dados.length == 7) {
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String cpf = dados[2];
                String telefone = dados[3];
                double salario = Double.parseDouble(dados[4]);
                LocalDate dataContratacao = LocalDate.parse(dados[5], Constants.DATE_FORMATTER);
                double metaMensal = Double.parseDouble(dados[6]);

                Vendedor vendedor = new Vendedor(id, nome, cpf, telefone, salario, dataContratacao, metaMensal);
                vendedores.add(vendedor);
            }
        }

        return vendedores;
    }
}
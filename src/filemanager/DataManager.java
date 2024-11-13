package filemanager;

import java.io.IOException;
import java.util.List;

public interface DataManager<T> {

    int gerarNovoId() throws IOException;
    void salvar(T objeto) throws IOException;
    List<T> ler() throws IOException;
}

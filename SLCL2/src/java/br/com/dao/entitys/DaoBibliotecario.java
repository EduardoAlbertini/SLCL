package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.com.entitys.Bibliotecario;

public class DaoBibliotecario extends DaoGenerics<Bibliotecario> {
    public DaoBibliotecario() {
        super.classe = Bibliotecario.class;
    }
}

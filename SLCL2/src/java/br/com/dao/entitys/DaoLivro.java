package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.com.entitys.Livro;

public class DaoLivro extends DaoGenerics<Livro> {
    public DaoLivro() {
        super.classe = Livro.class;
    }
}

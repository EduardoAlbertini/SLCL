package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import br.edu.utfpr.cm.slcl.entitys.Livro;

public class DaoLivro extends DaoGenerics<Livro> {
    public DaoLivro() {
        super.classe = Livro.class;
    }
}

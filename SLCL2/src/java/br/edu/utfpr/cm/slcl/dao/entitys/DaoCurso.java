package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.com.entitys.Curso;

public class DaoCurso extends DaoGenerics<Curso> {
    public DaoCurso() {
        super.classe = Curso.class;
    }
}

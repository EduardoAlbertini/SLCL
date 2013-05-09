package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import br.edu.utfpr.cm.slcl.entitys.Curso;

public class DaoCurso extends DaoGenerics<Curso> {
    public DaoCurso() {
        super.classe = Curso.class;
    }
}

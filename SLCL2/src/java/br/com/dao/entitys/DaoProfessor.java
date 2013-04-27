package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.com.entitys.Professor;

public class DaoProfessor extends DaoGenerics<Professor> {
    public DaoProfessor() {
        super.classe = Professor.class;
    }
}

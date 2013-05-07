package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.com.entitys.Disciplina;

public class DaoDisciplina extends DaoGenerics<Disciplina> {
    public DaoDisciplina() {
        super.classe = Disciplina.class;
    }
}

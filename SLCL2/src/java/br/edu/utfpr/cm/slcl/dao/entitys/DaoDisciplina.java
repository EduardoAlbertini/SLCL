package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import br.edu.utfpr.cm.slcl.entitys.Disciplina;

public class DaoDisciplina extends DaoGenerics<Disciplina> {
    public DaoDisciplina() {
        super.classe = Disciplina.class;
    }
}

package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import br.edu.utfpr.cm.slcl.entitys.Professor;
import org.hibernate.Query;

public class DaoProfessor extends DaoGenerics<Professor> {
    public DaoProfessor() {
        super.classe = Professor.class;
    }

    public Professor obterPorLogin(String login) {
        Professor professor = null;
        if (login != null) {
            Query select = session.createQuery("FROM " + classe.getSimpleName() + " WHERE login = '" + login + "'");
            professor = (Professor) select.uniqueResult();
        }
        return professor;
    }
}

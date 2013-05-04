package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.com.entitys.Professor;
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

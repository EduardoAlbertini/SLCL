package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import br.edu.utfpr.cm.slcl.entitys.Bibliotecario;
import org.hibernate.Query;

public class DaoBibliotecario extends DaoGenerics<Bibliotecario> {
    public DaoBibliotecario() {
        super.classe = Bibliotecario.class;
    }
    
    public Bibliotecario obterPorLogin(String login) {
        Bibliotecario bibliotecario = null;
        if (login != null) {
            Query select = session.createQuery("FROM " + classe.getSimpleName() + " WHERE login = '" + login + "'");
            bibliotecario = (Bibliotecario) select.uniqueResult();
        }
        return bibliotecario;
    }
}

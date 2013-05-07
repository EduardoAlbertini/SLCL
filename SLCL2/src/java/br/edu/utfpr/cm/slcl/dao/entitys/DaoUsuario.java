package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import org.hibernate.Query;

public class DaoUsuario extends DaoGenerics<Usuario> {
    public DaoUsuario(){
        super.classe = Usuario.class;
    }
    
    public Usuario obterPorLogin(String login) {
        Usuario usuario = null;
        if (login != null) {
            Query select = session.createQuery("FROM " + classe.getSimpleName() + " WHERE login = '" + login + "'");
            usuario = (Usuario) select.uniqueResult();
        }
        return usuario;
    }
}


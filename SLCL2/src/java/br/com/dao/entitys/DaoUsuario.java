package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import org.hibernate.Query;

public class DaoUsuario extends DaoGenerics<Usuario> {
    public DaoUsuario(){
        super.classe = Usuario.class;
    }
    
    public Usuario obterPorLogin(String login) {
        Usuario usuario = null;
        if (login != null) {
            Query select = session.createQuery(" FROM " + classe.getSimpleName() + " WHERE login = '" + login + "'");
            usuario = (Usuario) select.uniqueResult();
        }
        return usuario;
    }
}


package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import org.hibernate.Query;

public class DaoUsuario extends DaoGenerics<Usuario> {
    public DaoUsuario(){
        super.classe = Usuario.class;
    }
    
    public Usuario obterPorLogin(String ra) {
        Usuario objeto = null;
        if (ra != null) {
            Query select = session.createQuery("From " + classe.getSimpleName() + " where login = '" + ra +"'");
            objeto = (Usuario) select.uniqueResult();
        }
        return objeto;
    }
}


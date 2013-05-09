package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import br.edu.utfpr.cm.slcl.entitys.Evento;

public class DaoEvento extends DaoGenerics<Evento> {
    public DaoEvento() {
        super.classe = Evento.class;
    }
}

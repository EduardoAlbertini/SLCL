package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.com.entitys.Evento;

public class DaoEvento extends DaoGenerics<Evento> {
    public DaoEvento() {
        super.classe = Evento.class;
    }
}

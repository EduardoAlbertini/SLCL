package br.com.dao.entitys;

import br.com.dao.DaoGenerics;
import br.edu.utfpr.cm.saa.entidades.Papel;

public class DaoPapel extends DaoGenerics<Papel> {
    public DaoPapel(){
        super.classe = Papel.class;
    }
}
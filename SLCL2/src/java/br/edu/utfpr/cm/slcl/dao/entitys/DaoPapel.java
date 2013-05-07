package br.edu.utfpr.cm.slcl.dao.entitys;

import br.edu.utfpr.cm.slcl.dao.DaoGenerics;
import br.edu.utfpr.cm.saa.entidades.Papel;

public class DaoPapel extends DaoGenerics<Papel> {
    public DaoPapel(){
        super.classe = Papel.class;
    }
}
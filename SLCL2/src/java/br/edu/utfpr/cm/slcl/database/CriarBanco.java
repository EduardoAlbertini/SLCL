package br.edu.utfpr.cm.slcl.database;

import br.edu.utfpr.cm.saa.entidades.Papel;
import br.edu.utfpr.cm.slcl.dao.PopularDao;
import br.edu.utfpr.cm.slcl.dao.entitys.DaoBibliotecario;
import br.edu.utfpr.cm.slcl.entitys.Bibliotecario;

public class CriarBanco {
    public static void main(String[] args) {
        PopularDao.criarBanco();
        
        Bibliotecario bibliotecario = new Bibliotecario();
        bibliotecario.setLogin("bibliotecario");
        bibliotecario.setNome("Bibliotecario");
        bibliotecario.setSenha("bibliotecario123");
        bibliotecario.setEmail("bib@bib.com.br");
        bibliotecario.setPapel(new Papel(3));
        
        DaoBibliotecario daoB = new DaoBibliotecario();
        daoB.persistir(bibliotecario);
    }
}

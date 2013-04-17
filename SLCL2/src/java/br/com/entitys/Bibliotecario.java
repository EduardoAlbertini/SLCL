package br.com.entitys;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Bibliotecario")
@PrimaryKeyJoinColumn(name = "id")
public class Bibliotecario extends Usuario{
    public Bibliotecario() {
        super();
        super.setTipo(Tipo.BIBLIOTECARIO);
    }
    
    public Bibliotecario(String codigo, String nome, String sobrenome) {
        super(codigo, nome, sobrenome);
        super.setTipo(Tipo.BIBLIOTECARIO);
    }
}

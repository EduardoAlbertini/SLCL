package br.com.entitys;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Usuario{
    public Professor() {
        super();
        super.setTipo(Tipo.PROFESSOR);
    }
    
    public Professor(String codigo, String nome, String sobrenome) {
        super(codigo, nome, sobrenome);
        super.setTipo(Tipo.PROFESSOR);
    }
}

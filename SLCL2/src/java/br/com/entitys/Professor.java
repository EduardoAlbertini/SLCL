package br.com.entitys;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Usuario{
    public Professor() {
        super();
    }
}

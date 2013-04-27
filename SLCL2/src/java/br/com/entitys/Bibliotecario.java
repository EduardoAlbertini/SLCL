package br.com.entitys;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Bibliotecario")
@PrimaryKeyJoinColumn(name = "id")
public class Bibliotecario extends Usuario{
    public Bibliotecario() {
        super();
    }
}

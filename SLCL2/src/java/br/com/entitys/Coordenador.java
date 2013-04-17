package br.com.entitys;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Coordenador")
@PrimaryKeyJoinColumn(name = "id")
public class Coordenador extends Professor{
    public Coordenador() {
        super();
        super.setTipo(Tipo.COORDENADOR);
    }
}

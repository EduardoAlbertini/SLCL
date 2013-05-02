package br.com.entitys;

import br.edu.utfpr.cm.saa.entidades.Papel;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Coordenador")
@PrimaryKeyJoinColumn(name = "id")
public class Coordenador extends Professor{
    @OneToOne
    private Curso curso;

    public Coordenador(){
        super();
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
} 
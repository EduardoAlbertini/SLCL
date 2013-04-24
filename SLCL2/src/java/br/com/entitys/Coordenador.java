package br.com.entitys;

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
    
    public Coordenador() {
        super();
        super.setTipo(Tipo.COORDENADOR);
    }
    
    public Coordenador(Curso curso) {
        super();
        super.setTipo(Tipo.COORDENADOR);
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Coordenador: " + super.getNome() + " " + super.getSobrenome() + " do curso "  + curso.toString();
    }
}
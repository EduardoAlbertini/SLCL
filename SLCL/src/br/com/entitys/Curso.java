package br.com.entitys;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Curso")
public class Curso {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 200)
    private String nome;
    @Column(length = 3)
    private String codigo;
    @OneToOne
    private Usuario coordenador;

    public Curso() {
    }
    
    public Curso(String codigo, String nome, Usuario coordenador){
        this.codigo = codigo;
        this.nome = nome;
        this.coordenador = coordenador;
    }

    public int getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Usuario coordenador) {
        this.coordenador = coordenador;
    }
    
    @Override
    public String toString() {
        return "(" + codigo + ") " + nome;
    }    
}

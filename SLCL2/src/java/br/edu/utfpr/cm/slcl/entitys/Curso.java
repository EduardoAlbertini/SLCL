package br.edu.utfpr.cm.slcl.entitys;

import br.edu.utfpr.cm.saa.entidades.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @OneToMany
    private List<Disciplina> disciplinas;

    public Curso() {
        disciplinas = new ArrayList<Disciplina>();
    }
    
    public Curso(String codigo, String nome, Usuario coordenador, List<Disciplina> disciplinas){
        this.codigo = codigo;
        this.nome = nome;
        this.coordenador = coordenador;
        this.disciplinas = disciplinas;
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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public void addDisciplina(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }
    
    @Override
    public String toString() {
        return codigo + ":" + nome;
    }    
}

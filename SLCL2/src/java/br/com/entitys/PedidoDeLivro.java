package br.com.entitys;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PedidoDeLivro")
public class PedidoDeLivro {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 3)
    private int qtde;
    @Column(length = 12)
    private Bibliografia bibliografia;
    @OneToOne
    private Livro livro;
    @OneToOne
    private Professor professor;
    @OneToOne
    private Curso curso;
    
    public PedidoDeLivro() {
    }
    
    public PedidoDeLivro(int quantidade,Bibliografia bibliografia, Livro livro, Professor professor, Curso curso) {
        this.qtde = quantidade;
        this.bibliografia = bibliografia;
        this.livro = livro;
        this.professor = professor;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }
    
    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public Bibliografia getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(Bibliografia bibliografia) {
        this.bibliografia = bibliografia;
    }
    
    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    @Override
    public String toString() {
        return livro.toString() + " Quantidade: " + qtde;
    }
}
 
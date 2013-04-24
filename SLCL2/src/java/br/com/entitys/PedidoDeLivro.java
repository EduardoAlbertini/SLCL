package br.com.entitys;

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
    @OneToOne
    private Livro livro;
    @OneToOne
    private Professor professor;
    
    public PedidoDeLivro() {
    }
    
    public PedidoDeLivro(int quantidade, Livro livro, Professor professor) {
        this.qtde = quantidade;
        this.livro = livro;
        this.professor = professor;
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

    @Override
    public String toString() {
        return livro.toString() + " Quantidade: " + qtde;
    }
}
 
package br.com.entitys;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Livro")
public class Livro {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 200)
    private String tituloOriginal;
    @Column(length = 200)
    private String titulo;
    @OneToMany
    private List<Autor> autor;
    @Column(length = 3)
    private String edicao;
    @Column(length = 100)
    private String editora;
    @Column(length = 13)
    private String isbn;
    @Column(length = 250)
    private String assunto;
    @Column(length = 12)
    private Bibliografia bibliografia;
    @OneToOne
    private Evento estado;

    public Livro() {
    }
    
    public Livro(String tituloOriginal, String titulo, List<Autor> autor, String edicao, 
            String editora, String isbn, String assunto, Bibliografia bibliografia) {
        this.tituloOriginal = tituloOriginal;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.editora = editora;
        this.isbn = isbn;
        this.assunto = assunto;
        this.bibliografia = bibliografia;
        this.estado = new Evento();
    }

    public String getTituloOriginal() {
        return tituloOriginal;
    }

    public void setTituloOriginal(String tituloOriginal) {
        this.tituloOriginal = tituloOriginal;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Bibliografia getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(Bibliografia bibliografia) {
        this.bibliografia = bibliografia;
    }

    public Evento getEstado() {
        return estado;
    }

    public void setEstado(Evento estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Título Original: " + tituloOriginal + "\n Título: " + titulo + "\n Autor: " + autor.toString() + "\n ISBN: " + isbn + "\n Editora: " + editora + "\n Edição: " + edicao + "\n Assunto: " + assunto + "\n Tipo de Bibliografia: " + bibliografia;
    }   
}
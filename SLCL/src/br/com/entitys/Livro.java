package br.com.entitys;

public class Livro {
    private String tituloOriginal;
    private String titulo;
    private String autor;
    private String edicao;
    private String publicacao;
    private String isbn;
    private String assunto;
    private String bibliografia;
    private Evento estado;
    
    public Livro(String tituloOriginal, String titulo, String autor, String edicao, 
            String publicacao, String isbn, String assunto, String bibliografia, 
            Evento estado) {
        this.tituloOriginal = tituloOriginal;
        this.titulo = titulo;
        this.autor = autor;
        this.edicao = edicao;
        this.publicacao = publicacao;
        this.isbn = isbn;
        this.assunto = assunto;
        this.bibliografia = bibliografia;
        this.estado = estado;
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

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public String getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(String publicacao) {
        this.publicacao = publicacao;
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

    public String getBibliografia() {
        return bibliografia;
    }

    public void setBibliografia(String bibliografia) {
        this.bibliografia = bibliografia;
    }

    public Evento getEstado() {
        return estado;
    }

    public void setEstado(Evento estado) {
        this.estado = estado;
    }
}

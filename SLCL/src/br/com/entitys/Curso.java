package br.com.entitys;

public class Curso {
    private int codigo;
    private String nome;
    
    public Curso(int codigo, String nome){
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "(" + codigo + ") " + nome;
    }    
}

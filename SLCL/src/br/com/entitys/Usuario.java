package br.com.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 7)
    private String codigo;
    @Column(length = 100)
    private String nome;
    @Column(length = 100)
    private String sobrenome;
    @Column(length = 13)
    private Tipo tipo;

    public Usuario() {
    }
    
    public Usuario(String codigo, String nome, String sobrenome, Tipo tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "(" + codigo + ") " + tipo + " " + nome + " " + sobrenome;
    }   
}
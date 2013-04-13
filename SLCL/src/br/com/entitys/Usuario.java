package SLCL;

public class Usuario {
    private int codigo;
    private String nome;
    private String sobrenome;
    private Tipo tipo;
    
    public Usuario(int codigo, String nome, String sobrenome, Tipo tipo) {
        this.codigo = codigo;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.tipo = tipo;
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
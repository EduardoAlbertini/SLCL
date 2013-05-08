package br.edu.utfpr.cm.slcl.entitys;

import br.edu.utfpr.cm.saa.entidades.Papel;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
//@Table(name = "Bibliotecario")
//@PrimaryKeyJoinColumn(name = "id")
public class Bibliotecario extends Usuario{
    @OneToOne
    private Papel papel;
    
    public Bibliotecario() {
        this.setSenha("default");
    }
    
    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Bibliotecario other = (Bibliotecario) obj;
        if ((this.getLogin() == null) ? (other.getLogin() != null) : !this.getLogin().equals(other.getLogin())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + this.getId() + ") Nome: " + this.getNome();
    }
}

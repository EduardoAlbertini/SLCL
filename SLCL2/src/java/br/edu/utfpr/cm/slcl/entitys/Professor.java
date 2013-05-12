package br.edu.utfpr.cm.slcl.entitys;

import br.edu.utfpr.cm.saa.entidades.Papel;
import br.edu.utfpr.cm.saa.entidades.Usuario;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "Professor")
//@PrimaryKeyJoinColumn(name = "id")
public class Professor extends Usuario{
    @OneToOne
    private Papel papel;
    
    public Professor() {
//        super();
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
        final Professor other = (Professor) obj;
        if ((this.getLogin() == null) ? (other.getLogin() != null) : !this.getLogin().equals(other.getLogin())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "(" + this.getId() + ") " + this.papel.getNome() + ": " + this.getNome() ;
    }
}

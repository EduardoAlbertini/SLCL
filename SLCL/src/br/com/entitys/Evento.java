package br.com.entitys;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "Evento")
public class Evento {
    @Id
    @GeneratedValue
    private int id;
    @Column(length = 10)
    private Estado estado;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataMod;
    @Column(length = 500)
    private String motivo;
    
    public Evento() {
        estado = Estado.REQUERIDO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getDataMod() {
        return dataMod;
    }

    public void setDataMod(Date dataMod) {
        this.dataMod = dataMod;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "(" + id + ") " + estado + " Modificado: " + dataMod + " - Motivo: " + motivo;
    }
}

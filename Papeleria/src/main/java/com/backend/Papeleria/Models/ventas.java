package com.backend.Papeleria.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ventas")
public class ventas implements Serializable {
    @Id
    @Column(name="idventa")
    private int idventa;
    @ManyToOne
    @JoinColumn(name="idpapeleeria")
    private papeleria papeleria;
    @ManyToOne
    @JoinColumn(name="idusuario")
    private usuario usuario;
    @Column(name="fecharegistro")
    private String fecharegistro;

    public ventas(int idventa, papeleria papeleria, usuario usuario, String fecharegistro) {
       this.idventa = idventa;
       this.papeleria = papeleria;
       this.usuario= usuario;
       this.fecharegistro = fecharegistro;
    }

    public ventas() {
    }

    public int getIdventa() {
        return idventa;
    }

    public void setIdventa(int idventa) {
        this.idventa = idventa;
    }

    public papeleria getPapeleria() {
        return papeleria;
    }

    public void setPapeleria(papeleria papeleria) {
        this.papeleria = papeleria;
    }

    public usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(usuario usuario) {
        this.usuario = usuario;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }
}

   
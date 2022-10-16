package com.backend.Papeleria.Models;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="papeleria")
public class papeleria implements Serializable {
    @Id
    @Column(name="idpapeleria")
    private int idpapeleria;
    @Column(name="nombrepapeleria")
    private String nombrepapeleria;
    @Column(name="celularpapeleria")
    private int celularpapeleria;
    @Column(name="direccionpapeleria")
    private String direccionpapeleria;

    public papeleria(int idpapeleria, String nombrepapeleria, int celularpapeleria,String direccionpapeleria) {
        this.idpapeleria = idpapeleria;
        this.nombrepapeleria= nombrepapeleria;
        this.celularpapeleria = celularpapeleria;
        this.direccionpapeleria= direccionpapeleria;
    }

    public papeleria() {
    }

    public int getIdpapeleria() {
        return idpapeleria;
    }

    public void setIdpapeleria(int idpapeleria) {
        this.idpapeleria = idpapeleria;
    }

    public String getNombrepapeleria() {
        return nombrepapeleria;
    }

    public void setNombrepapeleria(String nombrepapeleria) {
        this.nombrepapeleria = nombrepapeleria;
    }

    public int getCelularpapeleria() {
        return celularpapeleria;
    }

    public void setCelularpapeleria(int celularpapeleria) {
        this.celularpapeleria = celularpapeleria;
    }

    public String getDireccionpapeleria() {
        return direccionpapeleria;
    }

    public void setDireccionpapeleria(String direccionpapeleria) {
        this.direccionpapeleria = direccionpapeleria;
    }
}
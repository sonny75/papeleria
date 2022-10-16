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
@Table(name="rol")
public class rol implements Serializable {
    @Id
    @Column(name="id")
    private int id;
    @Column(name="nombre")
    private String nombre;
   

    public rol(int id, String nombre) {
       this.id = id;
       this.nombre = nombre;
    }

    public rol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

    
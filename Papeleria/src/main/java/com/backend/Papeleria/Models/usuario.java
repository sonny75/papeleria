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
import java.math.BigInteger;

@Entity
@Table(name="usuario")
public class usuario implements Serializable {
    @Id
    @Column(name="idusuario")
    private int idusuario;
    @Column(name="nombreuno")
    private String nombreuno;
    @Column(name="nombredos")
    private String nombredos;
    @Column(name="apellidouno")
    private String apellidouno;
    @Column(name="apellidodos")
    private String apellidodos;
    @Column(name="celular")
    private BigInteger celular;
    @Column(name="direccion")
    private String direccion;
    @Column(name="email")
    private String email;
    @ManyToOne
    @JoinColumn(name="rol")
    private rol rol;
   

    public usuario(int idusuario, String nombreuno, String nombredos, String apellidouno,String apellidodos,BigInteger celular,String direccion,String email,rol rol) {
       this.idusuario= idusuario;
       this.nombreuno= nombreuno;
       this.nombredos = nombredos;
       this.apellidouno= apellidouno;
       this.apellidodos= apellidodos;
       this.celular = celular;
       this.direccion = direccion;
       this.email = email;
       this.rol =rol;
    }

    public usuario () {
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombreuno() {
        return nombreuno;
    }

    public void setNombreuno(String nombreuno) {
        this.nombreuno = nombreuno;
    }

    public String getNombredos() {
        return nombredos;
    }

    public void setNombredos(String nombredos) {
        this.nombredos = nombredos;
    }

    public String getApellidouno() {
        return apellidouno;
    }

    public void setApellidouno(String apellidouno) {
        this.apellidouno = apellidouno;
    }

    public String getApellidodos() {
        return apellidodos;
    }

    public void setApellidodos(String apellidodos) {
        this.apellidodos = apellidodos;
    }

    public BigInteger getCelular() {
        return celular;
    }

    public void setCelular(BigInteger celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public rol getRol() {
        return rol;
    }

    public void setRol(rol rol) {
        this.rol = rol;
    }
}

    
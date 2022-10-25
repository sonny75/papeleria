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
@Table(name="proveedor")
public class proveedor implements Serializable {
    @Id
    @Column(name="idproveedor")
    private int idproveedor;
    @Column(name="empresa")
    private String empresa;
    @Column(name="celularproveedor")
    private int celularproveedor;
    @Column(name="emailproveedor")
    private String emailproveedor;
    @Column(name="direccionempresa")
    private String direccionempresa;
    @Column(name="nombrevendedor")
    private String nombrevendedor;

    public proveedor(int idproveedor, String empresa, int celularproveedor,String emailproveedor,String direccionempresa,String nombrevendedor) {
        this.idproveedor = idproveedor;
        this.empresa = empresa;
        this.celularproveedor = celularproveedor;
        this.emailproveedor = emailproveedor;
        this.direccionempresa = direccionempresa;
        this.nombrevendedor = nombrevendedor;
    }

    public proveedor() {
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int getCelularproveedor() {
        return celularproveedor;
    }

    public void setCelularproveedor(int celularproveedor) {
        this.celularproveedor = celularproveedor;
    }

    public String getEmailproveedor() {
        return emailproveedor;
    }

    public void setEmailproveedor(String emailproveedor) {
        this.emailproveedor = emailproveedor;
    }

    public String getDireccionempresa() {
        return direccionempresa;
    }

    public void setDireccionempresa(String direccionempresa) {
        this.direccionempresa = direccionempresa;
    }

    public String getNombrevendedor() {
        return nombrevendedor;
    }

    public void setNombrevendedor(String nombrevendedor) {
        this.nombrevendedor = nombrevendedor;
    }
}
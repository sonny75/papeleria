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
@Table(name="producto")
public class producto implements Serializable {
    @Id
    @Column(name="idproducto")
    private int idproducto;
    @Column(name="descripcionproducto")
    private String descripcionproducto;
    @ManyToOne
    @JoinColumn(name="idcategoria")
    private categoria categoria;
    @ManyToOne
    @JoinColumn(name="idprovedor")
    private proveedor provedor;

    public producto(int idproducto, String descripcionproducto, categoria categoria, proveedor provedor) {
        this.idproducto = idproducto;
        this.descripcionproducto =descripcionproducto;
        this.categoria = categoria;
        this.provedor = provedor;
    }

    public producto() {
    }

    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public String getDescripcionproducto() {
        return descripcionproducto;
    }

    public void setDescripcionproducto(String descripcionproducto) {
        this.descripcionproducto = descripcionproducto;
    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public proveedor getProvedor() {
        return provedor;
    }

    public void setProvedor(proveedor provedor) {
        this.provedor = provedor;
    }
}

   
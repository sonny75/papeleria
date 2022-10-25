
package com.backend.Papeleria.Models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="inventario")
public class inventario implements Serializable {
    
    @Id
    @Column(name="idinventario")
    private int idinventario;
    @ManyToOne
    @JoinColumn(name="idproducto")
    private producto producto;
    @ManyToOne
    @JoinColumn(name="idproveedor")
    private proveedor provedor;
    @Column(name="fecharegistro")
    private String fecharegistro;
    @Column(name="cantidad")
    private int cantidad;
    @Column(name="valorunitario")
    private int valorunitario;
    @ManyToOne
    @JoinColumn(name="codigoventa")
    private ventas ventas;

    public inventario(producto producto, proveedor provedor, String fecharegistro, int cantidad,int valorunitario,ventas ventas) {
        this.producto = producto;
        this.provedor =provedor;
        this.fecharegistro= fecharegistro;
        this.cantidad = cantidad;
        this.valorunitario= valorunitario;
        this.ventas= ventas;
    }

    public inventario() {
    }

    public producto getProducto() {
        return producto;
    }

    public void setProducto(producto producto) {
        this.producto = producto;
    }

    public proveedor getProvedor() {
        return provedor;
    }

    public void setProvedor(proveedor provedor) {
        this.provedor = provedor;
    }

    public String getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(String fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValorunitario() {
        return valorunitario;
    }

    public void setValorunitario(int valorunitario) {
        this.valorunitario = valorunitario;
    }

    public ventas getVentas() {
        return ventas;
    }

    public void setVentas(ventas ventas) {
        this.ventas = ventas;
    }
}

   
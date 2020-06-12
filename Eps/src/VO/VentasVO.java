/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VO;

/**
 *
 * @author USUARIO
 */
public class VentasVO {
    private int id;
    private String fechaVenta;
    private int registroProducto;
    private int registroPrecio;
    private int totalVentas;
    private int registroFacturas;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getRegistroProducto() {
        return registroProducto;
    }

    public void setRegistroProducto(int registroProducto) {
        this.registroProducto = registroProducto;
    }

    public int getRegistroPrecio() {
        return registroPrecio;
    }

    public void setRegistroPrecio(int registroPrecio) {
        this.registroPrecio = registroPrecio;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    public int getRegistroFacturas() {
        return registroFacturas;
    }

    public void setRegistroFacturas(int registroFacturas) {
        this.registroFacturas = registroFacturas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


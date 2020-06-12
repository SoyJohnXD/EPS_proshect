/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * ggisi
 */
package VO;

/**
 *
 * @author USUARIO
 */
public class EpsVO {
    private String Nombre;
    private int idGerente;
    private String registro;
    private int bs_clientes;
    private int lista_conve;
    private int patologias_cliente;
    private long convenio_pago;
    private String estado;

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getIdGerente() {
        return idGerente;
    }

    public void setIdGerente(int idGerente) {
        this.idGerente = idGerente;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public int getBs_clientes() {
        return bs_clientes;
    }

    public void setBs_clientes(int bs_clientes) {
        this.bs_clientes = bs_clientes;
    }

    public int getLista_conve() {
        return lista_conve;
    }

    public void setLista_conve(int lista_conve) {
        this.lista_conve = lista_conve;
    }

    public int getPatologias_cliente() {
        return patologias_cliente;
    }

    public void setPatologias_cliente(int patologias_cliente) {
        this.patologias_cliente = patologias_cliente;
    }

    public long getConvenio_pago() {
        return convenio_pago;
    }

    public void setConvenio_pago(long convenio_pago) {
        this.convenio_pago = convenio_pago;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public EpsVO() {
    }
    
    
    
}

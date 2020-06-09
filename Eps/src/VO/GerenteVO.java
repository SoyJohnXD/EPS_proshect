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
public class GerenteVO {
    private int id;
    private String Nombre_usuario;
    private String contraseña;
    private String Regsitro_EPS;
    private String registro_clientes;
    private String analisis_inventario;

    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getNombre_usuario() {
        return Nombre_usuario;
    }

    public void setNombre_usuario(String Nombre_usuario) {
        this.Nombre_usuario = Nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getRegsitro_EPS() {
        return Regsitro_EPS;
    }

    public void setRegsitro_EPS(String Regsitro_EPS) {
        this.Regsitro_EPS = Regsitro_EPS;
    }

    public String getRegistro_clientes() {
        return registro_clientes;
    }

    public void setRegistro_clientes(String registro_clientes) {
        this.registro_clientes = registro_clientes;
    }

    public String getAnalisis_inventario() {
        return analisis_inventario;
    }

    public void setAnalisis_inventario(String analisis_inventario) {
        this.analisis_inventario = analisis_inventario;
    }
}

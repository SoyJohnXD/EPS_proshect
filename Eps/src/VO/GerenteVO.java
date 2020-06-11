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
    private String Nombres;
    private String Apellidos;
    private String email;
    private String contraseña;
    private int Regsitro_EPS;
    private int registro_clientes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRegsitro_EPS() {
        return Regsitro_EPS;
    }

    public void setRegsitro_EPS(int Regsitro_EPS) {
        this.Regsitro_EPS = Regsitro_EPS;
    }

    public int getRegistro_clientes() {
        return registro_clientes;
    }

    public void setRegistro_clientes(int registro_clientes) {
        this.registro_clientes = registro_clientes;
    }

    public String getAnalisis_inventario() {
        return analisis_inventario;
    }

    public void setAnalisis_inventario(String analisis_inventario) {
        this.analisis_inventario = analisis_inventario;
    }
    private String analisis_inventario;

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import VO.GerenteVO;
import bd.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class gerenteModel {
    private GerenteVO gerenteVO;
    private Connection conn;
    private final String TABLA = "gerente";
    private JFrame jFrame;
    
    public GerenteVO getGerenteVO() {
        return gerenteVO;
    }
    public void setGerenteVO(GerenteVO gerenteVO) {
        this.gerenteVO = gerenteVO;
    }
    
    public gerenteModel(GerenteVO gerenteVO) {
        this.gerenteVO = gerenteVO;
        this.conn = new Conexion().conectar();
    }
    
    
    public GerenteVO consultarGenrente() {
        try {
            //sentencia con un parámetro indicado por el signo ?
            String sentencia = "SELECT * FROM " + TABLA + " WHERE Nombre_usuario=?";
            //Preparar la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sentencia);
            ps.setString(1, this.gerenteVO.getNombre_usuario());
            //almacenar resultado
            ResultSet resultado = ps.executeQuery();
            //recorrer resultado
            while (resultado.next()) {
                this.gerenteVO.setNombre_usuario(resultado.getString("Nombre_usuario"));
                this.gerenteVO.setContraseña(resultado.getString("Contraseña"));
                this.gerenteVO.setRegistro_clientes(resultado.getString("registro_clientes"));
                this.gerenteVO.setRegsitro_EPS(resultado.getString("registro_Eps"));
                this.gerenteVO.setAnalisis_inventario(resultado.getString("analisis_Inventario"));

            }
            return this.gerenteVO;

        } catch (SQLException ex) {
            System.out.println("error en consultar usuario: " + ex.getMessage());
        }

        return null;
    }
    
     public ArrayList<GerenteVO> listarGerente() {
        try {
            //sentencia con un parámetro indicado por el signo ?
            String sentencia = "SELECT * FROM " + TABLA + " WHERE 1";
            //Preparar la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sentencia);
            //almacenar resultado
            ResultSet resultado = ps.executeQuery();
            //recorrer resultado
            ArrayList<GerenteVO> listaUsuario = new ArrayList<GerenteVO>();
            while (resultado.next()) {
                GerenteVO ge = new GerenteVO();
                ge.setid(resultado.getInt("id"));
                ge.setNombre_usuario(resultado.getString("Nombre_usuario"));
                ge.setContraseña(resultado.getString("Contraseña"));
                ge.setRegistro_clientes(resultado.getString("registro_clientes"));
                ge.setRegsitro_EPS(resultado.getString("registro_Eps"));
                ge.setAnalisis_inventario(resultado.getString("analisis_inventario"));
                listaUsuario.add(ge);
            }
            return listaUsuario;
        } catch (SQLException ex) {
            System.out.println("Error en listar usuario: " + ex.getMessage());
        }

        return null;
    }
     
     public boolean insertarGerente() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
            String sentencia = "INSERT INTO " + TABLA + " (id,Nombre_usuario,Contraseña,registro_clientes,registro_Eps,analisis_Inventario) VALUES (?,?,?,?,?,?)";
            //preparar sentencia
            PreparedStatement ps = this.conn.prepareStatement(sentencia);
            //le paso los parámetros
            ps.setInt(1, gerenteVO.getid());
            ps.setString(2, gerenteVO.getNombre_usuario());
            ps.setString(3, gerenteVO.getContraseña());
            ps.setString(4, gerenteVO.getRegistro_clientes());
            ps.setString(5, gerenteVO.getRegsitro_EPS());
            ps.setString(6, gerenteVO.getAnalisis_inventario());
            //ejecutar sentencia
            ps.execute();
            return true;
        } 
        catch (SQLException ex) {
           
       
        }
        return false;
    }
     public boolean ActualizarGerente() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
           
            String sentencia = "UPDATE "+TABLA+" SET `Nombre_usuario`=?,`Contraseña`=?,`registro_clientes`=?,`registro_Eps`= ? ,`analisis_Inventario`=? WHERE id = ? ";
            //Preparar la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sentencia);
            
            ps.setString(1, gerenteVO.getNombre_usuario());
            ps.setString(2, gerenteVO.getContraseña());
            ps.setString(3, gerenteVO.getRegistro_clientes());
            ps.setString(4, gerenteVO.getRegsitro_EPS());
            ps.setString(5, gerenteVO.getAnalisis_inventario());
            ps.setInt(6, gerenteVO.getid());
            int res = ps.executeUpdate();
            //recorrer resultado
            if (res>0) {
                JOptionPane.showMessageDialog(this.jFrame,"Gerente Aatualizado");
            }else {
            JOptionPane.showMessageDialog(this.jFrame,"Numero de Id inexistente.");
            }
            
            return false;

        } catch (SQLException ex) {
            System.out.println("error en Autenticar usuario: " + ex.getMessage());
        }

        return false;
    }
     
     public boolean BorrarUseuario() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
            String sentencia = "DELETE FROM "+TABLA+" WHERE `id` = ? ";
            //preparar sentencia
            PreparedStatement ps = this.conn.prepareStatement(sentencia);
            //le paso los parámetr
             ps.setLong(1, gerenteVO.getid());
            //ejecutar sentencia
             int res = ps.executeUpdate();
           
             if (res>0) {
                JOptionPane.showMessageDialog(this.jFrame,"Gerente Eliminado");
                
            }else {
            JOptionPane.showMessageDialog(this.jFrame,"Numero de cedula inexistente.");
            }
              return false;
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this.jFrame,"Numero de cedula inexistente.");
        }
        return false;
    }
     public boolean AutenticarUsurario() {
        try {
            //sentencia con un parámetro indicado por el signo ?
            String sentencia = "SELECT * FROM " + TABLA + " WHERE Nombre_ususario=? AND Contraseña = ?";
            //Preparar la sentencia
            PreparedStatement ps = this.conn.prepareStatement(sentencia);
            ps.setString(1, this.gerenteVO.getNombre_usuario());
             ps.setString(2, this.gerenteVO.getContraseña());
            //almacenar resultado
            ResultSet resultado = ps.executeQuery();
            //recorrer resultado
            if (resultado.next()) {
            return true;    
            }
            return false;

        } catch (SQLException ex) {
            System.out.println("error en Autenticar usuario: " + ex.getMessage());
        }

        return false;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import VO.UsuarioVO;
import bd.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author USUARIO
 */
public class usuarioModel {
      private UsuarioVO usuarioVO;
    private Connection conn;
    private JFrame jFrame;
    
    public UsuarioVO geUsuarioVO() {
        return usuarioVO;
    }
    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }
    
    public usuarioModel(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
        this.conn = new Conexion().conectar();
    }
    
    
    public ArrayList<UsuarioVO> ConFiltro(String filtro, String consulta) {
        try {
            //sentencia con un parámetro indicado por el signo ?
           String sentencia = "" ;
            if(filtro.equals("Nombres")){
            sentencia = "call spConsultarClientesName(?)";
            }else if(filtro.equals("Email")){
             sentencia = "call spConsultarClientesMail(?)";
            }else if(filtro.equals("Apellidos")){
             sentencia = "call spConsultarClientesApellidos(?)";
            }
            //Preparar la sentencia
            CallableStatement pa = conn.prepareCall(sentencia); 
           pa.setString(1, consulta);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
             ArrayList<UsuarioVO> listaUsuario = new ArrayList<UsuarioVO>();
            while (resultado.next()) {
                 UsuarioVO us = new UsuarioVO();
               us.setId(resultado.getInt("id"));
                us.setCodigoDrogeria(resultado.getInt("codigoDrogeria"));
                us.setEps(resultado.getString("Eps"));
                us.setNombres(resultado.getString("Nombres"));
                us.setEmail(resultado.getString("Email"));
                us.setConstraseña(resultado.getString("contraseña"));
                us.setTelefono(resultado.getString("telefono"));
                us.setDireccion(resultado.getString("direccion"));
                listaUsuario.add(us);

            }
            return  listaUsuario;

        } catch (SQLException ex) {
            System.out.println("error en consultar usuario: " + ex.getMessage());
        }

        return null;
    }
    
     public ArrayList<UsuarioVO> listarUsuarios() {
        try {
            //sentencia con un parámetro indicado por el signo ?
             String sentencia = "call 	spConsultarClientes()";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
             ArrayList<UsuarioVO> listaUsuario = new ArrayList<UsuarioVO>();
            while (resultado.next()) {
                 UsuarioVO us = new UsuarioVO();
                us.setId(resultado.getInt("id"));
                us.setCodigoDrogeria(resultado.getInt("codigoDrogeria"));
                us.setEps(resultado.getString("Eps"));
                us.setNombres(resultado.getString("Nombres"));
                us.setApellidos(resultado.getString("Apellidos"));
                us.setEmail(resultado.getString("Email"));
                us.setConstraseña(resultado.getString("contraseña"));
                us.setTelefono(resultado.getString("telefono"));
                us.setDireccion(resultado.getString("direccion"));
                listaUsuario.add(us);

            }
            return  listaUsuario;
        } catch (SQLException ex) {
            System.out.println("Error en listar usuario: " + ex.getMessage());
        }

        return null;
    }
     
     public boolean insertarUsuario() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
            String sentencia = "call spInsertCliente (?,?,?,?,?,?,?,?)";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            pa.setInt(1, usuarioVO.getCodigoDrogeria());
            pa.setString(2, usuarioVO.getEps());
            pa.setString(3, usuarioVO.getNombres());
            pa.setString(4, usuarioVO.getApellidos());
            pa.setString(5, usuarioVO.getEmail());
            pa.setString(6, usuarioVO.getConstraseña());
            pa.setString(7, usuarioVO.getTelefono());
            pa.setString(8, usuarioVO.getDireccion());
            //ejecutar sentencia
             pa.execute();
            return true;
        } 
        catch (SQLException ex) {
       
        System.out.println("error en Autualizar usuario: " + ex.getMessage());
        }
        return false;
    }
     public boolean ActualizarUsuario() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
           
            String sentencia = "call spUpdateCliente (?,?,?,?,?,?,?,?,?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
            
//            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
           ps.setInt(1, usuarioVO.getCodigoDrogeria());
            ps.setString(2, usuarioVO.getEps());
            ps.setString(3, usuarioVO.getNombres());
            ps.setString(4, usuarioVO.getApellidos());
            ps.setString(5, usuarioVO.getEmail());
            ps.setString(6, usuarioVO.getConstraseña());
            ps.setString(7, usuarioVO.getTelefono());
            ps.setString(8, usuarioVO.getDireccion());
            ps.setInt(9, usuarioVO.getId());
            
            //ejecutar sentencia
            
           int res = ps.executeUpdate();;
            //recorrer resultado
            if (res>0) {
               return true;
            }else {
           JOptionPane.showMessageDialog(this.jFrame,"Numero de Id inexistente.");
           }
            
            return false;

        } catch (SQLException ex) {
            System.out.println("error en Autualizar usuario: " + ex.getMessage());
        }

        return false;
    }
     
     public boolean BorrarUsuario() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
          String sentencia = "call spDeleteCliente (?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
            //le paso los parámetr
             ps.setLong(1, usuarioVO.getId());
            //ejecutar sentencia
             int res = ps.executeUpdate();
           
             if (res>0) {
               return true;
                
            }else {
            JOptionPane.showMessageDialog(this.jFrame,"Codigo inexistente.");
            }
              return false;
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this.jFrame," inexistente.");
        }
        return false;
    }
}

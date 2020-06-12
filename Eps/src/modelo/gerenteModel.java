/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import VO.GerenteVO;
import bd.Conexion;
import com.mysql.jdbc.Connection;
import java.sql.CallableStatement;
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
    
    
    public ArrayList<GerenteVO> ConFiltro(String filtro, String consulta) {
        try {
            String sentencia = "" ;
            if(filtro.equals("Nombres")){
            sentencia = "call spConsultarGerentesName(?)";
            }else if(filtro.equals("Email")){
             sentencia = "call spConsultarGerentesEmail(?)";
            }else if(filtro.equals("Apellidos")){
             sentencia = "call spConsultarGerentesApellidos(?)";
            }
            //sentencia con un parámetro indicado por el signo ?
           
            //Preparar la sentencia
            CallableStatement pa = conn.prepareCall(sentencia);            
            pa.setString(1, consulta);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
             ArrayList<GerenteVO> listaUsuario = new ArrayList<GerenteVO>();
            while (resultado.next()) {
                 GerenteVO ge = new GerenteVO();
                ge.setId(resultado.getInt("id"));
                ge.setContraseña(resultado.getString("contraseña"));
                ge.setNombres(resultado.getString("nombres"));
                ge.setApellidos(resultado.getString("apellidos"));
                ge.setEmail(resultado.getString("email"));
                ge.setRegsitro_EPS(resultado.getInt("registro_eps"));
                ge.setRegistro_clientes(resultado.getInt("registro_clientes"));
                ge.setAnalisis_inventario(resultado.getString("analisis_inventario"));
                listaUsuario.add(ge);

            }
            return  listaUsuario;

        } catch (SQLException ex) {
            System.out.println("error en consultar usuario: " + ex.getMessage());
        }

        return null;
    }
    
     public ArrayList<GerenteVO> listarGerente() {
        try {
            //sentencia con un parámetro indicado por el signo ?
             String sentencia = "call spConsultarGerentes()";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
            ArrayList<GerenteVO> listaUsuario = new ArrayList<GerenteVO>();
            while (resultado.next()) {
                GerenteVO ge = new GerenteVO();
                ge.setId(resultado.getInt("id"));
                ge.setContraseña(resultado.getString("contraseña"));
                ge.setNombres(resultado.getString("nombres"));
                ge.setApellidos(resultado.getString("apellidos"));
                ge.setEmail(resultado.getString("email"));
                ge.setRegsitro_EPS(resultado.getInt("registro_eps"));
                ge.setRegistro_clientes(resultado.getInt("registro_clientes"));
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
            String sentencia = "call spInsertGerente (?,?,?,?,?,?,?)";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            pa.setString(1, gerenteVO.getNombres());
            pa.setString(2, gerenteVO.getApellidos());
            pa.setString(3, gerenteVO.getEmail());
            pa.setString(4, gerenteVO.getContraseña());
            pa.setInt(5, gerenteVO.getRegsitro_EPS());
            pa.setInt(6, gerenteVO.getRegistro_clientes());
            pa.setString(7, gerenteVO.getAnalisis_inventario());
            //ejecutar sentencia
            pa.execute();
            return true;
        } 
        catch (SQLException ex) {
       
       
        }
        return false;
    }
     public boolean ActualizarGerente() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
           
            String sentencia = "call spUpdateGerente (?,?,?,?,?,?,?,?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
            
//            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            ps.setString(1, gerenteVO.getNombres());
            ps.setString(2, gerenteVO.getApellidos());
            ps.setString(3, gerenteVO.getEmail());
            ps.setString(4, gerenteVO.getContraseña());
            ps.setInt(5, gerenteVO.getRegsitro_EPS());
            ps.setInt(6, gerenteVO.getRegistro_clientes());
            ps.setString(7, gerenteVO.getAnalisis_inventario());
            ps.setInt(8, gerenteVO.getId());
            //ejecutar sentencia
            
           int res = ps.executeUpdate();;
            //recorrer resultado
            if (res>0) {
             return true;
                
            }            
            return false;

        } catch (SQLException ex) {
            System.out.println("error en Autenticar usuario: " + ex.getMessage());
        }

        return false;
    }
     
     public boolean BorrarGerente() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
          String sentencia = "call spDeleteGerente (?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
            //le paso los parámetr
             ps.setLong(1, gerenteVO.getId());
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
     public boolean AutenticarUsurario(String Rol) {
        try {
            if(Rol.equals("Gerente")){
             //sentencia con un parámetro indicado por el signo ?
           String sentencia = "call spLoginGerente (?,?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
//            ps.setString(1, this.gerenteVO.getNombre_usuario());
             ps.setString(1, this.gerenteVO.getEmail());
             ps.setString(2, this.gerenteVO.getContraseña());
            //almacenar resultado
            ResultSet resultado = ps.executeQuery();
            //recorrer resultado
            if (resultado.next()){
            return true;    
            }
            return false;
        }else if(Rol.equals("Cliente")){
             //sentencia con un parámetro indicado por el signo ?
           String sentencia = "call spLoginCliente (?,?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
//            ps.setString(1, this.gerenteVO.getNombre_usuario());
             ps.setString(1, this.gerenteVO.getEmail());
             ps.setString(2, this.gerenteVO.getContraseña());
            //almacenar resultado
            ResultSet resultado = ps.executeQuery();
            //recorrer resultado
            if (resultado.next()) {
            return true;    
            }
            return false;
        }
           

        } catch (SQLException ex) {
            System.out.println("error en Autenticar usuario: " + ex.getMessage());
        }

        return false;
    }
}

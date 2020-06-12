/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import VO.MedicamentosVO;
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
public class medicamentosModel {
     private MedicamentosVO medicamentosVO;
    private Connection conn;
    private JFrame jFrame;
    
    public MedicamentosVO getMedicamentoVO() {
        return medicamentosVO;
    }
    public void setMedicamentoVO(MedicamentosVO medicamentosVO) {
        this.medicamentosVO = medicamentosVO;
    }
    
    public medicamentosModel(MedicamentosVO medicamentosVO) {
        this.medicamentosVO = medicamentosVO;
        this.conn = new Conexion().conectar();
    }
    
    
    public ArrayList<MedicamentosVO> ConFiltro(String filtro, String consulta) {
        try {
            //sentencia con un parámetro indicado por el signo ?
           String sentencia = "" ;
            if(filtro.equals("Nombre")){
            sentencia = "call spConsultarMedicamentosName(?)";
            }else if(filtro.equals("Tipo")){
             sentencia = "call spConsultarMedicamentosTipo(?)";
            }else if(filtro.equals("Presentacion")){
             sentencia = "call spConsultarMedicamentosPres(?)";
            }
            //Preparar la sentencia
            CallableStatement pa = conn.prepareCall(sentencia); 
           pa.setString(1, consulta);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
             ArrayList<MedicamentosVO> listaUsuario = new ArrayList<MedicamentosVO>();
            while (resultado.next()) {
                 MedicamentosVO me = new MedicamentosVO();
                me.setCodigo(resultado.getInt("codigo"));
                me.setNombre(resultado.getString("nombre"));
                me.setTipo(resultado.getString("tipo"));
                me.setPresentacion(resultado.getString("presentacion"));
                me.setCantidad(resultado.getInt("cantidad"));
                me.setCura(resultado.getString("cura"));
                me.setPrecio(resultado.getInt("precio"));
                listaUsuario.add(me);

            }
            return  listaUsuario;

        } catch (SQLException ex) {
            System.out.println("error en consultar usuario: " + ex.getMessage());
        }

        return null;
    }
    
     public ArrayList<MedicamentosVO> listarMedicamento() {
        try {
            //sentencia con un parámetro indicado por el signo ?
             String sentencia = "call spConsultarMedicamentos()";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
             ArrayList<MedicamentosVO> listaUsuario = new ArrayList<MedicamentosVO>();
            while (resultado.next()) {
                 MedicamentosVO me = new MedicamentosVO();
                me.setCodigo(resultado.getInt("codigo"));
                me.setNombre(resultado.getString("nombre"));
                me.setTipo(resultado.getString("tipo"));
                me.setPresentacion(resultado.getString("presentacion"));
                me.setCantidad(resultado.getInt("cantidad"));
                me.setCura(resultado.getString("cura"));
                me.setPrecio(resultado.getInt("precio"));
                listaUsuario.add(me);

            }
            return  listaUsuario;
        } catch (SQLException ex) {
            System.out.println("Error en listar usuario: " + ex.getMessage());
        }

        return null;
    }
     
     public boolean insertarMedicamento() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
            String sentencia = "call spInsertMedicamento (?,?,?,?,?,?)";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            pa.setString(1, medicamentosVO.getNombre());
            pa.setString(2, medicamentosVO.getTipo());
            pa.setString(3, medicamentosVO.getPresentacion());
            pa.setInt(4, medicamentosVO.getCantidad());
            pa.setString(5, medicamentosVO.getCura());
            pa.setInt(6, medicamentosVO.getPrecio());
            //ejecutar sentencia
            pa.execute();
            return true;
        } 
        catch (SQLException ex) {
       
       
        }
        return false;
    }
     public boolean ActualizarMedicamento() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
           
            String sentencia = "call spUpdateMedicamento (?,?,?,?,?,?,?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
            
//            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            ps.setString(1, medicamentosVO.getNombre());
            ps.setString(2, medicamentosVO.getTipo());
            ps.setString(3, medicamentosVO.getPresentacion());
            ps.setInt(4, medicamentosVO.getCantidad());
            ps.setString(5, medicamentosVO.getCura());
            ps.setInt(6, medicamentosVO.getPrecio());
            ps.setInt(7, medicamentosVO.getCodigo());
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
     
     public boolean BorrarMedicamento() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
          String sentencia = "call spDeleteMedicamento (?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
            //le paso los parámetr
             ps.setLong(1, medicamentosVO.getCodigo());
            //ejecutar sentencia
             int res = ps.executeUpdate();
           
             if (res>0) {
               return true;
                
            }else {
            JOptionPane.showMessageDialog(this.jFrame,"Numero de cedula inexistente.");
            }
              return false;
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this.jFrame,"Numero de cedula inexistente.");
        }
        return false;
    }
    
}

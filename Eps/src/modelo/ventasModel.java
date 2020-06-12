/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import VO.VentasVO;
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
public class ventasModel {
     private VentasVO ventasVO;
    private Connection conn;
    private JFrame jFrame;
    
    public VentasVO getVentasVO() {
        return ventasVO;
    }
    public void setVentasVO(VentasVO ventasVO) {
        this.ventasVO = ventasVO;
    }
    
    public ventasModel(VentasVO medicamentosVO) {
        this.ventasVO = ventasVO;
        this.conn = new Conexion().conectar();
    }
    
     public ArrayList<VentasVO> listarVentas() {
        try {
            //sentencia con un parámetro indicado por el signo ?
             String sentencia = "call spConsultarVenta()";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
             ArrayList<VentasVO> listaVenta = new ArrayList<VentasVO>();
            while (resultado.next()) {
                 VentasVO ve = new VentasVO();
                ve.setId(resultado.getInt("CodigoVenta"));
                ve.setRegistroProducto(resultado.getInt("registro_facturas"));
                ve.setRegistroPrecio(resultado.getInt("Subtotal"));
                ve.setTotalVentas(resultado.getInt("total_ventas"));
                ve.setRegistroFacturas(resultado.getInt("registro_facturas"));
                listaVenta.add(ve);

            }
            return  listaVenta;
        } catch (SQLException ex) {
            System.out.println("Error en listar venta: " + ex.getMessage());
        }

        return null;
    }
     
     public boolean insertarVenta() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
            String sentencia = "call spInsertVenta (?,?,?,?,?)";
            //preparar sentencia
      
            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            pa.setString(1, ventasVO.getFechaVenta());
            pa.setInt(2, ventasVO.getRegistroProducto());
            pa.setInt(3, ventasVO.getRegistroPrecio());
            pa.setInt(4, ventasVO.getTotalVentas());
            pa.setInt(5, ventasVO.getRegistroFacturas());
            //ejecutar sentencia
            pa.execute();
            return true;
        } 
        catch (SQLException ex) {
       
       
        }
        return false;
    }
}

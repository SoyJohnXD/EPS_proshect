/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import VO.EpsVO;
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
public class epsModel {
    private EpsVO epsVO;
    private Connection conn;
    private final String TABLA = "gerente";
    private JFrame jFrame;

    public EpsVO getEpsVO() {
        return epsVO;
    }
    public void setGerenteVO(EpsVO epsVO) {
        this.epsVO = epsVO;
    }

    public epsModel(EpsVO epsVO) {
        this.epsVO = epsVO;
        this.conn = new Conexion().conectar();
    }


    public ArrayList<EpsVO> ConFiltro(String filtro, String consulta) {
        try {
            //sentencia con un parámetro indicado por el signo ?
           String sentencia = "call spConsultarEps(?,?)";
            //Preparar la sentencia
            CallableStatement pa = conn.prepareCall(sentencia);
            pa.setString(0, filtro);
            pa.setString(0, consulta);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
             ArrayList<EpsVO> listaEps = new ArrayList<EpsVO>();
            while (resultado.next()) {
                 EpsVO eps = new EpsVO();
                 eps.setNombre(resultado.getString("nombre"));
                 eps.setIdGerente(resultado.getInt("idGerente"));
                 eps.setRegistro(resultado.getString("registro"));
                 eps.setBs_clientes(resultado.getInt("bs_clientes"));
                 eps.setConvenio_pago(resultado.getInt("convenio_pago"));
                 eps.setConvenio_pago(resultado.getLong("convenio_pago"));
                 eps.setEstado(resultado.getString("Estado"));
                listaEps.add(eps);

            }
            return  listaEps;

        } catch (SQLException ex) {
            System.out.println("error en consultar las eps: " + ex.getMessage());
        }

        return null;
    }

     public ArrayList<EpsVO> listarEps() {
        try {
            //sentencia con un parámetro indicado por el signo ?
             String sentencia = "call spCargarEps()";
            //preparar sentencia

            CallableStatement pa = this.conn.prepareCall(sentencia);
            //almacenar resultado
            ResultSet resultado = pa.executeQuery();
            //recorrer resultado
            ArrayList<EpsVO> listaEps = new ArrayList<EpsVO>();
            while (resultado.next()) {
                 EpsVO eps = new EpsVO();
                 eps.setNombre(resultado.getString("nombre"));
                 eps.setIdGerente(resultado.getInt("idGerente"));
                 eps.setRegistro(resultado.getString("registro"));
                 eps.setBs_clientes(resultado.getInt("bs_clientes"));
                 eps.setConvenio_pago(resultado.getInt("convenio_pago"));
                 eps.setConvenio_pago(resultado.getLong("convenio_pago"));
                 eps.setEstado(resultado.getString("Estado"));
                listaEps.add(eps);
            }
            return listaEps;
        } catch (SQLException ex) {
            System.out.println("Error en listar eps: " + ex.getMessage());
        }

        return null;
    }

     public boolean insertarEps() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
            String sentencia = "call spInsertEps (?,?,?,?,?,?,?)";
            //preparar sentencia

            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            pa.setString(1, epsVO.getNombre());
            pa.setInt(2, epsVO.getIdGerente());
            pa.setString(3, epsVO.getRegistro());
            pa.setInt(4, epsVO.getBs_clientes());
            pa.setInt(5, epsVO.getLista_conve());
            pa.setInt(6, epsVO.getPatologias_cliente());
            pa.setLong(7, epsVO.getConvenio_pago());
            pa.setString(8, epsVO.getEstado());
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

            String sentencia = "call spUpdateEps(?,?,?,?,?,?,?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);

//            CallableStatement pa = this.conn.prepareCall(sentencia);
            //le paso los parámetros
            ps.setString(1, epsVO.getNombre());
            ps.setInt(2, epsVO.getIdGerente());
            ps.setString(3, epsVO.getRegistro());
            ps.setInt(4, epsVO.getBs_clientes());
            ps.setInt(5, epsVO.getLista_conve());
            ps.setInt(6, epsVO.getPatologias_cliente());
            ps.setLong(7, epsVO.getConvenio_pago());
            ps.setString(8, epsVO.getEstado());
            //ejecutar sentencia

           int res = ps.executeUpdate();
            //recorrer resultado
            if (res>0) {
                JOptionPane.showMessageDialog(this.jFrame,"Eps Atualizada");
            }else {
           JOptionPane.showMessageDialog(this.jFrame,"Esta EPS no existe.");
           }

            return false;

        } catch (SQLException ex) {
            System.out.println("error en actualizar EPS: " + ex.getMessage());
        }

        return false;
    }

     public boolean BorrarEps() {
        try {
            //Los parámetros se identifican con el ?, inician desde 1 y se cuenta de izquierda a derecha
          String sentencia = "call spDeleteEps(?)";
            //Preparar la sentencia
             CallableStatement ps = this.conn.prepareCall(sentencia);
            //le paso los parámetr
             ps.setString(1, epsVO.getNombre());
            //ejecutar sentencia
             int res = ps.executeUpdate();

             if (res>0) {
                JOptionPane.showMessageDialog(this.jFrame,"Eps Eliminado");

            }else {
            JOptionPane.showMessageDialog(this.jFrame,"La EPS no existe");
            }
              return false;

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this.jFrame,"Error al eliminar la EPS.");
        }
        return false;
    }
}

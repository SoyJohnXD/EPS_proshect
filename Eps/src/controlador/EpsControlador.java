/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import VO.EpsVO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.epsModel;
import vista.EPS;

/**
 *
 * @author USUARIO
 */
public class EpsControlador {
   private EpsVO epsVO;
   private epsModel eps; 
   private JFrame jFrame;


   
  
   

    public EpsControlador(EpsVO epsVO, JFrame jFrame) {
        this.epsVO = epsVO;
        this.eps = new epsModel(epsVO);
        this.jFrame = jFrame;

    }

    public ArrayList<EpsVO> listarEps() {
            new EPS().setVisible(true);
            this.jFrame.setVisible(false);
        return this.eps.listarEps();
    }
 public void InEps() {

        boolean respuesta = this.eps.insertarEps();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Eps Registrada!");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "No se pudo registrar la EPS");
        }
    }
 
 public void UpdateEps() {

        boolean respuesta = this.eps.ActualizarGerente();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Se actualizó la EPS");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "No se pudo actualizar la EPS");
        }
    }
 public void DeleteEps() {

        boolean respuesta = this.eps.BorrarEps();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Se eliminó la EPS");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "No se pudo eliminar la EPS");
        }
    }
 
 public ArrayList<EpsVO> ConFiltro(String Filtro, String Consulta) {

         return this.eps.ConFiltro(Filtro,Consulta);
        
    }
}

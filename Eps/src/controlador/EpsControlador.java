/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import VO.GerenteVO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.gerenteModel;
import vista.CRUD_gerente;

/**
 *
 * @author USUARIO
 */
public class GerenteControlador {
   private GerenteVO geVO;
   private gerenteModel gerente; 
   private JFrame jFrame;


   
  
   

    public GerenteControlador(GerenteVO geVO, JFrame jFrame) {
        this.geVO = geVO;
        this.gerente = new gerenteModel(geVO);
        this.jFrame = jFrame;

    }

    public void autenticarUsuario(String Rol) {

         boolean respuesta = this.gerente.AutenticarUsurario(Rol);
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario Correcto");
            new CRUD_gerente().setVisible(true);
            this.jFrame.setVisible(false);

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario No  Registrado");
        }
    }

    public ArrayList<GerenteVO> listarGerente() {

        return this.gerente.listarGerente();
    }
 public void InGerente() {

        boolean respuesta = this.gerente.insertarGerente();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario Registrado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario No  Registrado");
        }
    }
 
 public void UpdateGerente() {

        boolean respuesta = this.gerente.ActualizarGerente();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario Actualizado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario No  Actualizado");
        }
    }
 public void DeleteGerente() {

        boolean respuesta = this.gerente.BorrarGerente();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario Actualizado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario No  Actualizado");
        }
    }
 
 public ArrayList<GerenteVO> ConFiltro(String Filtro, String Consulta) {

         return this.gerente.ConFiltro(Filtro,Consulta);
        
    }
}

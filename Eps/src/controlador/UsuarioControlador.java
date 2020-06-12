/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import VO.UsuarioVO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.usuarioModel;

/**
 *
 * @author USUARIO
 */
public class UsuarioControlador {
     private UsuarioVO usVO;
   private usuarioModel usuario; 
   private JFrame jFrame;


   
  
   

    public UsuarioControlador(UsuarioVO usVO, JFrame jFrame) {
        this.usVO = usVO;
        this.usuario = new usuarioModel(usVO);
        this.jFrame = jFrame;

    }



    public ArrayList<UsuarioVO> listarUsuarios() {

        return this.usuario.listarUsuarios();
    }
 public void InUsuarios() {

        boolean respuesta = this.usuario.insertarUsuario();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario Registrado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario No  Registrado");
        }
    }
 
 public void UpdateUsuarios() {

        boolean respuesta = this.usuario.ActualizarUsuario();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario Actualizado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario No  Actualizado");
        }
    }
 public void DeleteUsuario() {

        boolean respuesta = this.usuario.BorrarUsuario();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario Actualizado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Usuario No  Actualizado");
        }
    }
 
 public ArrayList<UsuarioVO> ConFiltro(String Filtro, String Consulta) {

         return this.usuario.ConFiltro(Filtro,Consulta);
        
    }
}

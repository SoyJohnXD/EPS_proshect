/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import VO.VentasVO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.ventasModel;


/**
 *
 * @author USUARIO
 */
public class VentasControlador {
     private VentasVO veVO;
    private ventasModel ventas; 
    private JFrame jFrame;

    public VentasControlador(VentasVO veVO, JFrame jFrame) {
        this.veVO = veVO;
        this.ventas = new ventasModel(veVO);
        this.jFrame = jFrame;
    }

    public ArrayList<VentasVO> listarVentas() {
        return this.ventas.listarVentas();
    }
    
    public void InVenta() {

        boolean respuesta = this.ventas.insertarVenta();
        if (respuesta) {
            JOptionPane.showMessageDialog(this.jFrame, "Venta registrada.");
        } else {
            JOptionPane.showMessageDialog(this.jFrame, "Venta no registrada");
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import VO.MedicamentosVO;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.medicamentosModel;


/**
 *
 * @author USUARIO
 */
public class MedicamentosControlador {
     private MedicamentosVO meVO;
   private medicamentosModel medicamentos; 
   private JFrame jFrame;


   
  
   

    public MedicamentosControlador(MedicamentosVO meVO, JFrame jFrame) {
        this.meVO = meVO;
        this.medicamentos = new medicamentosModel(meVO);
        this.jFrame = jFrame;

    }


    public ArrayList<MedicamentosVO> listarMedicamento() {

        return this.medicamentos.listarMedicamento();
    }
 public void InMedicamento() {

        boolean respuesta = this.medicamentos.insertarMedicamento();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "medicamento Registrado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "medicamento No  Registrado");
        }
    }
 
 public void UpdateMedicamento() {

        boolean respuesta = this.medicamentos.ActualizarMedicamento();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Medicamento Actualizado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Medicamento No  Actualizado");
        }
    }
 public void DeleteGerente() {

        boolean respuesta = this.medicamentos.BorrarMedicamento();
        if (respuesta) {

            JOptionPane.showMessageDialog(this.jFrame, "Medicamento Actualizado");
           

        } else {

            JOptionPane.showMessageDialog(this.jFrame, "Medicamento No  Actualizado");
        }
    }

}


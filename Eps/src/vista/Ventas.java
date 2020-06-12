/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import VO.VentasVO;
import controlador.VentasControlador;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.ventasModel;

/**
 *
 * @author developer3
 */
public class Ventas extends javax.swing.JFrame {
private VentasVO ventasVO;
    private VentasControlador ventasControlador ;
   private ventasModel ventas;
    /**
     * Creates new form Medicamentos
     */
    public Ventas() {
        initComponents();
        ventasVO = new VentasVO();
        ventasControlador = new VentasControlador((ventasVO), this);
        ventas = new ventasModel(ventasVO);
                 
        
        jTable1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    Txtcodigo.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    txtFechaVenta.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                    txtRegistroFacturas.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    txtRegistroPrecio.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                    txtRegistroProducto.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
                    txtTotalVentas.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
                }

            }
        }
        
     );
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (VentasVO u : ventasControlador.listarVentas()) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getFechaVenta(),
                String.valueOf(u.getRegistroProducto()),
                String.valueOf(u.getRegistroPrecio()),
                String.valueOf(u.getTotalVentas()),
                String.valueOf(u.getRegistroFacturas())};
                model.addRow(fila);
        }
        ListSelectionModel listarVentas;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        BtnBuscar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTotalVentas = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnRegistrar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtRegistroFacturas = new javax.swing.JTextField();
        txtFiltro = new javax.swing.JTextField();
        txtRegistroPrecio = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtFechaVenta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRegistroProducto = new javax.swing.JTextField();
        Txtcodigo = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel7.setText("Ingrese un dato para consultar:");

        BtnBuscar.setBackground(new java.awt.Color(204, 255, 255));
        BtnBuscar.setText("Buscar");
        BtnBuscar.setName("btnBuscarVentas"); // NOI18N
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        jLabel8.setText("Registro de precio:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Valor", "Precio", "Total ventas", "Facturas", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName("tableVentas"); // NOI18N
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Ventas");

        txtTotalVentas.setName("txt_total_ventas"); // NOI18N
        txtTotalVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalVentasActionPerformed(evt);
            }
        });

        jLabel9.setText("Total ventas:");

        jLabel2.setText("Valor:");

        jLabel3.setText("Registro de facturas:");

        BtnRegistrar.setBackground(new java.awt.Color(204, 255, 204));
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.setName("BtnRegistrar"); // NOI18N
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(204, 255, 255));
        jButton2.setText("Limpiar");
        jButton2.setName("btnLimpiarVentas"); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtRegistroFacturas.setName("txt_registro_facturas"); // NOI18N
        txtRegistroFacturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistroFacturasActionPerformed(evt);
            }
        });

        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });

        txtRegistroPrecio.setName("txt_registro_precio"); // NOI18N
        txtRegistroPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRegistroPrecioActionPerformed(evt);
            }
        });

        txtFechaVenta.setName("txt_nombres"); // NOI18N
        txtFechaVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaVentaActionPerformed(evt);
            }
        });

        jLabel5.setText("Registro producto:");

        txtRegistroProducto.setName("txt_subtotal"); // NOI18N

        Txtcodigo.setBorder(null);
        Txtcodigo.setMaximumSize(new java.awt.Dimension(0, 0));
        Txtcodigo.setMinimumSize(new java.awt.Dimension(0, 0));
        Txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtcodigoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFiltro)
                            .addGap(18, 18, 18)
                            .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(24, 24, 24))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtFechaVenta))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRegistroPrecio))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtRegistroFacturas, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtTotalVentas)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtRegistroProducto)))
                                .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(21, 21, 21)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(341, 341, 341)
                    .addComponent(Txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(341, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFechaVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtRegistroProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtRegistroPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTotalVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRegistroFacturas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnRegistrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnBuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(186, 186, 186)
                    .addComponent(Txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(187, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void txtTotalVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalVentasActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
        if ((txtFechaVenta.getText().equals("")) || (txtRegistroFacturas.getText().equals("")) || (txtRegistroPrecio.getText().equals("")) || (txtRegistroProducto.getText().equals("")) || (txtTotalVentas.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "No puedes dejar campos vacíos.");
        } else {
            ventasVO.setFechaVenta(txtFechaVenta.getText());
            ventasVO.setRegistroProducto(Integer.parseInt(txtRegistroProducto.getText()));
            ventasVO.setRegistroPrecio(Integer.parseInt(txtRegistroPrecio.getText()));
            ventasVO.setTotalVentas(Integer.parseInt(txtTotalVentas.getText()));
            ventasVO.setRegistroFacturas(Integer.parseInt(txtRegistroFacturas.getText()));
            ventasControlador.InVenta();
              
                DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
                int a = jTable1.getRowCount() - 1;
                for (int i = a; i >= 0; i--) {
                    tb.removeRow(tb.getRowCount() - 1);
                }

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for (VentasVO u : ventasControlador.listarVentas()) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getFechaVenta(),
                String.valueOf(u.getRegistroProducto()),
                String.valueOf(u.getRegistroPrecio()),
                String.valueOf(u.getTotalVentas()),
                String.valueOf(u.getRegistroFacturas())};
            model.addRow(fila);
        }
    
      txtFechaVenta.setText("");
      txtRegistroPrecio.setText("");
      txtTotalVentas.setText("");
      txtRegistroFacturas.setText("");
      txtRegistroProducto.setText("");
      }
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        txtFechaVenta.setText("");
      txtRegistroProducto.setText("");
      txtRegistroPrecio.setText("");
      txtTotalVentas.setText("");
      txtRegistroFacturas.setText("");
      
       DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
                int a = jTable1.getRowCount() - 1;
                for (int i = a; i >= 0; i--) {
                    tb.removeRow(tb.getRowCount() - 1);
                }

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (VentasVO u : ventasControlador.listarVentas()) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getFechaVenta(),
                String.valueOf(u.getRegistroProducto()),
                String.valueOf(u.getRegistroPrecio()),
                String.valueOf(u.getTotalVentas()),
                String.valueOf(u.getRegistroFacturas())};
                model.addRow(fila);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtRegistroFacturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistroFacturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistroFacturasActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void txtRegistroPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRegistroPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRegistroPrecioActionPerformed

    private void txtFechaVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaVentaActionPerformed

    private void TxtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtcodigoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JTextField Txtcodigo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFechaVenta;
    private javax.swing.JTextField txtFiltro;
    private javax.swing.JTextField txtRegistroFacturas;
    private javax.swing.JTextField txtRegistroPrecio;
    private javax.swing.JTextField txtRegistroProducto;
    private javax.swing.JTextField txtTotalVentas;
    // End of variables declaration//GEN-END:variables
}

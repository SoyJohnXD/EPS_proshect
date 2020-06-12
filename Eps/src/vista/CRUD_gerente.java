/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import VO.GerenteVO;
import controlador.GerenteControlador;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.gerenteModel;


/**
 *
 * @author developer3
 */
public class CRUD_gerente extends javax.swing.JFrame {

    private GerenteVO gerenteVO;
    private GerenteControlador gerenteControlador ;
   private gerenteModel gerente;
    /**
     * Creates new form CRUD_gerente
     */
    public CRUD_gerente() {
        initComponents();
        jTable1.getColumnModel().getColumn(0).setWidth(0);
        jTable1.getColumnModel().getColumn(0).setMinWidth(0);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(0);
        jTable1.getColumnModel().getColumn(1).setWidth(0);
        jTable1.getColumnModel().getColumn(1).setMinWidth(0);
        jTable1.getColumnModel().getColumn(1).setMaxWidth(0);
        gerenteVO = new GerenteVO();
        gerenteControlador = new GerenteControlador((gerenteVO), this);
        gerente = new gerenteModel(gerenteVO);
        jTable1.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent Mouse_evt) {
                JTable table = (JTable) Mouse_evt.getSource();
                Point point = Mouse_evt.getPoint();
                int row = table.rowAtPoint(point);
                if (Mouse_evt.getClickCount() == 1) {
                    TxtPass.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 1).toString());
                    TxtId.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 0).toString());
                    TxtNombres.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2).toString());
                    TxtApellidos.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3).toString());
                    TxtEmail.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 4).toString());
                    TxtRegisClient.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 5).toString());
                    TxtRegisEps.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 6).toString());
                    TxtAnalisis.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 7).toString());
                }

            }
        }
        
     );
           
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (GerenteVO u : gerenteControlador.listarGerente()) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getContraseña(),
                u.getNombres(),
                u.getApellidos(),
                u.getEmail(),
                String.valueOf(u.getRegsitro_EPS()),
                String.valueOf(u.getRegistro_clientes()),
                u.getAnalisis_inventario()};
            model.addRow(fila);
        }
        ListSelectionModel listusuario;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        TxtPass = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TxtRegisClient = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        TxtRegisEps = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TxtAnalisis = new javax.swing.JTextField();
        BtnRegistrar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        BtnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        BtnBuscar = new javax.swing.JButton();
        TxtApellidos = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TxtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TxtId = new javax.swing.JTextField();
        CBFiltro = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Gerente");

        jLabel2.setText("Nombres:");

        TxtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombresActionPerformed(evt);
            }
        });

        jLabel3.setText("Contraseña:");

        TxtPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtPassActionPerformed(evt);
            }
        });

        jLabel4.setText("Registro de clientes:");

        TxtRegisClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRegisClientActionPerformed(evt);
            }
        });

        jLabel5.setText("Análisis de inventario:");

        TxtRegisEps.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtRegisEpsActionPerformed(evt);
            }
        });

        jLabel6.setText("Registros de EPS:");

        TxtAnalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtAnalisisActionPerformed(evt);
            }
        });

        BtnRegistrar.setBackground(new java.awt.Color(204, 255, 204));
        BtnRegistrar.setText("Registrar");
        BtnRegistrar.setName("BtnRegistrar"); // NOI18N
        BtnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarActionPerformed(evt);
            }
        });

        btnLimpiar.setBackground(new java.awt.Color(204, 255, 255));
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        BtnActualizar.setBackground(new java.awt.Color(255, 255, 204));
        BtnActualizar.setText("Actualizar");
        BtnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnActualizarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "contraseña", "Nombres", "Apellidos", "Email", "Registros de EPS", "Registro de clientes", "Análisis de inventario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setName(""); // NOI18N
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel7.setText("Ingrese un dato para consultar:");

        txtFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltroActionPerformed(evt);
            }
        });

        BtnBuscar.setBackground(new java.awt.Color(204, 255, 255));
        BtnBuscar.setText("Buscar");
        BtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBuscarActionPerformed(evt);
            }
        });

        TxtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidosActionPerformed(evt);
            }
        });

        jLabel8.setText("Apellidos:");

        TxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtEmailActionPerformed(evt);
            }
        });

        jLabel9.setText("Email:");

        TxtId.setBorder(null);
        TxtId.setMaximumSize(new java.awt.Dimension(0, 0));
        TxtId.setMinimumSize(new java.awt.Dimension(0, 0));
        TxtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtIdActionPerformed(evt);
            }
        });

        CBFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione...", "Nombres", "Apellidos", "Email" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                    .addComponent(TxtPass))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(TxtAnalisis)
                                    .addComponent(TxtRegisEps)
                                    .addComponent(TxtRegisClient)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(127, 127, 127)
                                        .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BtnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(BtnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(177, 177, 177))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                                .addGap(106, 106, 106))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(33, 33, 33)
                                .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TxtRegisClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TxtRegisEps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(TxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TxtAnalisis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TxtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnActualizar)
                    .addComponent(btnLimpiar)
                    .addComponent(BtnRegistrar))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnBuscar)
                        .addComponent(CBFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombresActionPerformed

    private void TxtPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtPassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtPassActionPerformed

    private void TxtRegisClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRegisClientActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtRegisClientActionPerformed

    private void TxtRegisEpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtRegisEpsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtRegisEpsActionPerformed

    private void TxtAnalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtAnalisisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtAnalisisActionPerformed

    private void txtFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltroActionPerformed

    private void BtnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarActionPerformed
      if ((TxtNombres.getText().equals("")) || (TxtApellidos.getText().equals("")) || (TxtEmail.getText().equals("")) || (TxtPass.getText().equals("")) || (TxtRegisClient.getText().equals("")) || (TxtRegisEps.getText().equals(""))|| (TxtAnalisis.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "No puedes dejar campos Vacios");
        } else {
            gerenteVO.setNombres(TxtNombres.getText());
            gerenteVO.setApellidos(TxtApellidos.getText());
            gerenteVO.setEmail(TxtEmail.getText());
            gerenteVO.setContraseña(TxtPass.getText());
            gerenteVO.setRegistro_clientes(Integer.parseInt(TxtRegisClient.getText()));
            gerenteVO.setRegsitro_EPS(Integer.parseInt(TxtRegisEps.getText()));
            gerenteVO.setAnalisis_inventario(TxtAnalisis.getText());
            gerenteControlador.InGerente();
               

                DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
                int a = jTable1.getRowCount() - 1;
                for (int i = a; i >= 0; i--) {
                    tb.removeRow(tb.getRowCount() - 1);
                }

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for (GerenteVO u : gerenteControlador.listarGerente()) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getContraseña(),
                u.getNombres(),
                u.getApellidos(),
                u.getEmail(),
                String.valueOf(u.getRegsitro_EPS()),
                String.valueOf(u.getRegistro_clientes()),
                u.getAnalisis_inventario()};
            model.addRow(fila);
        }
    
      TxtNombres.setText("");
      TxtApellidos.setText("");
      TxtEmail.setText("");
      TxtPass.setText("");
      TxtRegisClient.setText("");
      TxtRegisEps.setText("");
      TxtAnalisis.setText("");
      
      }
    }//GEN-LAST:event_BtnRegistrarActionPerformed

    private void TxtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidosActionPerformed

    private void TxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtEmailActionPerformed

    private void TxtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtIdActionPerformed

    private void BtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBuscarActionPerformed
        // TODO add your handling code here:
        if ((txtFiltro.getText().equals("")) || (CBFiltro.getSelectedItem().equals("seleccione..."))){
            JOptionPane.showMessageDialog(this, "No puedes dejar campos Vacios en el filtro");
        } else {
    
            String Consulta = txtFiltro.getText();
            String filtro = ((String)CBFiltro.getSelectedItem());
            
                DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
                int a = jTable1.getRowCount() - 1;
                for (int i = a; i >= 0; i--) {
                    tb.removeRow(tb.getRowCount() - 1);
                }

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for (GerenteVO u : gerenteControlador.ConFiltro(filtro, Consulta)) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getContraseña(),
                u.getNombres(),
                u.getApellidos(),
                u.getEmail(),
                String.valueOf(u.getRegsitro_EPS()),
                String.valueOf(u.getRegistro_clientes()),
                u.getAnalisis_inventario()};
            model.addRow(fila);
        }
            
              }
    }//GEN-LAST:event_BtnBuscarActionPerformed

    private void BtnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnActualizarActionPerformed
if ((TxtNombres.getText().equals("")) || (TxtApellidos.getText().equals("")) || (TxtEmail.getText().equals("")) || (TxtPass.getText().equals("")) || (TxtRegisClient.getText().equals("")) || (TxtRegisEps.getText().equals(""))|| (TxtAnalisis.getText().equals(""))) {
            JOptionPane.showMessageDialog(this, "No puedes dejar campos Vacios");
        } else {
            gerenteVO.setId(Integer.parseInt(TxtId.getText()));
            gerenteVO.setNombres(TxtNombres.getText());
            gerenteVO.setApellidos(TxtApellidos.getText());
            gerenteVO.setEmail(TxtEmail.getText());
            gerenteVO.setContraseña(TxtPass.getText());
            gerenteVO.setRegistro_clientes(Integer.parseInt(TxtRegisClient.getText()));
            gerenteVO.setRegsitro_EPS(Integer.parseInt(TxtRegisEps.getText()));
            gerenteVO.setAnalisis_inventario(TxtAnalisis.getText());
            gerenteControlador.UpdateGerente();
               

                DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
                int a = jTable1.getRowCount() - 1;
                for (int i = a; i >= 0; i--) {
                    tb.removeRow(tb.getRowCount() - 1);
                }

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for (GerenteVO u : gerenteControlador.listarGerente()) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getContraseña(),
                u.getNombres(),
                u.getApellidos(),
                u.getEmail(),
                String.valueOf(u.getRegsitro_EPS()),
                String.valueOf(u.getRegistro_clientes()),
                u.getAnalisis_inventario()};
            model.addRow(fila);
        }
    
      TxtNombres.setText("");
      TxtApellidos.setText("");
      TxtEmail.setText("");
      TxtPass.setText("");
      TxtRegisClient.setText("");
      TxtRegisEps.setText("");
      TxtAnalisis.setText("");
      
      }        // TODO add your handling code here:
    }//GEN-LAST:event_BtnActualizarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        
        TxtNombres.setText("");
      TxtApellidos.setText("");
      TxtEmail.setText("");
      TxtPass.setText("");
      TxtRegisClient.setText("");
      TxtRegisEps.setText("");
      TxtAnalisis.setText("");
      txtFiltro.setText("");
      CBFiltro.setSelectedItem(0);
      
       DefaultTableModel tb = (DefaultTableModel) jTable1.getModel();
                int a = jTable1.getRowCount() - 1;
                for (int i = a; i >= 0; i--) {
                    tb.removeRow(tb.getRowCount() - 1);
                }

                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                for (GerenteVO u : gerenteControlador.listarGerente()) {
            String[] fila = {
                String.valueOf(u.getId()),
                u.getContraseña(),
                u.getNombres(),
                u.getApellidos(),
                u.getEmail(),
                String.valueOf(u.getRegsitro_EPS()),
                String.valueOf(u.getRegistro_clientes()),
                u.getAnalisis_inventario()};
            model.addRow(fila);
        }
    }//GEN-LAST:event_btnLimpiarActionPerformed
    
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
            java.util.logging.Logger.getLogger(CRUD_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD_gerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnActualizar;
    private javax.swing.JButton BtnBuscar;
    private javax.swing.JButton BtnRegistrar;
    private javax.swing.JComboBox<String> CBFiltro;
    private javax.swing.JTextField TxtAnalisis;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtEmail;
    private javax.swing.JTextField TxtId;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtPass;
    private javax.swing.JTextField TxtRegisClient;
    private javax.swing.JTextField TxtRegisEps;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}

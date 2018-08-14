/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavacar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hanse
 */
public class MServicios extends javax.swing.JPanel {

      ConexionBD cc = new ConexionBD();
    Connection cn = cc.conexion();
    DefaultTableModel modelo;
    public MServicios() {
        initComponents();
        modelo=(DefaultTableModel) jtServicios.getModel();
        mostrarDatos("");
        jbAgregar.setVisible(true);
            jdEliminar.setVisible(true);
            jbGuardar.setVisible(false);
    }

    void mostrarDatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Servicios");
        modelo.addColumn("Precio");
        jtServicios.setModel(modelo);

        String datos[] = new String[2];
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM servicios";
        } else {
            sql = "SELECT * FROM usuarios WHERE servicios= '" + valor + "'";
        }
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                for (int i = 0; i < datos.length; i++) {
                    datos[i] = rs.getString(i + 1);
                }
                modelo.addRow(datos);
            }
            jtServicios.setModel(modelo);
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbBuscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jdMostrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtServicios = new javax.swing.JTable();
        jdModificar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfAgregar = new javax.swing.JTextField();
        jtfPrecio = new javax.swing.JTextField();
        jdEliminar = new javax.swing.JButton();
        jbAgregar = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jdMostrar.setText("Mostrar datos");
        jdMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdMostrarActionPerformed(evt);
            }
        });

        jtServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtServicios);

        jdModificar.setText("Modificar");
        jdModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdModificarActionPerformed(evt);
            }
        });

        jLabel2.setText("Agregar Servicio:");

        jLabel3.setText("Precio:");

        jtfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPrecioActionPerformed(evt);
            }
        });

        jdEliminar.setText("Eliminar");
        jdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdEliminarActionPerformed(evt);
            }
        });

        jbAgregar.setText("Agregar");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbGuardar.setText("Guardar Modificacion");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(195, 195, 195)
                                        .addComponent(jdModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbGuardar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jdMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jdMostrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jdModificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar)
                    .addComponent(jdEliminar)
                    .addComponent(jbAgregar))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        mostrarDatos(jTextField1.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jdMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdMostrarActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_jdMostrarActionPerformed

    private void jdModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdModificarActionPerformed
        int filasSeleccionada=jtServicios.getSelectedRow();
        if(filasSeleccionada>=0){
            jtfAgregar.setText(jtServicios.getValueAt(filasSeleccionada, 0).toString());
            jtfPrecio.setText(jtServicios.getValueAt(filasSeleccionada, 1).toString());
            jtfAgregar.setEditable(false);
            jbAgregar.setVisible(false);
            jdEliminar.setVisible(false);
            jbGuardar.setVisible(true);

        }
        else {
            JOptionPane.showMessageDialog(null, "No selecciono ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jdModificarActionPerformed

    private void jtfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPrecioActionPerformed

    private void jdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdEliminarActionPerformed
        int fila =jtServicios.getSelectedRow();
        if(fila>=0){
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM servicios WHERE tipo_servicio='"+jtServicios.getValueAt(fila, 0).toString()+"'");
                pst.executeUpdate();
                mostrarDatos("");

            } catch (SQLException e) {
                System.err.println(e.toString());
            }

        }else {
            JOptionPane.showMessageDialog(null," No a seleccionado ningun  Servicio , porfavor seleciones un servicio de la tabla ");
        }
    }//GEN-LAST:event_jdEliminarActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        double precio = Double.parseDouble(jtfPrecio.getText());
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.conexion();
        try {
            // Creamos una varible tipo pepared statement que almacenara un Inert into que debera almacenar datos
            PreparedStatement pst = cn.prepareStatement("INSERT INTO servicios(tipo_servicio, precio)VALUES(?, ?)");

            // le enviamos el valor de la caja de texto a la columna 1 con SetString
            pst.setString(1, jtfAgregar.getText());
            pst.setDouble(2, precio);

            // el executeUpdate es para subir los datos a la base de datos
            int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "Servicio agrgado con exito");
                jtfAgregar.setText("");
                jtfPrecio.setText("");

            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar el servicio");
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        double precio = Double.parseDouble(jtfPrecio.getText());
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.conexion();
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE servicios SET precio = '"+ precio+"' WHERE tipo_servicio = '"+jtfAgregar.getText()+"'");

            int a = pst.executeUpdate();
            if (a > 0) {
                JOptionPane.showMessageDialog(null, "Servicio modificado con exito");
                jtfAgregar.setEditable(true);
                jtfAgregar.setText("");
                jtfPrecio.setText("");
                mostrarDatos("");
                
             jbAgregar.setVisible(true);
            jdEliminar.setVisible(true);
            jbGuardar.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }//GEN-LAST:event_jbGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jdEliminar;
    private javax.swing.JButton jdModificar;
    private javax.swing.JButton jdMostrar;
    private javax.swing.JTable jtServicios;
    private javax.swing.JTextField jtfAgregar;
    private javax.swing.JTextField jtfPrecio;
    // End of variables declaration//GEN-END:variables
}

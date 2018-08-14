/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavacar;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static lavacar.MantenimientoUsuario.modelo;

/**
 *
 * @author hanse
 */
public class MUsuario extends javax.swing.JPanel {

    boolean validarUsuario = false;
    boolean validarContraseña = false;
    boolean validarCorreo = false;
    static DefaultTableModel modelo;
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conexion();
    
    public MUsuario() {
        initComponents();
        modelo = (DefaultTableModel) jtUsuario.getModel();
        mostrarDatos("");
        jdAgregar.setVisible(true);
        jdEliminar.setVisible(true);
        jdGuardar.setVisible(false);
    }

     void mostrarDatos(String valor) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Nombre");
        modelo.addColumn("Tipo");
        modelo.addColumn("identiicacion");
        modelo.addColumn("Correo");
        jtUsuario.setModel(modelo);

        String datos[] = new String[6];
        String sql = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM usuarios";
        } else {
            sql = "SELECT * FROM usuarios WHERE usuario= '" + valor + "'";
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
            jtUsuario.setModel(modelo);
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    }
     
      public void validarCorreo() {
        String correo = jtfCorreo.getText();
        if (correo.contains("@") == true) {
            validarCorreo = true;
        }

    }

    public void validarUsuario() {
        String usuario = jtfUsuario.getText();
        if (usuario.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (usuario.length() <= 8) {
                char letra = usuario.charAt(0);
                if (Character.isUpperCase(letra)) {
                    validarUsuario = true;
                }
            }
        }
    }

    public void validarContraseña() {
        String contraseña = jtfContraseña.getText();
        if (contraseña.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error al ingresar el usuario", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            if (contraseña.length() <= 8) {
                char caracter = contraseña.charAt(0);
                if (Character.isUpperCase(caracter)) {
                    if (contraseña.contains(".") == true) {
                        validarContraseña = true;
                    }
                }
            }
        }
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtUsuario = new javax.swing.JTable();
        jdModificar = new javax.swing.JButton();
        jtfUsuario = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtfContraseña = new javax.swing.JTextField();
        jtfIdentificacion = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jtfCorreo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jdGuardar = new javax.swing.JButton();
        jdEliminar = new javax.swing.JButton();
        jdAgregar = new javax.swing.JButton();

        jTextField1.setText("Usuario");
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jButton5.setText("Mostrar Datos");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jtUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtUsuario);

        jdModificar.setText("Modificar");
        jdModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdModificarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Administrador", "Usuario" }));

        jLabel6.setText("Tipo");

        jLabel2.setText("Usuario");

        jLabel8.setText("Contraseña");

        jLabel1.setText("Identificacion");

        jLabel3.setText("Correo");

        jtfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreActionPerformed(evt);
            }
        });

        jLabel4.setText("Nombre");

        jdGuardar.setText("Guardar modficacion");
        jdGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdGuardarActionPerformed(evt);
            }
        });

        jdEliminar.setText("Eliminar");
        jdEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdEliminarActionPerformed(evt);
            }
        });

        jdAgregar.setText("Agregar");
        jdAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jdAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(257, 257, 257)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(282, 282, 282))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdGuardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfContraseña, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCorreo)
                            .addComponent(jtfIdentificacion)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jdAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(262, 262, 262)
                        .addComponent(jdEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(86, 86, 86))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jTextField1))
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(11, 11, 11)
                .addComponent(jdModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jtfIdentificacion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfCorreo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfUsuario)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfContraseña)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombre)
                            .addComponent(jLabel4))))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jdAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jdEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char teclaPresionada = evt.getKeyChar();
        if (teclaPresionada == KeyEvent.VK_ENTER) {
            jbBuscar.doClick();
        }
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        mostrarDatos(jTextField1.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jdModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdModificarActionPerformed

        int filasSeleccionada = jtUsuario.getSelectedRow();
        if (filasSeleccionada >= 0) {
            jtfContraseña.setText(jtUsuario.getValueAt(filasSeleccionada, 1).toString());
            jtfCorreo.setText(jtUsuario.getValueAt(filasSeleccionada, 5).toString());
            jtfUsuario.setText(jtUsuario.getValueAt(filasSeleccionada, 0).toString());
            jtfIdentificacion.setText(jtUsuario.getValueAt(filasSeleccionada, 4).toString());
            jtfNombre.setText(jtUsuario.getValueAt(filasSeleccionada, 2).toString());
            jdAgregar.setVisible(false);
            jdEliminar.setVisible(false);
            jdGuardar.setVisible(true);
            
        } else {
            JOptionPane.showMessageDialog(null, "No ingreso selecciono ninguna fila", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jdModificarActionPerformed

    private void jtfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreActionPerformed

    private void jdGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdGuardarActionPerformed
        ConexionBD cc = new ConexionBD();
        Connection cn = cc.conexion();
        try{
            // creamos una variable tipo prepared statement que almacenara un UPDATE que debera sobreescribir donde se hace referencia al WHERE
            // nombre de las columnas
            PreparedStatement pst = cn.prepareStatement("UPDATE usuarios SET contraseña = '"+jtfContraseña.getText()+"'"
                + ", nombre_usuario = '"+jtfNombre.getText()+"'"
                + ", tipo = '"+jComboBox1.getSelectedItem()+"'"
                + ", identificacion = '"+jtfIdentificacion.getText()+"'"
                + ", correo = '"+jtfCorreo.getText()+"'"
                + "WHERE usuario ='"+jtfUsuario.getText()+"'");

            int a=pst.executeUpdate();

            if(a>0){

                JOptionPane.showMessageDialog(null,"Usuario modificado con éxito");
                
                jtfContraseña.setText("");
                jtfCorreo.setText("");
                jtfIdentificacion.setText("");
                jtfNombre.setText("");
                jtfUsuario.setText("");
                jComboBox1.setSelectedItem("");
                jdAgregar.setVisible(true);
                jdEliminar.setVisible(true);

            }
            else{
                JOptionPane .showMessageDialog(null,"Error al modificar");
            }
        }catch(Exception e){
            System.err.println(e.toString());
        }
    }//GEN-LAST:event_jdGuardarActionPerformed

    private void jdEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdEliminarActionPerformed
        int fila =jtUsuario.getSelectedRow();
        if(fila>=0){
            try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM usuarios WHERE usuario='"+jtUsuario.getValueAt(fila, 0).toString()+"'");
                pst.executeUpdate();
                mostrarDatos("");

            } catch (SQLException e) {
                System.err.println(e.toString());
            }

        }else {
            JOptionPane.showMessageDialog(null," No seleccionado ningun  servicio , porfavor seleciones un servicio de la tabla ");
        }

    }//GEN-LAST:event_jdEliminarActionPerformed

    private void jdAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jdAgregarActionPerformed
        validarUsuario();
        validarContraseña();
        validarCorreo();
        if (validarUsuario == true && validarContraseña == true && validarCorreo == true) {
            if (validarUsuario == true && validarContraseña == true) {
                ConexionBD cc = new ConexionBD();
                Connection cn = cc.conexion();
                try {
                    // Creamos una varible tipo pepared statement que almacenara un Inert into que debera almacenar datos
                    PreparedStatement pst = cn.prepareStatement("INSERT INTO usuarios(usuario, contraseña, nombre_usuario, tipo, identificacion, Correo)VALUES(?, ?, ?, ?, ?, ?)");

                    // le enviamos el valor de la caja de texto a la columna 1 con SetString
                    pst.setString(1, jtfUsuario.getText());
                    pst.setString(2, jtfContraseña.getText());
                    pst.setString(3, jtfNombre.getText());
                    pst.setString(4, (String) jComboBox1.getSelectedItem());
                    pst.setString(5, jtfIdentificacion.getText());
                    pst.setString(6, jtfCorreo.getText());
                    // el executeUpdate es para subir los datos a la base de datos
                    int a = pst.executeUpdate();
                    if (a > 0) {
                        JOptionPane.showMessageDialog(null, "Usuario agregado con exito");
                        jtfContraseña.setText("");
                        jtfNombre.setText("");
                        jtfUsuario.setText("");
                        jtfIdentificacion.setText("");
                        jtfCorreo.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar");
                    }
                } catch (Exception e) {
                    System.err.println(e.toString());
                }
            }
        } else if (validarUsuario == false && validarContraseña == false) {
            JOptionPane.showMessageDialog(null, "Datos incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (validarContraseña == false) {
            JOptionPane.showMessageDialog(null, "Ingreso la contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (validarUsuario == false) {
            JOptionPane.showMessageDialog(null, "Ingreso el usuario incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (validarCorreo == false) {
            JOptionPane.showMessageDialog(null, "Ingreso el correo incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
        }
        validarCorreo = false;
        validarContraseña = false;
        validarUsuario = false;
    }//GEN-LAST:event_jdAgregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jdAgregar;
    private javax.swing.JButton jdEliminar;
    private javax.swing.JButton jdGuardar;
    private javax.swing.JButton jdModificar;
    private javax.swing.JTable jtUsuario;
    private javax.swing.JTextField jtfContraseña;
    private javax.swing.JTextField jtfCorreo;
    private javax.swing.JTextField jtfIdentificacion;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfUsuario;
    // End of variables declaration//GEN-END:variables
}

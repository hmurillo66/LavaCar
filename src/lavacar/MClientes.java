/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavacar;

import java.awt.event.KeyEvent;
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
public class MClientes extends javax.swing.JPanel {

     ConexionBD cc=new ConexionBD();
           // volvemos a crear una variable tipo connection que recibira el valor del metodo conexion y se alamcena en la variable cn
           Connection cn=cc.conexion();
    public MClientes() {
        initComponents();
        mostrarDatos("");
        jButton1.setVisible(false);
    }

     public void mostrarDatos(String valor) {
          
               // para darle forma o modelo a la tabla
               DefaultTableModel modelo = new DefaultTableModel();
               modelo.addColumn("Id Cliente");
               modelo.addColumn("Nombre Cliente");
               modelo.addColumn("Telefono");
               modelo.addColumn("Correo");
               
               jtClientes.setModel(modelo);
               // para poder almacenar los datos en la tabla
               String datos[] = new String [4];
               
               // variable del nombre de la tabla
               String sql = "";
               if(valor.equals("")){
                   // aca muestra todos los valores
                   sql="SELECT * FROM clientes";
               }else{
                   // aqui solo muestra el buscado con WHERE
                   // recordar si se puede hacer un swtch para poder buscar en toas las columnas
                   sql = "SELECT * FROM clientes WHERE id_cliente = '"+ valor +"'";
               }
               
                
                try {
                    
               Statement st = cn.createStatement();
               // el result set alamecena los valores de la consulta a realizar
               ResultSet rs = st.executeQuery(sql);
               
               // MOSTRAR LOS DATOS EN LA TABLA y el next saber si recorrio todas las filas
               while(rs.next()){
                    // hacer esto con un for para ser más facil
                    for (int i = 0; i < datos.length; i++) {
                       datos[i] = rs.getString(i+1);
                   }
                   modelo.addRow(datos);
               }
               
               jtClientes.setModel(modelo);
               
           } catch (SQLException ex) {
                    System.err.println(ex.toString());
           }
               
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtfNombreCliente = new javax.swing.JTextField();
        jtfIdCliente = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfCorreoCliente = new javax.swing.JTextField();
        jtfTelefonoCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        Modificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();
        jbMostrar = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jtfBuscar = new javax.swing.JTextField();

        jtfNombreCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNombreClienteActionPerformed(evt);
            }
        });

        jLabel5.setText("Teléfono de cliente:");

        jLabel6.setText("Correo de cliente:");

        jLabel3.setText("Id de cliente:");

        jLabel4.setText("Nombre de cliente:");

        jButton1.setText("Guardar modificación");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Modificar.setText("Modificar");
        Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarActionPerformed(evt);
            }
        });

        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtClientes);

        jbMostrar.setText("Mostrar todos");
        jbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jtfBuscar.setText("Id");
        jtfBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtfBuscarMouseClicked(evt);
            }
        });
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });
        jtfBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtfBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(98, 98, 98)
                            .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(28, 28, 28)
                            .addComponent(jbBuscar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbMostrar))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfIdCliente)
                                    .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfCorreoCliente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jtfTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(184, 184, 184))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addGap(180, 180, 180)))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar)
                    .addComponent(jbMostrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Modificar)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jtfTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jtfCorreoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(26, 26, 26)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtfNombreClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNombreClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNombreClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try{
            // creamos una variable tipo prepared statement que almacenara un UPDATE que debera sobreescribir donde se hace referencia al WHERE
            // nombre de las columnas
            PreparedStatement pst = cn.prepareStatement("UPDATE clientes SET nombre_cliente = '"+jtfNombreCliente.getText()+"'"
                + ", telefono_cliente = '"+jtfTelefonoCliente.getText()+"'"
                + ", correo_cliente = '"+jtfCorreoCliente.getText()+"'"
                + "WHERE id_cliente ='"+jtfIdCliente.getText()+"'");

            int a=pst.executeUpdate();

            if(a>0){

                JOptionPane.showMessageDialog(null,"Cliente modificado con éxito");

                // limpiamos cajas de texto
                jtfNombreCliente.setText("");
                jtfTelefonoCliente.setText("");
                jtfCorreoCliente.setText("");
                jtfIdCliente.setText("");

                // se vulve a pone e disposicion el text field de id cliente
                jtfIdCliente.setEditable(true);

                // actualizar los datos de la tabla
                mostrarDatos("");
                jButton1.setVisible(false);

            }
            else{
                JOptionPane.showMessageDialog(null,"Error al modificar");
            }
        }catch(Exception e){
            System.err.println(e.toString());
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarActionPerformed

        jtfIdCliente.setEditable(false);
        int fila = jtClientes.getSelectedRow();

        if (fila>=0){

            // mandar los valores de la tabla a las cajas de texto

            jtfIdCliente.setText(jtClientes.getValueAt(fila, 0).toString());
            jtfNombreCliente.setText(jtClientes.getValueAt(fila, 1).toString());
            jtfTelefonoCliente.setText(jtClientes.getValueAt(fila, 2).toString());
            jtfCorreoCliente.setText(jtClientes.getValueAt(fila, 3).toString());
            jButton1.setVisible(true);

        }
        else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ningun cliente, porfavor seleccione un cliente de la tabla.");
        }

    }//GEN-LAST:event_ModificarActionPerformed

    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed

        mostrarDatos("");

    }//GEN-LAST:event_jbMostrarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // le asignamos a la variable valor el valor de la caja de texto buscar
        mostrarDatos(jtfBuscar.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtfBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtfBuscarMouseClicked
        jtfBuscar.setText("");
    }//GEN-LAST:event_jtfBuscarMouseClicked

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed

    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jtfBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfBuscarKeyTyped

        // se asegura de capturar la tecla enter y descarta las demas
        char teclaPresionada = evt.getKeyChar();

        // si detecta la tecla enter activa el boton buscar
        if(teclaPresionada == KeyEvent.VK_ENTER){
            jbBuscar.doClick();
        }
    }//GEN-LAST:event_jtfBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Modificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField jtfBuscar;
    private javax.swing.JTextField jtfCorreoCliente;
    private javax.swing.JTextField jtfIdCliente;
    private javax.swing.JTextField jtfNombreCliente;
    private javax.swing.JTextField jtfTelefonoCliente;
    // End of variables declaration//GEN-END:variables
}

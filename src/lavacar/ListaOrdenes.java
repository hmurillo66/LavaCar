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
public class ListaOrdenes extends javax.swing.JPanel {

    ConexionBD cc=new ConexionBD();
           // volvemos a crear una variable tipo connection que recibira el valor del metodo conexion y se alamcena en la variable cn
           Connection cn=cc.conexion();
           
           public String placa, tipo, idcliente, nombre, telefono, correo, tiposervicio;
           
    public ListaOrdenes() {
        initComponents();
        // para actualizar los datos activos
             mostrarDatos("");
    }

    public void mostrarDatos(String valor) {
          
               // para darle forma o modelo a la tabla
               DefaultTableModel modelo = new DefaultTableModel();
               modelo.addColumn("Placa");
               modelo.addColumn("Vehiculo");
               modelo.addColumn("id Cliente");
               modelo.addColumn("Servicio");
               modelo.addColumn("Estado");
               modelo.addColumn("Cliente");
               modelo.addColumn("Telefono");
               modelo.addColumn("Correo");
               
               jtOrdenesDeTrabajo.setModel(modelo);
               // para poder almacenar los datos en la tabla
               String datos[] = new String [9];
               
               // variable del nombre de la tabla
               String sql = "";
               if (valor.equals("")) {
            sql = "SELECT * FROM orden_de_trabajo INNER JOIN clientes ON orden_de_trabajo.id_cliente = clientes.id_cliente";
        } else {
            sql = "SELECT * FROM orden_de_trabajo INNER JOIN clientes ON orden_de_trabajo.id_cliente = clientes.id_cliente WHERE Numero_de_placa= '" + valor + "'";
        }
               
                
                try {
                    
               Statement st = cn.createStatement();
               // el result set alamecena los valores de la consulta a realizar
               ResultSet rs = st.executeQuery(sql);
               
               // MOSTRAR LOS DATOS EN LA TABLA y el next saber si recorrio todas las filas
               while(rs.next()){
                   int j = 0;
                    // hacer esto con un for para ser más facil
                    for (int i = 0; i < datos.length; i++) {
                        
                        if(i == 5){
                            }else{
                        datos[j] = rs.getString(i+1); 
                         j = j +1;
                        }
                   }
                   modelo.addRow(datos);
               }
               
               jtOrdenesDeTrabajo.setModel(modelo);
               
           } catch (SQLException ex) {
                    System.err.println(ex.toString());
           }
               
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jtfBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbMostrar = new javax.swing.JButton();
        jbModificarLista = new javax.swing.JButton();
        jbEliminarLista = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtOrdenesDeTrabajo = new javax.swing.JTable();

        jPanel1.setPreferredSize(new java.awt.Dimension(670, 390));

        jtfBuscar.setText("Numero de placa");
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

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbMostrar.setText("Mostrar todos");
        jbMostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarActionPerformed(evt);
            }
        });

        jbModificarLista.setText("Modificar");
        jbModificarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarListaActionPerformed(evt);
            }
        });

        jbEliminarLista.setText("Eliminar");
        jbEliminarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarListaActionPerformed(evt);
            }
        });

        jtOrdenesDeTrabajo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtOrdenesDeTrabajo);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jbModificarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbEliminarLista, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(152, Short.MAX_VALUE)
                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jbMostrar)
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMostrar)
                    .addComponent(jbBuscar))
                .addGap(61, 61, 61)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbModificarLista)
                    .addComponent(jbEliminarLista))
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

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

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // le asignamos a la variable valor el valor de la caja de texto buscar
        mostrarDatos(jtfBuscar.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbMostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarActionPerformed

        mostrarDatos("");
    }//GEN-LAST:event_jbMostrarActionPerformed

    private void jbModificarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarListaActionPerformed

        // vamos a mostrar los datos de la fila selccionada
        int fila = jtOrdenesDeTrabajo.getSelectedRow();

        if (fila>=0){
            //Hacemos visible el frame paea modificar
            ModificarOrden mo = new ModificarOrden();

            // mandar los valores de la tabla a las cajas de texto
            placa= jtOrdenesDeTrabajo.getValueAt(fila, 0).toString();
            tipo= jtOrdenesDeTrabajo.getValueAt(fila, 1).toString();
            idcliente = jtOrdenesDeTrabajo.getValueAt(fila, 2).toString();
            tiposervicio = jtOrdenesDeTrabajo.getValueAt(fila, 3).toString();
            mo.setDatos(placa, tipo, idcliente, tiposervicio);
            mo.setVisible(true);
            mostrarDatos("");

        }
        else{
            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna orden de trabajo, porfavor seleccione una orden de trabajo de la tabla.");
        }
    }//GEN-LAST:event_jbModificarListaActionPerformed

    private void jbEliminarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarListaActionPerformed
        // le asignamos el valor de la fila seleccionada a la variable fila
        // para saber si hemos seleccionado algo de la tabla
        int fila = jtOrdenesDeTrabajo.getSelectedRow();

        if(fila>= 0){

            try {
                //con esto vamos a eliminar el registro seleccionado                                                                 nombre de la tabla
                PreparedStatement pst = cn.prepareStatement("DELETE FROM orden_de_trabajo WHERE Numero_de_placa ='"+jtOrdenesDeTrabajo.getValueAt(fila, 0).toString()+"'");
                // para subir a la bd
                pst.executeUpdate();
                // actualizamos los datos
                 JOptionPane.showMessageDialog(null, "Se ha eliminado con éxito");
                mostrarDatos("");

            } catch (SQLException ex) {
                System.err.println(ex.toString());
            }

        }else{

            JOptionPane.showMessageDialog(null, "No ha seleccionado ninguna orden de trabajo, porfavor seleccione una orden de trabajo de la tabla.");
        }
    }//GEN-LAST:event_jbEliminarListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminarLista;
    private javax.swing.JButton jbModificarLista;
    private javax.swing.JButton jbMostrar;
    private javax.swing.JTable jtOrdenesDeTrabajo;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables
}

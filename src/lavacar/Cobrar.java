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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author hanse
 */
public class Cobrar extends javax.swing.JPanel {

     static DefaultTableModel modelo;
    ConexionBD cc = new ConexionBD();
    Connection cn = cc.conexion();
    double precio = 0;
    public Cobrar() {
        initComponents();
        modelo = (DefaultTableModel) jTablaCobrar.getModel();
        mostrarDatos("");
        
    }

    void mostrarDatos(String valor) {
        
        DefaultTableModel modelo = new DefaultTableModel();
        
        modelo.addColumn("Placa vehiculo"); //0
        modelo.addColumn("Vehiculo"); //1
        modelo.addColumn("Cliente");//2
        modelo.addColumn("Telefono cliente"); //3
        modelo.addColumn("servicio");// 4
        modelo.addColumn("Precio");// 5
        
      
        jTablaCobrar.setModel(modelo);

        String datos[] = new String[13];
        String sql = "";
        if(valor.equals("")){
                   // aca muestra todos los valores
                   sql="SELECT * FROM orden_de_trabajo INNER JOIN clientes ON orden_de_trabajo.id_cliente = clientes.id_cliente INNER JOIN  tipo_vehiculo ON orden_de_trabajo.vehiculo = tipo_vehiculo.vehiculo INNER JOIN servicios ON orden_de_trabajo.tipo_servicio = servicios.tipo_servicio WHERE estado_orden = 'Activa'";
               }else{
                   // aqui solo muestra el buscado con WHERE
                   // recordar si se puede hacer un swtch para poder buscar en toas las columnas
                   sql = "SELECT * FROM orden_de_trabajo INNER JOIN clientes ON orden_de_trabajo.id_cliente = clientes.id_cliente INNER JOIN  tipo_vehiculo ON orden_de_trabajo.vehiculo = tipo_vehiculo.vehiculo INNER JOIN servicios ON orden_de_trabajo.tipo_servicio = servicios.tipo_servicio WHERE Numero_de_placa = '"+ valor +"'";
               }
        
        try {
           
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                 int j = 0;
                for (int i = 0; i < datos.length; i++) {
                   
                    if(i == 2 || i == 3 || i == 4 || i == 5 || i == 8 || i == 9 || i == 10 || i == 12 || i == 13){
                        
                        if(i == 12){
                          precio =  Double.parseDouble(rs.getString(11)) * Double.parseDouble(rs.getString(13));
                           
                         datos[j] = String.valueOf("¢ "+ precio); 
                        }
                            }else{
                        datos[j] = rs.getString(i+1); 
                         j = j +1;
                        }
                }
                modelo.addRow(datos);
            }
            jTablaCobrar.setModel(modelo);
        } catch (SQLException e) {
            System.err.println(e.toString());
        }
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbBuscar = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jbMostrarDatos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jbGenerarFactura = new javax.swing.JButton();
        jbBuscar1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jbMostrarDatos1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablaCobrar = new javax.swing.JTable();
        jbGenerarFactura1 = new javax.swing.JButton();

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbMostrarDatos.setText("Mostrar Datos");
        jbMostrarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarDatosActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jbGenerarFactura.setText("Generar Factura");
        jbGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarFacturaActionPerformed(evt);
            }
        });

        jbBuscar1.setText("Buscar");
        jbBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscar1ActionPerformed(evt);
            }
        });

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jbMostrarDatos1.setText("Mostrar Datos");
        jbMostrarDatos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostrarDatos1ActionPerformed(evt);
            }
        });

        jTablaCobrar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTablaCobrar);

        jbGenerarFactura1.setText("Generar Factura");
        jbGenerarFactura1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarFactura1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jbGenerarFactura1)
                .addGap(0, 292, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jbBuscar1)
                        .addGap(28, 28, 28)
                        .addComponent(jbMostrarDatos1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbBuscar1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbMostrarDatos1))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(jbGenerarFactura1)
                .addContainerGap(31, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        mostrarDatos(jTextField1.getText());
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbMostrarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarDatosActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_jbMostrarDatosActionPerformed

    private void jbGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarFacturaActionPerformed
        int fila =jTable1.getSelectedRow();

        String numero_placa = null;
        String tipo = null;
        String identificacion = null;
        String nombre=null;
        String telefono=null;
        String servicio=null;
        for (int i = fila; i >=0; i--) {

            numero_placa=jTable1.getValueAt(fila, 0).toString();
            tipo=jTable1.getValueAt(fila, 1).toString();
            identificacion=jTable1.getValueAt(fila, 2).toString();
            nombre=jTable1.getValueAt(fila, 3).toString();
            telefono=jTable1.getValueAt(fila, 4).toString();
            servicio=jTable1.getValueAt(fila, 6).toString();

        }
        String path="C:\\Users\\hanse\\Desktop\\progra2\\Lavacar-_1_\\Lavacar (1)\\Lavacar\\src\\lavacar\\Factura.jasper";
        JasperReport reporte;
        try {
            reporte =(JasperReport)JRLoader.loadObject(path);
            Map parametro = new HashMap();
            parametro.put("numero_placa", numero_placa);
            parametro.put("tipo",tipo);
            parametro.put("identificacion",identificacion);
            parametro.put("nombre",nombre);
            parametro.put("telefono",telefono);
            parametro.put("servicio",servicio);
            //agrgar los elementos
            JasperPrint jprint= JasperFillManager.fillReport(path, parametro, new JREmptyDataSource());

            //parte visualizacion
            JasperViewer viewer= new JasperViewer(jprint,false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(CobrarOrden.class.getName()).log(Level.SEVERE, null, ex);
        }

        }

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            int fila =jTable1.getSelectedRow();
            if(fila>=0){
                try {
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM orden_de_trabajo WHERE Numero_de_placa ='"+jTable1.getValueAt(fila, 0).toString()+"'");
                    pst.executeUpdate();
                    mostrarDatos("");

                } catch (SQLException e) {
                    System.err.println(e.toString());
                }

            }else {
                JOptionPane.showMessageDialog(null," No seleccionado ninguna orden , porfavor seleciones alguna orden de la tabla ");
            }
    }//GEN-LAST:event_jbGenerarFacturaActionPerformed

    private void jbBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscar1ActionPerformed
        mostrarDatos(jTextField2.getText());
    }//GEN-LAST:event_jbBuscar1ActionPerformed

    private void jbMostrarDatos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostrarDatos1ActionPerformed
        mostrarDatos("");
    }//GEN-LAST:event_jbMostrarDatos1ActionPerformed

    private void jbGenerarFactura1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarFactura1ActionPerformed
        int fila =jTablaCobrar.getSelectedRow();

        String numero_placa = null;
        String tipo = null;
        String identificacion = null;
        String nombre=null;
        String telefono=null;
        String servicio=null;
        for (int i = fila; i >=0; i--) {

            numero_placa=jTablaCobrar.getValueAt(fila, 0).toString();
            tipo=jTablaCobrar.getValueAt(fila, 1).toString();
            identificacion=jTablaCobrar.getValueAt(fila, 2).toString();
            nombre=jTablaCobrar.getValueAt(fila, 3).toString();
            telefono=jTablaCobrar.getValueAt(fila, 4).toString();
            servicio=jTablaCobrar.getValueAt(fila, 5).toString();

        }
        String path="C:\\Users\\hanse\\Desktop\\progra2\\Lavacar-_1_\\Lavacar (1)\\Lavacar\\src\\lavacar\\Factura.jasper";
        JasperReport reporte;
        try {
            reporte =(JasperReport)JRLoader.loadObject(path);
            Map parametro = new HashMap();
            parametro.put("numero_placa", numero_placa);
            parametro.put("tipo",tipo);
            parametro.put("identificacion",identificacion);
            parametro.put("nombre",nombre);
            parametro.put("telefono",telefono);
            parametro.put("servicio",servicio);
            //agrgar los elementos
            JasperPrint jprint= JasperFillManager.fillReport(path, parametro, new JREmptyDataSource());

            //parte visualizacion
            JasperViewer viewer= new JasperViewer(jprint,false);
            viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            viewer.setVisible(true);
            
            try{
            // creamos una variable tipo prepared statement que almacenara un UPDATE que debera sobreescribir donde se hace referencia al WHERE
            // nombre de las columnas
            PreparedStatement pst = cn.prepareStatement("UPDATE orden_de_trabajo SET estado_orden = 'Terminada'"
                    + "WHERE Numero_de_placa ='"+numero_placa+"'");
             

            int a=pst.executeUpdate();

            if(a>0){

                JOptionPane.showMessageDialog(null,"Orden facturada con éxito");
                
                try{
                   
            // creamos una variable tipo prepared statement que almacenara un INSERT INTO que debera alamecenar datos
            // nombre de las columnas
            PreparedStatement ps = cn.prepareStatement("INSERT INTO facturas (Numero_de_placa, vehiculo, nombre_cliente, telefono_cliente, servicio, Precio) VALUES(?, ?, ?, ?, ?, ?)");
            // nombre de la bd(nombre de la tabla) VALUES(tantas ? como columnas)
            // le enviamos el valor de la caje de texto a la columna 1 con un setString
            ps.setString(1, jTablaCobrar.getValueAt(fila, 0).toString());
            ps.setString(2, jTablaCobrar.getValueAt(fila, 1).toString());
            ps.setString(3, jTablaCobrar.getValueAt(fila, 2).toString());
            ps.setString(4, jTablaCobrar.getValueAt(fila, 3).toString());
            ps.setString(5, jTablaCobrar.getValueAt(fila, 4).toString());
            ps.setString(6, jTablaCobrar.getValueAt(fila, 5).toString());

            // el executeUpdate es para  gurdar  bd
            int aa =ps.executeUpdate();
            if(aa>0){  
                
                JOptionPane.showMessageDialog(null,"Factura ingresada en la base de datos");
                
                }
            else{
                JOptionPane.showMessageDialog(null,"Error al ingresar factura a la base de datos");
            }
        }catch(Exception e){
            System.err.println(e.toString());
        }
                
                
            }
            else{
                JOptionPane.showMessageDialog(null,"Error al facturar");
            }
        }catch(Exception e){
            System.err.println(e.toString());
        }  

        } catch (JRException ex) {
            Logger.getLogger(CobrarOrden.class.getName()).log(Level.SEVERE, null, ex);
        }

        

       
    }//GEN-LAST:event_jbGenerarFactura1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JTable jTablaCobrar;
    private static javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscar1;
    private javax.swing.JButton jbGenerarFactura;
    private javax.swing.JButton jbGenerarFactura1;
    private javax.swing.JButton jbMostrarDatos;
    private javax.swing.JButton jbMostrarDatos1;
    // End of variables declaration//GEN-END:variables
}

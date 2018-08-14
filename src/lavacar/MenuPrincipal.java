/*
 * To change this l =icense header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavacar;

import java.awt.Color;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

 
public class MenuPrincipal extends javax.swing.JFrame implements Runnable {

    String hora, minutos, segundos, ampm;
    Calendar calendario;
    Thread h1;
    int contador = 1;
    int contador2 = 1;
    int contador3 = 1;
    int contador4 = 1;
    int contador5 = 1;
    int contador6 = 1;
    int contador7 = 1;
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(this);
     
        
        h1 = new Thread(this);
        h1.start();
    }

    @Override
    public void run() {
      
        Thread ct = Thread.currentThread();
        
         while(ct == h1)
         {
             
             calcula();
              jlHora.setText(hora+":"+minutos+":"+segundos+" "+ ampm);
              
              try 
              {
                 Thread.sleep(1000);
             } 
              catch (Exception e) 
             {
                 System.out.println(e.getStackTrace());
             }
             
         }
    }

    private void calcula() 
    {
     Calendar calendario = new GregorianCalendar();
    Date fechaHoraActual = new Date();
    
    calendario.setTime(fechaHoraActual);
    ampm = calendario.get(Calendar.AM_PM) ==Calendar.AM?"AM":"PM";
    
      
    
    if(ampm.equals("PM"))
    {
        int h=calendario.get(Calendar.HOUR_OF_DAY)-12;
        hora = h>9?""+h:"0"+h;
    }
    else
    {
        hora = calendario.get(Calendar.HOUR_OF_DAY)>9?""+calendario.get(Calendar.HOUR_OF_DAY):"0"+
                calendario.get(Calendar.HOUR_OF_DAY);
    }
    
    minutos = calendario.get(Calendar.MINUTE)>9?""+calendario.get(Calendar.MINUTE):"0"+ 
            calendario.get(Calendar.MINUTE);
    
    segundos = calendario.get(Calendar.SECOND)>9?""+calendario.get(Calendar.SECOND):"0"+ 
            calendario.get(Calendar.SECOND);
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpFondo = new javax.swing.JPanel();
        jpSuperior = new javax.swing.JPanel();
        jlHora = new javax.swing.JLabel();
        jbMostraMenu = new javax.swing.JButton();
        jpMenu = new javax.swing.JPanel();
        rSBAgregarOrden = new rsbuttom.RSButtonMetro();
        rSBListaOrdenes = new rsbuttom.RSButtonMetro();
        rSBCobrarOrden = new rsbuttom.RSButtonMetro();
        rSBListaFactura = new rsbuttom.RSButtonMetro();
        rSBMantenimientoServicios = new rsbuttom.RSButtonMetro();
        rSBMantenimientoClientes = new rsbuttom.RSButtonMetro();
        rSBMantenimientoUsuarios = new rsbuttom.RSButtonMetro();
        jpOrdenDeTrabajo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("MenuPrincipal"); // NOI18N

        jpFondo.setBackground(new java.awt.Color(255, 255, 255));
        jpFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSuperior.setBackground(new java.awt.Color(0, 153, 153));

        jlHora.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jlHora.setForeground(new java.awt.Color(255, 255, 255));

        jbMostraMenu.setBackground(new java.awt.Color(0, 153, 153));
        jbMostraMenu.setForeground(new java.awt.Color(0, 153, 153));
        jbMostraMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/menu.png"))); // NOI18N
        jbMostraMenu.setBorder(null);
        jbMostraMenu.setContentAreaFilled(false);
        jbMostraMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbMostraMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMostraMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpSuperiorLayout = new javax.swing.GroupLayout(jpSuperior);
        jpSuperior.setLayout(jpSuperiorLayout);
        jpSuperiorLayout.setHorizontalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpSuperiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbMostraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(694, 694, 694)
                .addComponent(jlHora, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpSuperiorLayout.setVerticalGroup(
            jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpSuperiorLayout.createSequentialGroup()
                .addGroup(jpSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpSuperiorLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jlHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpSuperiorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbMostraMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jpFondo.add(jpSuperior, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 60));

        jpMenu.setBackground(new java.awt.Color(204, 204, 204));

        rSBAgregarOrden.setBackground(new java.awt.Color(204, 204, 204));
        rSBAgregarOrden.setText("Agregar orden de trabajo");
        rSBAgregarOrden.setColorHover(new java.awt.Color(0, 153, 153));
        rSBAgregarOrden.setColorNormal(new java.awt.Color(204, 204, 204));
        rSBAgregarOrden.setColorPressed(new java.awt.Color(204, 204, 204));
        rSBAgregarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSBAgregarOrdenActionPerformed(evt);
            }
        });

        rSBListaOrdenes.setBackground(new java.awt.Color(204, 204, 204));
        rSBListaOrdenes.setText("Lista de ordenes");
        rSBListaOrdenes.setColorHover(new java.awt.Color(0, 153, 153));
        rSBListaOrdenes.setColorNormal(new java.awt.Color(204, 204, 204));
        rSBListaOrdenes.setColorPressed(new java.awt.Color(204, 204, 204));
        rSBListaOrdenes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSBListaOrdenesActionPerformed(evt);
            }
        });

        rSBCobrarOrden.setBackground(new java.awt.Color(204, 204, 204));
        rSBCobrarOrden.setText("Cobrar orden de servicio");
        rSBCobrarOrden.setColorHover(new java.awt.Color(0, 153, 153));
        rSBCobrarOrden.setColorNormal(new java.awt.Color(204, 204, 204));
        rSBCobrarOrden.setColorPressed(new java.awt.Color(204, 204, 204));
        rSBCobrarOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSBCobrarOrdenActionPerformed(evt);
            }
        });

        rSBListaFactura.setBackground(new java.awt.Color(204, 204, 204));
        rSBListaFactura.setText("Lista de facturas");
        rSBListaFactura.setColorHover(new java.awt.Color(0, 153, 153));
        rSBListaFactura.setColorNormal(new java.awt.Color(204, 204, 204));
        rSBListaFactura.setColorPressed(new java.awt.Color(204, 204, 204));
        rSBListaFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSBListaFacturaActionPerformed(evt);
            }
        });

        rSBMantenimientoServicios.setBackground(new java.awt.Color(204, 204, 204));
        rSBMantenimientoServicios.setText("Mantenimiento de servicios");
        rSBMantenimientoServicios.setColorHover(new java.awt.Color(0, 153, 153));
        rSBMantenimientoServicios.setColorNormal(new java.awt.Color(204, 204, 204));
        rSBMantenimientoServicios.setColorPressed(new java.awt.Color(204, 204, 204));
        rSBMantenimientoServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSBMantenimientoServiciosActionPerformed(evt);
            }
        });

        rSBMantenimientoClientes.setBackground(new java.awt.Color(204, 204, 204));
        rSBMantenimientoClientes.setText("Mantenimiento de clientes");
        rSBMantenimientoClientes.setColorHover(new java.awt.Color(0, 153, 153));
        rSBMantenimientoClientes.setColorNormal(new java.awt.Color(204, 204, 204));
        rSBMantenimientoClientes.setColorPressed(new java.awt.Color(204, 204, 204));
        rSBMantenimientoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSBMantenimientoClientesActionPerformed(evt);
            }
        });

        rSBMantenimientoUsuarios.setBackground(new java.awt.Color(204, 204, 204));
        rSBMantenimientoUsuarios.setText("Mantenimiento de usuarios");
        rSBMantenimientoUsuarios.setColorHover(new java.awt.Color(0, 153, 153));
        rSBMantenimientoUsuarios.setColorNormal(new java.awt.Color(204, 204, 204));
        rSBMantenimientoUsuarios.setColorPressed(new java.awt.Color(204, 204, 204));
        rSBMantenimientoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSBMantenimientoUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpMenuLayout = new javax.swing.GroupLayout(jpMenu);
        jpMenu.setLayout(jpMenuLayout);
        jpMenuLayout.setHorizontalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSBAgregarOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSBListaOrdenes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(rSBCobrarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSBListaFactura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSBMantenimientoServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSBMantenimientoClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rSBMantenimientoUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpMenuLayout.setVerticalGroup(
            jpMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpMenuLayout.createSequentialGroup()
                .addComponent(rSBAgregarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(rSBListaOrdenes, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(rSBCobrarOrden, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(rSBListaFactura, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(rSBMantenimientoServicios, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(rSBMantenimientoClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(rSBMantenimientoUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                .addGap(4, 4, 4))
        );

        jpFondo.add(jpMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 230, 390));

        jpOrdenDeTrabajo.setLayout(new javax.swing.BoxLayout(jpOrdenDeTrabajo, javax.swing.BoxLayout.LINE_AXIS));
        jpFondo.add(jpOrdenDeTrabajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 670, 390));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpFondo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSBListaOrdenesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSBListaOrdenesActionPerformed

        if( contador2 == 1){
            this.rSBListaOrdenes.setColorNormal(new Color (0,153,153));
            rSBMantenimientoServicios.setColorNormal(new Color (204,204,204));
            rSBAgregarOrden.setColorNormal(new Color (204,204,204));
            rSBCobrarOrden.setColorNormal(new Color (204,204,204));
            rSBListaFactura.setColorNormal(new Color (204,204,204));
            rSBMantenimientoClientes.setColorNormal(new Color (204,204,204));
            rSBMantenimientoUsuarios.setColorNormal(new Color (204,204,204));
            
                contador = 1; 
                contador3 = 1;
                contador4 = 1;
                contador5 = 1;
                contador6 = 1;
                contador7 = 1;
            new CambiaPanel(jpOrdenDeTrabajo, new lavacar.ListaOrdenes());
             jpOrdenDeTrabajo.setVisible(true);
            contador2 = contador2 + 1;
           }
           else if(contador2 == 2){
              this.rSBListaOrdenes.setColorNormal(new Color (204,204,204));
              jpOrdenDeTrabajo.setVisible(false);
               contador2 = contador2 - 1;
            }
        
    }//GEN-LAST:event_rSBListaOrdenesActionPerformed
     
    private void rSBAgregarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSBAgregarOrdenActionPerformed
           
        if( contador == 1){
            rSBAgregarOrden.setColorNormal(new Color (0,153,153));
            rSBListaOrdenes.setColorNormal(new Color (204,204,204));
            rSBCobrarOrden.setColorNormal(new Color (204,204,204));
            rSBListaFactura.setColorNormal(new Color (204,204,204));
            rSBMantenimientoClientes.setColorNormal(new Color (204,204,204));
            rSBMantenimientoServicios.setColorNormal(new Color (204,204,204));
            rSBMantenimientoUsuarios.setColorNormal(new Color (204,204,204));
            
            
                contador2 = 1;
                contador3 = 1;
                contador4 = 1;
                contador5 = 1;
                contador6 = 1;
                contador7 = 1;
            new CambiaPanel(jpOrdenDeTrabajo, new lavacar.Orden());
             jpOrdenDeTrabajo.setVisible(true);
            contador = contador + 1;
           }
           else if(contador == 2){
              this.rSBAgregarOrden.setColorNormal(new Color (204,204,204));
              jpOrdenDeTrabajo.setVisible(false);
               contador = contador - 1;
            }
        
    }//GEN-LAST:event_rSBAgregarOrdenActionPerformed

    private void rSBCobrarOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSBCobrarOrdenActionPerformed
         if( contador3 == 1){
            this.rSBCobrarOrden.setColorNormal(new Color (0,153,153));
            rSBAgregarOrden.setColorNormal(new Color (204,204,204));
            rSBListaOrdenes.setColorNormal(new Color (204,204,204));
            rSBListaFactura.setColorNormal(new Color (204,204,204));
            rSBMantenimientoClientes.setColorNormal(new Color (204,204,204));
            rSBMantenimientoServicios.setColorNormal(new Color (204,204,204));
            rSBMantenimientoUsuarios.setColorNormal(new Color (204,204,204));
            
                contador = 1;    
                contador2 = 1;
                contador4 = 1;
                contador5 = 1;
                contador6 = 1;
                contador7 = 1;
            new CambiaPanel(jpOrdenDeTrabajo, new lavacar.Cobrar());
             jpOrdenDeTrabajo.setVisible(true);
            contador3 = contador3 + 1;
           }
           else if(contador3 == 2){
              this.rSBCobrarOrden.setColorNormal(new Color (204,204,204));
              jpOrdenDeTrabajo.setVisible(false);
               contador3 = contador3 - 1;
            }
    }//GEN-LAST:event_rSBCobrarOrdenActionPerformed

    private void rSBMantenimientoServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSBMantenimientoServiciosActionPerformed
       
        if( contador5 == 1){
            this.rSBMantenimientoServicios.setColorNormal(new Color (0,153,153));
            rSBAgregarOrden.setColorNormal(new Color (204,204,204));
            rSBListaOrdenes.setColorNormal(new Color (204,204,204));
            rSBCobrarOrden.setColorNormal(new Color (204,204,204));
            rSBListaFactura.setColorNormal(new Color (204,204,204));
            rSBMantenimientoClientes.setColorNormal(new Color (204,204,204));
            rSBMantenimientoUsuarios.setColorNormal(new Color (204,204,204));
            
                contador = 1;    
                contador2 = 1;
                contador3 = 1;
                contador4 = 1;
                contador6 = 1;
                contador7 = 1;
            new CambiaPanel(jpOrdenDeTrabajo, new lavacar.MServicios());
             jpOrdenDeTrabajo.setVisible(true);
            contador5 = contador5 + 1;
           }
           else if(contador5 == 2){
              this.rSBMantenimientoServicios.setColorNormal(new Color (204,204,204));
              jpOrdenDeTrabajo.setVisible(false);
               contador5 = contador5 - 1;
            }
    }//GEN-LAST:event_rSBMantenimientoServiciosActionPerformed

    private void rSBMantenimientoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSBMantenimientoClientesActionPerformed
        if( contador6 == 1){
            this.rSBMantenimientoClientes.setColorNormal(new Color (0,153,153));
            rSBMantenimientoServicios.setColorNormal(new Color (204,204,204));
            rSBAgregarOrden.setColorNormal(new Color (204,204,204));
            rSBListaOrdenes.setColorNormal(new Color (204,204,204));
            rSBCobrarOrden.setColorNormal(new Color (204,204,204));
            rSBListaFactura.setColorNormal(new Color (204,204,204));
            rSBMantenimientoUsuarios.setColorNormal(new Color (204,204,204));
            
            contador = 1;    
                contador2 = 1;
                contador3 = 1;
                contador4 = 1;
                contador5 = 1;
                contador7 = 1;
            new CambiaPanel(jpOrdenDeTrabajo, new lavacar.MClientes());
             jpOrdenDeTrabajo.setVisible(true);
            contador6 = contador6 + 1;
           }
           else if(contador6 == 2){
              this.rSBMantenimientoClientes.setColorNormal(new Color (204,204,204));
              jpOrdenDeTrabajo.setVisible(false);
               contador6 = contador6 - 1;
            }
    }//GEN-LAST:event_rSBMantenimientoClientesActionPerformed

    private void rSBMantenimientoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSBMantenimientoUsuariosActionPerformed
         if( contador7 == 1){
            this.rSBMantenimientoUsuarios.setColorNormal(new Color (0,153,153));
            rSBMantenimientoServicios.setColorNormal(new Color (204,204,204));
            rSBAgregarOrden.setColorNormal(new Color (204,204,204));
            rSBListaOrdenes.setColorNormal(new Color (204,204,204));
            rSBCobrarOrden.setColorNormal(new Color (204,204,204));
            rSBListaFactura.setColorNormal(new Color (204,204,204));
            rSBMantenimientoClientes.setColorNormal(new Color (204,204,204));
            
                contador = 1;    
                contador2 = 1;
                contador3 = 1;
                contador4 = 1;
                contador5 = 1;
                contador6 = 1;
            new CambiaPanel(jpOrdenDeTrabajo, new lavacar.MUsuario());
             jpOrdenDeTrabajo.setVisible(true);
            contador7 = contador7 + 1;
           }
           else if(contador7 == 2){
              this.rSBMantenimientoUsuarios.setColorNormal(new Color (204,204,204));
              jpOrdenDeTrabajo.setVisible(false);
               contador7 = contador7 - 1;
            }
    }//GEN-LAST:event_rSBMantenimientoUsuariosActionPerformed

    private void jbMostraMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMostraMenuActionPerformed
        // Obtenemos la poscion del panel menu
        int posicion = jpMenu.getX();

        if(posicion > -1){
            Animacion.Animacion.mover_izquierda(0, -230, 2, 2, jpMenu);

        }
        else{
            Animacion.Animacion.mover_derecha(-230, 0, 2, 2, jpMenu);
        }

    }//GEN-LAST:event_jbMostraMenuActionPerformed

    private void rSBListaFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSBListaFacturaActionPerformed

         if( contador4 == 1){
            this.rSBListaFactura.setColorNormal(new Color (0,153,153));
            rSBMantenimientoUsuarios.setColorNormal(new Color (204,204,204));
            rSBMantenimientoServicios.setColorNormal(new Color (204,204,204));
            rSBAgregarOrden.setColorNormal(new Color (204,204,204));
            rSBListaOrdenes.setColorNormal(new Color (204,204,204));
            rSBCobrarOrden.setColorNormal(new Color (204,204,204));
            rSBMantenimientoClientes.setColorNormal(new Color (204,204,204));
            
            
                 contador = 1;    
                contador2 = 1;
                contador3 = 1;
                contador5 = 1;
                contador6 = 1;
                contador7 = 1;
            new CambiaPanel(jpOrdenDeTrabajo, new lavacar.ListaFacturas());
             jpOrdenDeTrabajo.setVisible(true);
            contador4 = contador4 + 1;
           }
           else if(contador4 == 2){
              this.rSBListaOrdenes.setColorNormal(new Color (204,204,204));
              jpOrdenDeTrabajo.setVisible(false);
               contador4 = contador4 - 1;
            }
        
        
    }//GEN-LAST:event_rSBListaFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbMostraMenu;
    private javax.swing.JLabel jlHora;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JPanel jpMenu;
    private javax.swing.JPanel jpOrdenDeTrabajo;
    private javax.swing.JPanel jpSuperior;
    private rsbuttom.RSButtonMetro rSBAgregarOrden;
    private rsbuttom.RSButtonMetro rSBCobrarOrden;
    private rsbuttom.RSButtonMetro rSBListaFactura;
    private rsbuttom.RSButtonMetro rSBListaOrdenes;
    private rsbuttom.RSButtonMetro rSBMantenimientoClientes;
    private rsbuttom.RSButtonMetro rSBMantenimientoServicios;
    private rsbuttom.RSButtonMetro rSBMantenimientoUsuarios;
    // End of variables declaration//GEN-END:variables
}

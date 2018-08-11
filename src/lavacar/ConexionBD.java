/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavacar;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane; 

/**
 *
 * @author angie
 */
public class ConexionBD {
    // creamos la variable tipo conexion y la declaramos con el nombre de conectar
    Connection conectar =null;
    // metodo tipo connectio para realizar la conexion
    public Connection conexion(){
        try {
            // instancia
            Class.forName("org.gjt.mm.mysql.Driver");
            //conectar=(Connection)DriverManager.getConnection("jdbc:mysql://smmcr.net/caleb","progra2","Fidelitas");
            conectar=(Connection)DriverManager.getConnection("jdbc:mysql://localhost/sistema_lavacar","root","");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error de conexion de la base de datos");
        } catch(ClassNotFoundException ex){
        
        }
        return conectar;
    
    }
}

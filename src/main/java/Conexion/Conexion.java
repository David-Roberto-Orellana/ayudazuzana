/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author david.orellanausam
 */
public class Conexion {
    static String bd="zoologico";
    static String user="root";
    static String pass="root";
    static String url="jdbc:mysql://localhost/"+bd+"?useSSL=false";
    
    Connection con;
    
    public Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, user, pass);
            if (con!=null) {
                System.out.println("COnexion Exitosa");
            }
        } catch (Exception e) {
            System.out.println("ERROR de CONEXION");
        }
    }
    
    public Connection conectar(){
        return con;
    }
    
    public void desconectar() throws SQLException{
        con.close();
    }
}

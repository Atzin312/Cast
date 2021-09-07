/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;   

/**
 *
 * @author atzin
 */
public class conexion {

//    public static final String URL = "jdbc:mysql://localhost:3306/sitionoticias";
//    public static final String USER = "root";
//    public static final String CLAVE = "";
     Connection conn = null;
    public Connection getConexion() {
       
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sitionoticias", "root", "");
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
            System.out.println("AHUEVO QUE SI");
        } catch (Exception e) {
             System.out.println("AHUEVO QUE NO :( ");
            System.out.println("Error: " + e.getMessage());
        }
        return conn;
    }

}

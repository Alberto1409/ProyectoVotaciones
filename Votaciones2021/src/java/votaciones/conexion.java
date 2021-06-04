package votaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kinjiro
 */
public class conexion {
    //al final esta el nombre de la base de datos
    private static String url = "jdbc:mysql://localhost:3306/votaciones2021"; //conextion de base de datos de java dirver jdbc, url donde esta la base de datos
    private static String usuario = "root"; //mi usuario
    private static String contrasena = "aldina1409"; //mi contraseña para ingresar a la base de datos
    private static Connection con = null;
    
    public String getUrl(){
        return url;
    }
    public Connection conexion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        
        //processRequest(request, response);
        PrintWriter out = response.getWriter();
        
        try {
            //nueva instancia del driver
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //conexion toma los parametros
            //obtenemos una conexion
            con = DriverManager.getConnection(url,usuario,contrasena);
            
        } catch (SQLException ex) {
            Logger.getLogger(Ingresar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
    
    public static void cerrar() throws SQLException{
        if (con != null){
            con.close();
        }
    }
}

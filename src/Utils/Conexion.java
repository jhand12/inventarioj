/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.*;
/**
 *
 * @author Soporte
 */
public class Conexion {
    private static String Driver = "com.mysql.cj.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/inventario";
    private static String username = "root"; //usuario db- mysql
    private static String password = "";
    
    public static Connection conectar(){
        Connection response = null;
        
        try{
            Class.forName(Driver);
            response = DriverManager.getConnection(DB_URL,username,password);
            
        } catch(Exception e){
            System.out.print("No se puede establecer la conexion");
        }
        return response;
    }
    
    public ResultSet SQL(String query){
        ResultSet resultado = null;
        try{
           PreparedStatement st = conectar().prepareStatement(query);
           resultado = st.executeQuery();
           
        }catch(SQLException e){
          System.out.print(e.getMessage());
        }
        return resultado;
    } 
}

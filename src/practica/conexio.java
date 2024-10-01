package practica;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexio {
    
    public static void main (String[] faber ){
        String usuario = "root";
        String password = "root";
        String url = "jdbc:mysql://localhost:3306/sena_evidencia";
        
        Connection conexion;
        Statement statement;
        ResultSet rs;
        try {
            // conexion a la base de datos.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexio.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            //conexion
            conexion=DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM PRODUCTOS");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+ " " + rs.getString("nombre")+ ": "+ rs.getInt("cantidad") 
                        +"|"+ rs.getString("lote")+"|"+ rs.getString("proveedor"));      
            } while (rs.next());
           
            //insertar
            statement.executeUpdate("INSERT INTO PRODUCTOS VALUES(00011,'cereal frus lust',8,'5TP78LD','colombina')");
            System.out.println("");
            
            rs=statement.executeQuery("SELECT * FROM PRODUCTOS");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+ " " + rs.getString("nombre")+ ": "+ rs.getInt("cantidad") 
                        +"|"+ rs.getString("lote")+"|"+ rs.getString("proveedor"));      
            } while (rs.next());
            
            //actualizar
            statement.executeUpdate("UPDATE productos SET cantidad=25 WHERE id=7");
            System.out.println("");
            
            rs=statement.executeQuery("SELECT * FROM PRODUCTOS");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+ " " + rs.getString("nombre")+ ": "+ rs.getInt("cantidad") 
                        +"|"+ rs.getString("lote")+"|"+ rs.getString("proveedor"));      
            } while (rs.next());
            
            //borrado
            statement.executeUpdate("DELETE from productos WHERE id=4");
            System.out.println("");
            
            rs=statement.executeQuery("SELECT * FROM PRODUCTOS");
            rs.next();
            
            do{
                System.out.println(rs.getInt("id")+ " " + rs.getString("nombre")+ ": "+ rs.getInt("cantidad") 
                        +"|"+ rs.getString("lote")+"|"+ rs.getString("proveedor"));      
            } while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(conexio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

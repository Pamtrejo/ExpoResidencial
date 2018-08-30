package Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;



public class Conexion {
    static  Connection cn = null;
    
    public Conexion(){
    
        this.conectar();
    }
  public Connection getConexion()
{
   return cn;
}
    
    public Connection conectar(){
       
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
           cn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-UC019EG;databaseName=ProjectResidencial2","joel","321");
            System.out.println("Conexion Exitosa");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return cn;
    }
    
    
     public void cerrarcone()
    {
        try{
        cn.close();
        }catch(Exception ex){}
    }
     
     
      public boolean ejecutarsql(String strsql)
            {
                try{
                    this.conectar();
               Statement senetencia = cn.createStatement();
                senetencia.executeUpdate(strsql); //conexion.close();
                }
              catch (SQLException ex) {JOptionPane.showMessageDialog(null, ex);
               ex.printStackTrace();
              return false;
                }
                return true;
            }
     
    
}




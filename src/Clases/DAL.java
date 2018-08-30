/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author panay
 */
public class DAL {
    
    
public static ArrayList<String> executeSprocInParams(Connection con, int rolID) throws SQLException {  
  ArrayList<String> retorno = new ArrayList<String>(); 
  try(PreparedStatement pstmt = con.prepareStatement("{call dbo.getMenubyRol(?)}"); ) {  

        pstmt.setInt(1, rolID);  
        ResultSet rs = pstmt.executeQuery();  

        while (rs.next()) {  
         
           retorno.add(rs.getString("Nombre"));  
            
    } 
        
}finally{
   con.close();
         
  }
    return retorno;
}
public static int GetRolId(Connection con, String User) throws SQLException {  
  int retorno = 1; 
  try(PreparedStatement pstmt = con.prepareStatement("{call dbo.getRolIDbyUser(?)}"); ) {  

        pstmt.setString(1, User);  
        ResultSet rs = pstmt.executeQuery();  

        while (rs.next()) {  
         
           retorno=rs.getInt("IdRol");  
            
    } 
        
}finally{
   con.close();
         
  }
    return retorno;
}

public static int GetPrimeraVez(Connection con, String User) throws SQLException {  
  int retorno = 1; 
  try(PreparedStatement pstmt = con.prepareStatement("{call dbo.GetFirstTimeByUser(?)}"); ) {  

        pstmt.setString(1, User);  
        ResultSet rs = pstmt.executeQuery();  

        while (rs.next()) {  
         
           retorno=rs.getInt("PrimeraVez");  
            
    } 
        
}finally{
   con.close();
         
  }
    return retorno;
}

public int Validaracceso(Connection con, String User, String Password) throws SQLException {  
  int retorno = 0; 
  try(PreparedStatement pstmt = con.prepareStatement("{call dbo.isvalidUser(?,?)}"); ) {  

        pstmt.setString(1, User); 
        pstmt.setString(2, Password);  

        ResultSet rs = pstmt.executeQuery();  

        while (rs.next()) {  
         
           retorno=rs.getInt("resultado");  
            
    } 
        
}finally{
   con.close();
         
  }
    return retorno;
}

public int vali(Statement s,String User, String Password){
    int retorno = 0; 
     //Statement s = cn.getConexion().createStatement();
     return retorno;
}



}
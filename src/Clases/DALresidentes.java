/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author juan
 */
import Modelos.Residentes;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
public class DALresidentes extends Conexion{

    public DALresidentes() {
        super();
    }
    
    public List<Residentes> getResidentes() throws SQLException{
          List<Residentes> listarecidentes = new LinkedList<Residentes>();
    
        try{
           
             String sql = "SELECT * FROM Residentes";
                PreparedStatement cmd = cn.prepareStatement(sql);
                
        ResultSet rs = cmd.executeQuery();
       
        while(rs.next()) {
                    Residentes residentes = 
                            new Residentes(rs.getInt("IdResidente")
                                    ,rs.getString("Nombre")
                                    ,rs.getString("Descripcion")
                                    ,rs.getInt("IdMembresia")
                            ,rs.getInt("IdTipoResidente")
                           );
                                       
            
             listarecidentes.add(residentes);
        }
    }catch(Exception ex){}
    
    return listarecidentes;
}
    
     public List<Residentes> getResidentes(int id) throws SQLException{
          List<Residentes> listarecidentes = new LinkedList<Residentes>();
    
        try{
           
             String sql = "SELECT * FROM Residentes where IdResidente=?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                
       cmd.setInt(1, id);
                
        ResultSet rs = cmd.executeQuery();
       
        while(rs.next()) {
                    Residentes residentes = 
                            new Residentes(rs.getInt("IdResidente")
                                    ,rs.getString("Nombre")
                                    ,rs.getString("Descripcion")
                                    ,rs.getInt("IdMembresia")
                            ,rs.getInt("IdTipoResidente")
                           );
                                       
            
             listarecidentes.add(residentes);
        }
    }catch(Exception ex){}
    
    return listarecidentes;
}
    
    

}

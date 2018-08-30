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
import static Clases.Conexion.cn;
import Modelos.Membre;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DALmembresia extends Conexion{

    public DALmembresia() {
        super();
    }
    
     public List<Membre> getMembresia() throws SQLException{
        
        
            List<Membre> listaMiembros = new LinkedList<Membre>();
            
            try {
                
                String sql = "SELECT * FROM membresia";
                PreparedStatement cmd = cn.prepareStatement(sql);
                
        ResultSet rs = cmd.executeQuery();
       
        while(rs.next()) {
                    Membre membrecia = 
                            new Membre(rs.getInt("IdMembresia")
                                    ,rs.getString("TipoMembresia")
                                    ,rs.getDouble("Valor")
                                    ,rs.getString("Detalle")
                                     ,rs.getString("Fecha_vence")
                                    );
                                       
            
             listaMiembros.add(membrecia);
            } 
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
            
            
            return listaMiembros;
     }
     
     
     
      public List<Membre> getMembresia(int id) throws SQLException{
        
        
            List<Membre> listaMiembros = new LinkedList<Membre>();
            
            try {
                
                String sql = "SELECT * FROM membresia where IdMembresia =?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setInt(1, id);
                
        ResultSet rs = cmd.executeQuery();
       
        while(rs.next()) {
                    Membre membrecia = 
                            new Membre(rs.getInt("IdMembresia")
                                    ,rs.getString("TipoMembresia")
                                    ,rs.getDouble("Valor")
                                    ,rs.getString("Detalle")
                                     ,rs.getString("Fecha_vence")
                                    );
                                       
            
             listaMiembros.add(membrecia);
            } 
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
            
            
            return listaMiembros;
     }
     
     
     
    
}

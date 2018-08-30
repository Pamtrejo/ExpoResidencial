/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Modelos.Viviendas;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Toshiba
 */
public class DALVivienda extends Conexion{
        
        
       public DALVivienda(){
            super();    
        }     
        
        //LISTA PARA OBTENER LAS VIVIENDAS DE LA BD
        public List<Viviendas> getViviendas() throws SQLException{
        
        
            List<Viviendas> listaViviendas = new LinkedList<Viviendas>();
            
            try {
                
                String sql = "SELECT * FROM Viviendas";
                PreparedStatement cmd = cn.prepareStatement(sql);
                
        ResultSet rs = cmd.executeQuery();
       
        while(rs.next()) {
                    Viviendas vivienda = 
                            new Viviendas(rs.getInt("idVivienda")
                                    ,rs.getString("Estado")
                                    ,rs.getInt("IdResidente")
                                    ,rs.getInt("IdDueno")
                            ,rs.getString("Direccion")
                            ,rs.getDouble("Cuota")
                            ,rs.getString("Dueno")
                            ,rs.getString("Residente"));
                                       
            
             listaViviendas.add(vivienda);
            } 
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
 
        
        
    //System.out.println("Equipment ID: " + rs.getString("equipmentID"));
    
    
        return listaViviendas;
    }
        
        
        
        //LISTA PARA OBTENER UNA VIVIENDA EN ESPECIFICO
        public List<Viviendas> getViviendas(int Id) throws SQLException{
        
        
            List<Viviendas> listaViviendas = new LinkedList<Viviendas>();
            
            try {
                
                String sql = "SELECT * FROM Viviendas WHERE idVivienda = ?";
                PreparedStatement cmd = cn.prepareStatement(sql);
                cmd.setInt(1, Id);
                
        ResultSet rs = cmd.executeQuery();
       
        while(rs.next()) {
                    Viviendas vivienda = 
                            new Viviendas(rs.getInt("idVivienda")
                                    ,rs.getString("Estado")
                                    ,rs.getInt("IdResidente")
                                    ,rs.getInt("IdDueno")
                            ,rs.getString("Direccion")
                            ,rs.getDouble("Cuota")
                            ,rs.getString("Dueno")
                            ,rs.getString("Residente"));
            
             listaViviendas.add(vivienda);
            } 
       
        }
        catch (Exception e) {
        System.out.println(e.toString());
        }
 
        
        
    //System.out.println("Equipment ID: " + rs.getString("equipmentID"));
    
    
        return listaViviendas;
    }
        
        
        public void guardarvivienda(){
           /* String strsql ="insert into viviendas values(?,?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(strsql);
           */
        }

    
}

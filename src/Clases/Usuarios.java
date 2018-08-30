/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Formularios.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author panay
 */
public class Usuarios {
    private Connection cn;
    private int IdUsuario;
    private String NomUsuario;
    private int IdRol;
    private String Contrasena;
    private String PrimeraVez;

    public void setPrimeraVez(String PrimeraVez) {
        this.PrimeraVez = PrimeraVez;
    }

    public String getPrimeraVez() {
        return PrimeraVez;
    }
     


    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }
    
    
    
    public int getIdUsuario() {
        return IdUsuario;
    }

    /**
     * @param IdUsuario the IdUsuario to set
     */
    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    /**
     * @return the NomUsuario
     */
    public String getNomUsuario() {
        return NomUsuario;
    }

    /**
     * @param NomUsuario the NomUsuario to set
     */
    public void setNomUsuario(String NomUsuario) {
        this.NomUsuario = NomUsuario;
    }

    /**
     * @return the IdRol
     */
    public int getIdRol() {
        return IdRol;
    }

    /**
     * @param IdRol the IdRol to set
     */
    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    /**
     * @return the Contrasena
     */
    public String getContrasena() {
        return Contrasena;
    }

    /**
     * @param Contrasena the Contrasena to set
     */
    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }
    
  
     public Usuarios(){
        cn = new Conexion().conectar();
    }
    
    public int idRol(Object nombre){
        int id = 0;
        try{
            String sql = "SELECT IdRol FROM Roles WHERE TipoRol = '"+nombre+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("IdRol");
            }
            
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    
    
    public DefaultComboBoxModel Roles(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String sql = "SELECT TipoRol FROM Roles";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            modelo.addElement("[ Elige tu rol ]");
            while(rs.next()){
                modelo.addElement(rs.getString("TipoRol"));
                
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        return modelo;
    }
    
    
    public boolean  guardarUsuario(){
        
       boolean res = false;
        try{
//            Realizar la consulta INSERT
            String sql = "INSERT INTO Usuarios(NomUsuario,IdRol,Contrasena,PrimeraVez) "
                        + "VALUES (?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, NomUsuario);
            cmd.setInt(2, IdRol);
            cmd.setString(3, Contrasena);
            cmd.setString(4, PrimeraVez);
            
           
            
            if(!cmd.execute()){
                res = true;
            }
            cmd.close();
            
        }
        catch (Exception e){
            System.out.println(e.toString());
            e.printStackTrace();
        }
        return res;        
    }
  
}

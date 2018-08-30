/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author panay
 */
public class Residentes {
    private Connection cn;
    private int IdResidente;
    private String Nombre;
    private String Descripcion;
    private int IdMembresia;
    private int IdTipoResidente;
    
    public Connection getCn() {
        return cn;
    }
    
    
    public void setCn(Connection cn) {
        this.cn = cn;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    
    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the IdMembresia
     */
    public int getIdMembresia() {
        return IdMembresia;
    }

    /**
     * @param IdMembresia the IdMembresia to set
     */
    public void setIdMembresia(int IdMembresia) {
        this.IdMembresia = IdMembresia;
    }

    /**
     * @return the IdTipoResidente
     */
    public int getIdTipoResidente() {
        return IdTipoResidente;
    }

    /**
     * @param IdTipoResidente the IdTipoResidente to set
     */
    public void setIdTipoResidente(int IdTipoResidente) {
        this.IdTipoResidente = IdTipoResidente;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the IdResidente
     */
    public int getIdResidente() {
        return IdResidente;
    }

    /**
     * @param IdResidente the IdResidente to set
     */
    public void setIdResidente(int IdResidente) {
        this.IdResidente = IdResidente;
    }
    
    public Residentes(){
        cn = new Conexion().conectar();
    }
    
    public int idTipo(Object nombre){
        int id = 0;
        try{
            String sql = "SELECT IdTipoResidente FROM TipoResidente WHERE TipoResidente = '"+nombre+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("IdTipoResidente");
            }
            
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return id;
    }
    
     public int idMembresia(Object nombre){
        int id = 0;
        try{
            String sql = "SELECT IdMembresia FROM Membresia WHERE TipoMembresia = '"+nombre+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("IdMembresia");
            }
            
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return id;
    }
    
  public DefaultComboBoxModel LaMembresia(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String sql = "SELECT TipoMembresia FROM Membresia";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            modelo.addElement("[ Elige una membresia ]");
            while(rs.next()){
                modelo.addElement(rs.getString("TipoMembresia"));
                
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        return modelo;
    }
  
  public DefaultComboBoxModel Eltipo(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String sql = "SELECT TipoResidente FROM TipoResidente";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            modelo.addElement("[ Elige un tipo ]");
            while(rs.next()){
                modelo.addElement(rs.getString("TipoResidente"));
                
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        return modelo;
    }
  
  public void cargarResidentes(){
        try{
            //Realizar la consulta SELECT
            String sql = "SELECT IdResidente,Nombre,Descripcion,TipoMembresia,TipoResidente FROM Residentes, Membresia, TipoResidente"
                    + " WHERE Membresia.IdMembresia = Residentes.IdMembresia and TipoResidente.IdTipoResidente = Residentes.IdTipoResidente";
            Statement cmd = cn.createStatement();
            
            ResultSet rs = cmd.executeQuery(sql);
            ResultSetMetaData rsMd = rs.getMetaData();
           int numeroColumna = rsMd.getColumnCount();
           
           DefaultTableModel modelo = new DefaultTableModel();
          
           for(int x=1;x<=numeroColumna; x++){
               modelo.addColumn(rsMd.getColumnLabel(x));
           }
           
           while(rs.next()){
               Object []fila = new Object[numeroColumna];
               
               for(int i = 0; i<numeroColumna; i++){
                   fila[i] = rs.getObject(i+1);
               }
               
               modelo.addRow(fila);
           }
           cmd.close();
           
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
    }
  
  
 
  public boolean guardarResidentes(){
        
       boolean res = false;
        try{
//            Realizar la consulta INSERT
            String sql = "INSERT INTO Residentes(IdResidente,Nombre,Descripcion,IdMembresia,IdTipoResidente) "
                        + "VALUES (?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1,IdResidente) ;
            cmd.setString(2, Nombre);
            cmd.setString(3, Descripcion);
            cmd.setInt(4, IdMembresia);
            cmd.setInt(5, IdTipoResidente);
            
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
  
  public boolean modificarResidente(){
      boolean res = true;
      try{
//            Realizar la consulta INSERT
            String sql = "UPDATE Residentes SET Nombre = ?,Descripcion = ? ,IdMembresia = ? ,IdTipoResidente = ? "
                        + "WHERE IdResidente = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setString(1,Nombre) ;
            cmd.setString(2, Descripcion);
            cmd.setInt(3, IdMembresia);
            cmd.setInt(4, IdTipoResidente);
            cmd.setInt(5, IdResidente);
            
            if(!cmd.execute()){
                res = true;
            }
            cmd.close();
      
      }catch(Exception e){
          e.printStackTrace();
      }
      return res;
  }
  
  public boolean eliminarResidente(){
        boolean res = false;
        try{
            //Realizar la consulta DELETE
            String sql = "DELETE FROM Residentes WHERE IdResidente = ?";
            PreparedStatement cmd = cn.prepareStatement(sql);
            cmd.setInt(1, IdResidente);
            
            if(!cmd.execute()){
                res = true;
            }
            cmd.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        return res;
    }
    
    
}

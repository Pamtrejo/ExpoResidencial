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
import java.sql.Time;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Toshiba
 */
public class Visitas {
    private Connection cn;
    private int IdVisita;
    private String NomVisitante;
    private String DUIVisitante;
    private String Descripcion;
    private Time HoraVisita;
    private String FechaVisita;
    private int IdResidente;
    
    
    

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void setIdResidente(int NomResidente) {
        this.IdResidente = NomResidente;
    }
    public Connection getCn() {
        return cn;
    }

    public int getIdResidente() {
        return IdResidente;
    }
   
    /**
     * @return the IdVisita
     */
    public int getIdVisita() {
        return IdVisita;
    }

    /**
     * @param IdVisita the IdVisita to set
     */
    public void setIdVisita(int IdVisita) {
        this.IdVisita = IdVisita;
    }

    /**
     * @return the NomVisitante
     */
    public String getNomVisitante() {
        return NomVisitante;
    }

    /**
     * @param NomVisitante the NomVisitante to set
     */
    public void setNomVisitante(String NomVisitante) {
        this.NomVisitante = NomVisitante;
    }

    /**
     * @return the DUIVisitante
     */
    public String getDUIVisitante() {
        return DUIVisitante;
    }

    /**
     * @param DUIVisitante the DUIVisitante to set
     */
    public void setDUIVisitante(String DUIVisitante) {
        this.DUIVisitante = DUIVisitante;
    }

    /**
     * @return the Descripcion
     */
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
     * @return the HoraVisita
     */
    public Time getHoraVisita() {
        return HoraVisita;
    }

    /**
     * @param HoraVisita the HoraVisita to set
     */
    public void setHoraVisita(Time HoraVisita) {
        this.HoraVisita = HoraVisita;
    }

    /**
     * @return the FechaVisita
     */
    public String getFechaVisita() {
        return FechaVisita;
    }

    /**
     * @param FechaVisita the FechaVisita to set
     */
    public void setFechaVisita(String FechaVisita) {
        this.FechaVisita = FechaVisita;
    }

    /**
     * @return the IdUsuario
     */
    
    public Visitas(){
        cn = new Conexion().conectar();
    }
    
    public int idResidente(Object nombre){
        int id = 0;
        try{
            String sql = "SELECT IdResidente FROM Residentes WHERE Nombre = '"+nombre+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                id = rs.getInt("IdResidente");
            }
            
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        return id;
    }
    
    
    
    public DefaultComboBoxModel Residentes(){
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        try{
            String sql = "SELECT Nombre FROM Residentes";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            modelo.addElement("[ Residente ]");
            while(rs.next()){
                modelo.addElement(rs.getString("Nombre"));
                
            }
        }
        catch(Exception e){
            System.out.println(e.toString());
        }
        
        return modelo;
    }
    
    
    public boolean  guardarVisita(){
        
       boolean res = false;
        try{
//            Realizar la consulta INSERT
            String sql = "INSERT INTO Visitas(NomVisitante,DUIVisitante,Descripcion,HoraVisita,FechaVisita,IdResidente)"
                        + "VALUES (?,?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
            
            cmd.setString(1, NomVisitante);
            cmd.setString(2, DUIVisitante);
            cmd.setString(3, Descripcion);
            cmd.setTime(4, HoraVisita);
            cmd.setString(5, FechaVisita);
            cmd.setInt(6, IdResidente);
            
           
            
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
  












    
    



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
    private int NomResidente;
    
    
    

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public void setNomResidente(int NomResidente) {
        this.NomResidente = NomResidente;
    }
    public Connection getCn() {
        return cn;
    }

    public int getNomResidente() {
        return NomResidente;
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
    




public void cargarVisitas(){
        try{
            //Realizar la consulta SELECT
            String sql = "SELECT NomVisitante,DUIVisitante,Descripcion,HoraVisita,FechaVisita,NomResidente FROM Visitas";
            Statement cmd = cn.createStatement();
            
            ResultSet rs = cmd.executeQuery(sql);
            ResultSetMetaData rsMd = rs.getMetaData();
           int numeroColumna = rsMd.getColumnCount();
           
           DefaultTableModel modelo = new DefaultTableModel();
//           Principal.tblVisitas.setModel(modelo);
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

public boolean guardarVisitas(){
        
       boolean res = false;
        try{
//            Realizar la consulta INSERT
            String sql = "INSERT INTO Visitas(NomVisitante,DUIVisitante,Descripcion,HoraVisita,FechaVisita,NomResidente) "
                        + "VALUES (?,?,?,?,?)";
            PreparedStatement cmd = cn.prepareStatement(sql);
          
            cmd.setString(1, NomVisitante);
            cmd.setString(2, DUIVisitante);
            cmd.setString(3, Descripcion);
            cmd.setTime(4, HoraVisita);
            cmd.setString(4, FechaVisita);
            cmd.setInt(4, NomResidente);
            
            
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


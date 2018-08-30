/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Toshiba
 */
public class Viviendas {
    
    
    
    
    
   

    /**
     * @return the IdVivienda
     */
    public int getIdVivienda() {
        return IdVivienda;
    }

    /**
     * @param IdVivienda the IdVivienda to set
     */
    public void setIdVivienda(int IdVivienda) {
        this.IdVivienda = IdVivienda;
    }

    /**
     * @return the Estado
     */
    public String getEstado() {
        return Estado;
    }

    /**
     * @param Estado the Estado to set
     */
    public void setEstado(String Estado) {
        this.Estado = Estado;
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

    /**
     * @return the IdMembresia
     */
   
    /**
     * @param IdMembresia the IdMembresia to set
     */
   

    /**
     * @return the IdDueno
     */
    public int getIdDueno() {
        return IdDueno;
    }

    /**
     * @param IdDueno the IdDueno to set
     */
    public void setIdDueno(int IdDueno) {
        this.IdDueno = IdDueno;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public double getCuota() {
        return Cuota;
    }

    public void setCuota(double Cuota) {
        this.Cuota = Cuota;
    }

    public String getDueno() {
        return Dueno;
    }

    public void setDueno(String Dueno) {
        this.Dueno = Dueno;
    }

    public String getResidente() {
        return Residente;
    }

    public void setResidente(String Residente) {
        this.Residente = Residente;
    }
    
    

    public Viviendas(int IdVivienda, String Estado, int IdResidente, int IdDueno, String Direccion,double Cuota, String Dueno,String Residente) {
        this.IdVivienda = IdVivienda;
        this.Estado = Estado;
        this.IdResidente = IdResidente;
        this.IdDueno = IdDueno;
        this.Direccion = Direccion;
        this.Estado = Estado;
        this.Cuota = Cuota;
        this.Dueno = Dueno;
        this.Residente=Residente;
    }
    
    
    private int IdVivienda;
    private String Estado;
    private int IdResidente;
    private int IdDueno;
     private String Direccion;
     private double Cuota;
    private String Dueno;
    private String Residente;
    
}

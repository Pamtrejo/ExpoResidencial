/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author juan
 */
public class Membre {
     private int IdMembresia;
    private String tipo;
    private double valor;
    private String detalle;
    private String fechaf;

    public Membre(int IdMembresia,String tipo, double valor, String detalle, String fechaf) {
        this.tipo = tipo;
        this.valor = valor;
        this.detalle = detalle;
        this.IdMembresia = IdMembresia;
        this.fechaf=fechaf;
    }

    public int getIdMembresia() {
        return IdMembresia;
    }

    public void setIdMembresia(int IdMembresia) {
        this.IdMembresia = IdMembresia;
    }
 
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFechaf() {
        return fechaf;
    }

    public void setFechaf(String fechaf) {
        this.fechaf = fechaf;
    }
    
    
    
}

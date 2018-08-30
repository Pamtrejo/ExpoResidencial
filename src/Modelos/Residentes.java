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
public class Residentes {
    private int IdResidente;
    private String Nombre;
    private String Descripcion;
    private int IdMembresia;
     private int IdTipoResidente;

    public Residentes(int IdResidente, String Nombre, String Descripcion, int IdMembresia, int IdTipoResidente) {
        this.IdResidente = IdResidente;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.IdMembresia = IdMembresia;
        this.IdTipoResidente = IdTipoResidente;
    }

    public int getIdResidente() {
        return IdResidente;
    }

    public void setIdResidente(int IdResidente) {
        this.IdResidente = IdResidente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getIdMembresia() {
        return IdMembresia;
    }

    public void setIdMembresia(int IdMembresia) {
        this.IdMembresia = IdMembresia;
    }

    public int getIdTipoResidente() {
        return IdTipoResidente;
    }

    public void setIdTipoResidente(int IdTipoResidente) {
        this.IdTipoResidente = IdTipoResidente;
    }
     
     
}

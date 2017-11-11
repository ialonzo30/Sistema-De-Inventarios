/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Julito
 */
public class producto {
    private String Idproducto;
    private String nombre;
    private Double precio;
    private String UnidadDeMedida;
    

    public String getIdproducto() {
        return Idproducto;
    }

    public void setIdproducto(String Idproducto) {
        this.Idproducto = Idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getUnidadDeMedida() {
        return UnidadDeMedida;
    }

    public void setUnidadDeMedida(String UnidadDeMedida) {
        this.UnidadDeMedida = UnidadDeMedida;
    }

    
}

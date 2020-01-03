/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author david.orellanausam
 */
public class Guia_itinerarioBean {
    
    private int idguia_itinerario;
    private int idguia;
    private int iditinerario;
    private String nombre;
    private int codigo;

    public Guia_itinerarioBean(int idguia_itinerario) {
        this.idguia_itinerario=idguia_itinerario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    

    public int getIdguia_itinerario() {
        return idguia_itinerario;
    }

    public void setIdguia_itinerario(int idguia_itinerario) {
        this.idguia_itinerario = idguia_itinerario;
    }

    public int getIdguia() {
        return idguia;
    }

    public void setIdguia(int idguia) {
        this.idguia = idguia;
    }

    public int getIditinerario() {
        return iditinerario;
    }

    public void setIditinerario(int iditinerario) {
        this.iditinerario = iditinerario;
    }

    
            
}

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
public class ItinerarioBean {
    private int iditinerario;
    private int codigo;
    private int duracion_recorrido;
    private double longitud_itinerario;
    private int numero_visitantes;
    private int idespecie;
    private String nombre_Espanol;

    public ItinerarioBean(int iditinerario) {
        this.iditinerario=iditinerario;
    }

    public int getIditinerario() {
        return iditinerario;
    }

    public void setIditinerario(int iditinerario) {
        this.iditinerario = iditinerario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDuracion_recorrido() {
        return duracion_recorrido;
    }

    public void setDuracion_recorrido(int duracion_recorrido) {
        this.duracion_recorrido = duracion_recorrido;
    }

    public double getLongitud_itinerario() {
        return longitud_itinerario;
    }

    public void setLongitud_itinerario(double longitud_itinerario) {
        this.longitud_itinerario = longitud_itinerario;
    }


    public int getNumero_visitantes() {
        return numero_visitantes;
    }

    public void setNumero_visitantes(int numero_visitantes) {
        this.numero_visitantes = numero_visitantes;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public String getNombre_Espanol() {
        return nombre_Espanol;
    }

    public void setNombre_Espanol(String nombre_Espanol) {
        this.nombre_Espanol = nombre_Espanol;
    }

    
    
}

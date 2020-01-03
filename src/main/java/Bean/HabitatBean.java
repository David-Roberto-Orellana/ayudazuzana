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
public class HabitatBean {
    private int idhabitat;
    private String nombre;
    private String clima;
    private String veg_predominante;
    private String continente_vegetacion;

    public HabitatBean(int idhabitat) {
       this.idhabitat=idhabitat;
    }

    public int getIdhabitat() {
        return idhabitat;
    }

    public void setIdhabitat(int idhabitat) {
        this.idhabitat = idhabitat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getVeg_predominante() {
        return veg_predominante;
    }

    public void setVeg_predominante(String veg_predominante) {
        this.veg_predominante = veg_predominante;
    }

    public String getContinente_vegetacion() {
        return continente_vegetacion;
    }

    public void setContinente_vegetacion(String continente_vegetacion) {
        this.continente_vegetacion = continente_vegetacion;
    }

    
    
    
    
}

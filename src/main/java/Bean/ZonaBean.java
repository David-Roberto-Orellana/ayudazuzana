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
public class ZonaBean {
    private int idzona;
    private String nombrezona;
    private int numerozona;
    private double extenTerritorial;
    private int idespecie;
    private String nombre_Espanol;

    public ZonaBean(int idzona) {
        this.idzona=idzona;
    }

    public int getIdzona() {
        return idzona;
    }

    public void setIdzona(int idzona) {
        this.idzona = idzona;
    }

    public String getNombrezona() {
        return nombrezona;
    }

    public void setNombrezona(String nombrezona) {
        this.nombrezona = nombrezona;
    }

   

    public int getNumerozona() {
        return numerozona;
    }

    public String getNombre_Espanol() {
        return nombre_Espanol;
    }

    public void setNombre_Espanol(String nombre_Espanol) {
        this.nombre_Espanol = nombre_Espanol;
    }
    
    

    public void setNumerozona(int numerozona) {
        this.numerozona = numerozona;
    }

    public double getExtenTerritorial() {
        return extenTerritorial;
    }

    public void setExtenTerritorial(double extenTerritorial) {
        this.extenTerritorial = extenTerritorial;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

   
}

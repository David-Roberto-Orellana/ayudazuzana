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
public class Itinierario_ZonaBean {
    
    static int iditinerario_zona;
    static int idzona;
    static int iditinerario;

    public Itinierario_ZonaBean(int iditinerario_zona) {
        this.iditinerario_zona=iditinerario_zona;
    }

    public static int getIditinerario_zona() {
        return iditinerario_zona;
    }

    public static void setIditinerario_zona(int iditinerario_zona) {
        Itinierario_ZonaBean.iditinerario_zona = iditinerario_zona;
    }

    

    public static int getIdzona() {
        return idzona;
    }

    public static void setIdzona(int idzona) {
        Itinierario_ZonaBean.idzona = idzona;
    }

    public static int getIditinerario() {
        return iditinerario;
    }

    public static void setIditinerario(int iditinerario) {
        Itinierario_ZonaBean.iditinerario = iditinerario;
    }
    
    
}

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
public class Habitat_EspecieBean {
    static int idhabitat_especie;
    static int idhabitat;
    static int idcuidador;

    public Habitat_EspecieBean(int idhabitat_especie) {
        this.idhabitat_especie=idhabitat_especie;
    }

    public static int getIdhabitat_especie() {
        return idhabitat_especie;
    }

    public static void setIdhabitat_especie(int idhabitat_especie) {
        Habitat_EspecieBean.idhabitat_especie = idhabitat_especie;
    }

    
    public static int getIdhabitat() {
        return idhabitat;
    }

    public static void setIdhabitat(int idhabitat) {
        Habitat_EspecieBean.idhabitat = idhabitat;
    }

    public static int getIdcuidador() {
        return idcuidador;
    }

    public static void setIdcuidador(int idcuidador) {
        Habitat_EspecieBean.idcuidador = idcuidador;
    }
    
    
}

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
public class EspecieBean {
    
    private int idespecie;
    private String nombre_Espanol;
    private String nombre_Cientifico;
    private String descripcion;
    
    public EspecieBean(int idespecie){
        this.idespecie=idespecie;
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

    

    public String getNombre_Cientifico() {
        return nombre_Cientifico;
    }

    public void setNombre_Cientifico(String nombre_Cientifico) {
        this.nombre_Cientifico = nombre_Cientifico;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}

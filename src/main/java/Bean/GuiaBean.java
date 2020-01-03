/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.util.Date;

/**
 *
 * @author david.orellanausam
 */
public class GuiaBean {
    private int idguia;
    private String nombre;
    private String direccion;
    private Date fecha_inicio_Trabajar;

    public GuiaBean(int idguia) {
        this.idguia=idguia;
    }

    public int getIdguia() {
        return idguia;
    }

    public void setIdguia(int idguia) {
        this.idguia = idguia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_inicio_Trabajar() {
        return fecha_inicio_Trabajar;
    }

    public void setFecha_inicio_Trabajar(Date fecha_inicio_Trabajar) {
        this.fecha_inicio_Trabajar = fecha_inicio_Trabajar;
    }

   

   
    
}

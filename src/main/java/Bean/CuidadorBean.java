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
public class CuidadorBean {
    
    private int idcuidador;
    private String nombre;
    private String direccion;
    private String telefono;
    private Date fecha_ingreso;

    public CuidadorBean(int idcuidador) {
        this.idcuidador=idcuidador;
    }

    public int getIdcuidador() {
        return idcuidador;
    }

    public void setIdcuidador(int idcuidador) {
        this.idcuidador = idcuidador;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

   
    
    
}

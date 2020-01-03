/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author david.orellanausam
 */
public class Cuidador_EspecieBean {
    
    private int idcuidador_especie;
    private int idcuidador;
    private int idespecie;
    private Date fecha_asignacion;
    private LocalTime hora_asignacion;
    private String nombre_Espanol;
    private String nombre;

    public Cuidador_EspecieBean(int idcuidador_especie) {
        this.idcuidador_especie=idcuidador_especie;
    }

    public String getNombre_Espanol() {
        return nombre_Espanol;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalTime getHora_asignacion() {
        return hora_asignacion;
    }

    public void setHora_asignacion(LocalTime hora_asignacion) {
        this.hora_asignacion = hora_asignacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public void setNombre_Espanol(String nombre_Espanol) {
        this.nombre_Espanol = nombre_Espanol;
    }

    public int getIdcuidador_especie() {
        return idcuidador_especie;
    }

    public void setIdcuidador_especie(int idcuidador_especie) {
        this.idcuidador_especie = idcuidador_especie;
    }

    public int getIdcuidador() {
        return idcuidador;
    }

    public void setIdcuidador(int idcuidador) {
        this.idcuidador = idcuidador;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public Date getFecha_asignacion() {
        return fecha_asignacion;
    }

    public void setFecha_asignacion(Date fecha_asignacion) {
        this.fecha_asignacion = fecha_asignacion;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.EspecieBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author david.orellanausam
 */
public class EspecieDao {
    Conexion con=new Conexion();

    public EspecieDao(Conexion con) {
        this.con=con;
    }
    
    public boolean insertar(EspecieBean eb){
        try {
             String sql="insert into especie value(?,?,?,?)";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             ps.setInt(1, eb.getIdespecie());
             ps.setString(2, eb.getNombre_Espanol());
             ps.setString(3, eb.getNombre_Cientifico());
             ps.setString(4, eb.getDescripcion());
             ps.executeUpdate();
             return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(EspecieBean eb){
        try {
             String sql="update especie set nombre_Espanol=?,nombre_Cientifico=?, descripcion=? where idespecie=?";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             
             ps.setString(1, eb.getNombre_Espanol());
             ps.setString(2, eb.getNombre_Cientifico());
             ps.setString(3, eb.getDescripcion());
             ps.setInt(4, eb.getIdespecie());
             ps.executeUpdate();
             return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<EspecieBean>consultar(){
        try {
            String sql="call pa_especieConsulta";
             PreparedStatement ps = con.conectar().prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             
             List<EspecieBean>lista=new LinkedList<>();
             EspecieBean eb;
             while(rs.next()){
                 eb=new EspecieBean(rs.getInt("idespecie"));
                 eb.setNombre_Espanol(rs.getString("nombre_Espanol"));
                 eb.setNombre_Cientifico(rs.getString("nombre_Cientifico"));
                 eb.setDescripcion(rs.getString("descripcion"));
                 lista.add(eb);
             }
             return lista;
        } catch (Exception e) {
            return null;
        }
        
    }
    
     public List<EspecieBean>consultarById(int idespecie){
        try {
            String sql="call pa_especieById(?)";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             ps.setInt(1, idespecie);
             ResultSet rs=ps.executeQuery();
             
             List<EspecieBean>consulta=new LinkedList<>();
             EspecieBean eb;
             while(rs.next()){
                 eb=new EspecieBean(rs.getInt("idespecie"));
                 eb.setNombre_Espanol(rs.getString("nombre_Espanol"));
                 eb.setNombre_Cientifico(rs.getString("nombre_Cientifico"));
                 eb.setDescripcion(rs.getString("descripcion"));
                 consulta.add(eb);
             }
             return consulta;
        } catch (Exception e) {
            return null;
        }
        
    }
     
     public boolean eliminar(int idespecie){
        try {
             String sql="delete from especie where idespecie=?";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             ps.setInt(1, idespecie);
            
             ps.executeUpdate();
             return true;
        } catch (Exception e) {
            return false;
        }
    }
}

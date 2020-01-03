/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.ItinerarioBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author david.orellanausam
 */
public class ItinerarioDao {
    Conexion con=new Conexion();
    
    public ItinerarioDao(Conexion con){
        this.con=con;
    }
    
    public boolean insertar(ItinerarioBean ib){
        try {
            String sql="insert into itinerario values(?,?,?,?,?,?)";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, ib.getIditinerario());
            ps.setInt(2, ib.getCodigo());
            ps.setInt(3, ib.getDuracion_recorrido());
            ps.setDouble(4, ib.getLongitud_itinerario());
            ps.setInt(5, ib.getNumero_visitantes());
            ps.setInt(6, ib.getIdespecie());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(ItinerarioBean ib){
        try {
            String sql="update itinerario set codigo=?,duracion_recorrido=?, longitud_itinerario=?,numero_visitantes=?,idespecie=? where iditinerario=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, ib.getCodigo());
            ps.setInt(2, ib.getDuracion_recorrido());
            ps.setDouble(3, ib.getLongitud_itinerario());
            ps.setInt(4, ib.getNumero_visitantes());
            ps.setInt(5, ib.getIdespecie());
            ps.setInt(6, ib.getIditinerario());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<ItinerarioBean>consultar(){
        try {
            String sql="select i.*, e.nombre_Espanol from especie as e inner join itinerario as i on e.idespecie=i.idespecie";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<ItinerarioBean> lista=new LinkedList<>();
            ItinerarioBean ib;
            
            while(rs.next()){
                ib=new ItinerarioBean(rs.getInt(1));
                ib.setCodigo(rs.getInt(2));
                ib.setDuracion_recorrido(rs.getInt(3));
                ib.setLongitud_itinerario(rs.getDouble(4));
                ib.setNumero_visitantes(rs.getInt(5));
                ib.setIdespecie(rs.getInt(6));
                ib.setNombre_Espanol(rs.getString(7));
                lista.add(ib);
                
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
     public List<ItinerarioBean>consultarById(int iditinerario){
        try {
            String sql="select i.*, e.nombre_Espanol from especie as e inner join itinerario as i on e.idespecie=i.idespecie where iditinerario=?";            
            PreparedStatement ps=con.conectar().prepareStatement(sql);            
            ps.setInt(1, iditinerario);            
            ResultSet rs=ps.executeQuery();
            List<ItinerarioBean> lista=new LinkedList<>();
            ItinerarioBean ib;            
            while(rs.next()){
                ib=new ItinerarioBean(rs.getInt(1));
                ib.setCodigo(rs.getInt(2));
                ib.setDuracion_recorrido(rs.getInt(3));
                ib.setLongitud_itinerario(rs.getDouble(4));
                ib.setNumero_visitantes(rs.getInt(5));
                ib.setIdespecie(rs.getInt(6));
                ib.setNombre_Espanol(rs.getString(7));
                lista.add(ib);
                
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
     
     public boolean eliminar(int iditinerario){
         try {
             String sql="delete from itinerario where iditinerario=?";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             ps.setInt(1, iditinerario);
             ps.executeUpdate();
             return true;
         } catch (Exception e) {
             return false;
         }
     }
    
}

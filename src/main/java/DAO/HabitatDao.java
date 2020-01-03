/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.HabitatBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author david.orellanausam
 */
public class HabitatDao {
    Conexion con=new Conexion();
    

    public HabitatDao(Conexion con) {
        this.con=con;
    }
    
    public boolean insertar(HabitatBean hb){
        try {
            String sql="insert into habitat values(?,?,?,?,?)";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, hb.getIdhabitat());
            ps.setString(2, hb.getNombre());
            ps.setString(3, hb.getClima());
            ps.setString(4, hb.getVeg_predominante());
            ps.setString(5, hb.getContinente_vegetacion());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean actualizar(HabitatBean hb){
        try {
            String sql="update habitat set nombre=?,clima=?,veg_predominante=?,continente_vegetacion=? where idhabitat=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            
            ps.setString(1, hb.getNombre());
            ps.setString(2, hb.getClima());
            ps.setString(3, hb.getVeg_predominante());
            ps.setString(4, hb.getContinente_vegetacion());
            ps.setInt(5, hb.getIdhabitat());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<HabitatBean>consultar(){
        try {
            String slq="select * from habitat";
            PreparedStatement ps=con.conectar().prepareStatement(slq);
            ResultSet rs=ps.executeQuery();
            List<HabitatBean>lista=new LinkedList<>();
            HabitatBean hb;
            while (rs.next()) {                
                hb=new HabitatBean(rs.getInt(1));
                hb.setNombre(rs.getString(2));
                hb.setClima(rs.getString(3));
                hb.setVeg_predominante(rs.getString(4));
                hb.setContinente_vegetacion(rs.getString(5));
                lista.add(hb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
     public List<HabitatBean>consultarById(int idhabitat){
        try {
            String slq="select * from habitat where idhabitat=?";
            PreparedStatement ps=con.conectar().prepareStatement(slq);
            ps.setInt(1, idhabitat);
            ResultSet rs=ps.executeQuery();
            List<HabitatBean>lista=new LinkedList<>();
            HabitatBean hb;
            while (rs.next()) {                
                hb=new HabitatBean(rs.getInt(1));
                hb.setNombre(rs.getString(2));
                hb.setClima(rs.getString(3));
                hb.setVeg_predominante(rs.getString(4));
                hb.setContinente_vegetacion(rs.getString(5));
                lista.add(hb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean eliminar(int idhabitat){
        try {
            String sql="delete from habitat where idhabitat=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, idhabitat);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.ZonaBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;


public class ZonaDao {

    Conexion con = new Conexion();

    public ZonaDao(Conexion con) {
        this.con=con;

    }
    
    public boolean insertar(ZonaBean zb){
        try {
            String sql="insert into zona values(?,?,?,?,?)";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, zb.getIdzona());
            ps.setString(2, zb.getNombrezona());
            ps.setInt(3, zb.getNumerozona());
            ps.setDouble(4, zb.getExtenTerritorial());
            ps.setInt(5, zb.getIdespecie());
            ps.executeUpdate();
            return true;
                
        } catch (Exception e) {
        return false;
        }
    }
    
    public boolean actualizar(ZonaBean zb){
        try {
            String sql="update zona set nombrezona=?,numerozona=?, extenTerritorial=?, idespecie=? where idzona=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setString(1, zb.getNombrezona());
            ps.setInt(2, zb.getNumerozona());
            ps.setDouble(3, zb.getExtenTerritorial());
            ps.setInt(4, zb.getIdespecie());
            ps.setInt(5, zb.getIdzona());
            ps.executeUpdate();
            return true;
                
        } catch (Exception e) {
        return false;
        }
    }
    
    public List<ZonaBean>consultar(){
        try {
            String sql="select z.*, e.nombre_Espanol from especie as e inner join zona as z on e.idespecie=z.idespecie";
           
           PreparedStatement ps=con.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<ZonaBean>lista=new LinkedList<>();
            ZonaBean zb;
            while (rs.next()) {                
                zb=new ZonaBean(rs.getInt(1));
                zb.setNombrezona(rs.getString(2));
                zb.setNumerozona(rs.getInt(3));
                zb.setExtenTerritorial(rs.getDouble(4));
                zb.setIdespecie(rs.getInt(5));
                zb.setNombre_Espanol(rs.getString(6));
                lista.add(zb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<ZonaBean>consultarById(int idzona){
        try {
            String sql="select z.*, e.nombre_Espanol from especie as e inner join zona as z on e.idespecie=z.idespecie where idzona=?";
           
           PreparedStatement ps=con.conectar().prepareStatement(sql);
           ps.setInt(1,idzona);
            ResultSet rs=ps.executeQuery();
            List<ZonaBean>lista=new LinkedList<>();
            ZonaBean zb;
            while (rs.next()) {                
                zb=new ZonaBean(rs.getInt(1));
                zb.setNombrezona(rs.getString(2));
                zb.setNumerozona(rs.getInt(3));
                zb.setExtenTerritorial(rs.getDouble(4));
                zb.setIdespecie(rs.getInt(5));
                zb.setNombre_Espanol(rs.getString(6));
                lista.add(zb);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean eliminar(int idzona){
        try {
            String sql="delete from zona where idzona=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, idzona);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}

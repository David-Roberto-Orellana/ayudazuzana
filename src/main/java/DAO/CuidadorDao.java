/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.CuidadorBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;


public class CuidadorDao {
    Conexion con=new Conexion();
    
    public CuidadorDao(Conexion con){
        this.con=con;
    }
    
    public boolean insertar(CuidadorBean cb){
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="insert into cuidador value(?,?,?,?,?)";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, cb.getIdcuidador());
            ps.setString(2, cb.getNombre());
            ps.setString(3, cb.getDireccion());
            ps.setString(4, cb.getTelefono());
            ps.setString(5,formato.format(cb.getFecha_ingreso()));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
     public boolean actualizar(CuidadorBean cb){
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="update cuidador set nombre=?, direccion=?, telefono=?, fecha_ingreso=? where idcuidador=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setString(1, cb.getNombre());
            ps.setString(2, cb.getDireccion());
            ps.setString(3, cb.getTelefono());
            ps.setString(4,formato.format(cb.getFecha_ingreso()));
            ps.setInt(5, cb.getIdcuidador());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
     
     public List<CuidadorBean>consultar(){
         try {
             String sql="select * from cuidador";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             ResultSet rs=ps.executeQuery();
             CuidadorBean cb;
             List<CuidadorBean>lista=new LinkedList<>();
             while(rs.next()){
                 cb=new CuidadorBean(rs.getInt(1));
                 cb.setNombre(rs.getString(2));
                 cb.setDireccion(rs.getString(3));
                 cb.setTelefono(rs.getString(4));
                 cb.setFecha_ingreso(rs.getDate(5));
                 lista.add(cb);
             }
             return lista;
         } catch (SQLException e) {
             return null;
         }
     }
     
     public List<CuidadorBean>consultarById(int idcuidador){
         try {
             String sql="select * from cuidador where idcuidador=?";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             ps.setInt(1, idcuidador);
             ResultSet rs=ps.executeQuery();
             CuidadorBean cb;
             List<CuidadorBean>lista=new LinkedList<>();
             while(rs.next()){
                 cb=new CuidadorBean(rs.getInt(1));
                 cb.setNombre(rs.getString(2));
                 cb.setDireccion(rs.getString(3));
                 cb.setTelefono(rs.getString(4));
                 cb.setFecha_ingreso(rs.getDate(5));
                 lista.add(cb);
             }
             return lista;
         } catch (SQLException e) {
             return null;
         }
     }
     public boolean eliminar(int idcuidador){
         try {
             String sql="delete from cuidador where idcuidador=?";
             PreparedStatement ps=con.conectar().prepareStatement(sql);
             ps.setInt(1, idcuidador);
             ps.executeUpdate();
             return true;
         } catch (SQLException e) {
             return false;
         }
     }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.GuiaBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author david.orellanausam
 */
public class GuiaDao {
    Conexion con=new Conexion();
    
    public GuiaDao(Conexion con){
        this.con=con;
    }
    
    public boolean insertar(GuiaBean gb){
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="insert into guia values(?,?,?,?)";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, gb.getIdguia());
            ps.setString(2, gb.getNombre());
            ps.setString(3, gb.getDireccion());
            ps.setString(4, formato.format(gb.getFecha_inicio_Trabajar()));
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean actualizar(GuiaBean gb){
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="update guia set nombre=?, direccion=?, fecha_inicio_Trabajar=? where idguia=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            
            ps.setString(1, gb.getNombre());
            ps.setString(2, gb.getDireccion());
            ps.setString(3, formato.format(gb.getFecha_inicio_Trabajar()));
            ps.setInt(4, gb.getIdguia());
            ps.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            return false;
        }
    }
    
    public List<GuiaBean>consultar(){
        try {
            
            String sql="select * from guia";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<GuiaBean>lista=new LinkedList<>();
            GuiaBean gb;
            while (rs.next()) {                
                gb=new GuiaBean(rs.getInt(1));
                gb.setNombre(rs.getString(2));
                gb.setDireccion(rs.getString(3));
                gb.setFecha_inicio_Trabajar(rs.getDate(4));
                lista.add(gb);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<GuiaBean>consultarById(int idguia){
        try {
            
            String sql="select * from guia where idguia=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, idguia);
            ResultSet rs=ps.executeQuery();
            List<GuiaBean>lista=new LinkedList<>();
            GuiaBean gb;
            while (rs.next()) {                
                gb=new GuiaBean(rs.getInt(1));
                gb.setNombre(rs.getString(2));
                gb.setDireccion(rs.getString(3));
                gb.setFecha_inicio_Trabajar(rs.getDate(4));
                lista.add(gb);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean eliminar(int idguia){
        try {
            String sql="delete from guia where idguia=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1,idguia);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

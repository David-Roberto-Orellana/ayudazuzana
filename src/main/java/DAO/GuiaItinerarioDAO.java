package DAO;

import Bean.Guia_itinerarioBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class GuiaItinerarioDAO {

    Conexion con = new Conexion();

    public GuiaItinerarioDAO(Conexion con) {
        this.con = con;
    }

    public boolean insertar(Guia_itinerarioBean gib) {
        try {
            String sql = "insert into guia_itinerario value(?,?,?)";
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, gib.getIdguia_itinerario());
            ps.setInt(2, gib.getIdguia());
            ps.setInt(3, gib.getIditinerario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("El error esta aqui: " + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean actualizar(Guia_itinerarioBean gib) {
        try {
            String sql = "update guia_itinerario set idguia=?, iditinerario=? where idguia_itinerario=?";
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, gib.getIdguia());
            ps.setInt(2, gib.getIditinerario());
            ps.setInt(3, gib.getIdguia_itinerario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

  
    public List<Guia_itinerarioBean> consultar() {
        try {
            String sql = "select gi.*, g.nombre,i.codigo from guia as g inner join guia_itinerario as gi on g.idguia=gi.idguia inner join itinerario as i on i.iditinerario=gi.iditinerario";
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Guia_itinerarioBean> lista = new LinkedList<>();
            Guia_itinerarioBean gib;
            while (rs.next()) {
                gib = new Guia_itinerarioBean(rs.getInt(1));
                gib.setIdguia(rs.getInt(2));
                gib.setIditinerario(rs.getInt(3));
                gib.setNombre(rs.getString(4));
                gib.setCodigo(rs.getInt(5));
                lista.add(gib);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public List<Guia_itinerarioBean> consultarById(int idguia_itinerario) {
        try {
            String sql = "select gi.*, g.nombre,i.codigo from guia as g inner join guia_itinerario as gi on g.idguia=gi.idguia inner join itinerario as i on i.iditinerario=gi.iditinerario where idguia_itinerario=?";
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, idguia_itinerario);
            ResultSet rs = ps.executeQuery();
            List<Guia_itinerarioBean> lista = new LinkedList<>();
            Guia_itinerarioBean gib;
            while (rs.next()) {
                gib = new Guia_itinerarioBean(rs.getInt(1));
                gib.setIdguia(rs.getInt(2));
                gib.setIditinerario(3);
                gib.setNombre(rs.getString(4));
                gib.setCodigo(rs.getInt(5));
                lista.add(gib);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean eliminar(int idguia_itinerario) {
        try {
            String sql = "delete from guia_itinerario where idguia_itinerario=?";
            PreparedStatement ps = con.conectar().prepareStatement(sql);
            ps.setInt(1, idguia_itinerario);
            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            return false;
        }
    }
}

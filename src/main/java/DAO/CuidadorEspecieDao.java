
package DAO;

import Bean.Cuidador_EspecieBean;
import Conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class CuidadorEspecieDao {
    Conexion con=new Conexion();
    public CuidadorEspecieDao(Conexion con){
        this.con=con;
    }
    
    public boolean insertar(Cuidador_EspecieBean ceb){
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="insert into cuidador_especie values(?,?,?,?,?)";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, ceb.getIdcuidador_especie());
            ps.setInt(2, ceb.getIdcuidador());
            ps.setInt(3, ceb.getIdespecie());
            ps.setString(4,formato.format(ceb.getFecha_asignacion()));
            ps.setString(5, ceb.getHora_asignacion().toString());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public boolean actualizar(Cuidador_EspecieBean ceb){
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="update cuidador_especie set idcuidador=?, idespecie=? fecha_asignacion=? hora_asignacion=? where idcuidador_especie=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, ceb.getIdcuidador());
            ps.setInt(2, ceb.getIdespecie());
            ps.setString(3,formato.format(ceb.getFecha_asignacion()));
            ps.setString(4, ceb.getHora_asignacion().toString());
            ps.setInt(5, ceb.getIdcuidador_especie());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public List<Cuidador_EspecieBean> consultar(){
        try {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="select ce.*, c.nombre, e.nombre_Espanol from cuidador as c inner join cuidador_especie as ce on ce.idcuidador=c.idcuidador inner join especie as e on e.idespecie=ce.idespecie";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            List<Cuidador_EspecieBean>lista=new LinkedList<>();
            Cuidador_EspecieBean ceb;
            while (rs.next()) {                
                ceb=new Cuidador_EspecieBean(rs.getInt(1));
                ceb.setIdcuidador(rs.getInt(2));
                ceb.setIdespecie(rs.getInt(3));
                ceb.setFecha_asignacion(rs.getDate(4));
                ceb.setHora_asignacion(rs.getTime(5).toLocalTime());
                ceb.setNombre(rs.getString(6));
                ceb.setNombre_Espanol(rs.getString(7));
                lista.add(ceb);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public List<Cuidador_EspecieBean> consultarById(int idcuidador_especie){
        try {            
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
            String sql="select ce.*, c.nombre, e.nombre_Espanol from cuidador as c inner join cuidador_especie as ce on ce.idcuidador=c.idcuidador inner join especie as e on e.idespecie=ce.idespecie where idcuidador_especie=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, idcuidador_especie);
            ResultSet rs=ps.executeQuery();
            List<Cuidador_EspecieBean>lista=new LinkedList<>();
            Cuidador_EspecieBean ceb;
            while (rs.next()) {                
                ceb=new Cuidador_EspecieBean(rs.getInt(1));
                ceb.setIdcuidador(rs.getInt(2));
                ceb.setIdespecie(rs.getInt(3));
                ceb.setFecha_asignacion(rs.getDate(4));
                ceb.setHora_asignacion(rs.getTime(5).toLocalTime());
                ceb.setNombre(rs.getString(6));
                ceb.setNombre_Espanol(rs.getString(7));
                lista.add(ceb);
            }
            return lista;
        } catch (SQLException e) {
            return null;
        }
    }
    
    public boolean eliminar(int idcuidador_especie){
        try {
            String sql="delete from cuidador_especie where idcuidador_especie=?";
            PreparedStatement ps=con.conectar().prepareStatement(sql);
            ps.setInt(1, idcuidador_especie);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
}

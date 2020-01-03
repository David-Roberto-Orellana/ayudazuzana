/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.GuiaBean;
import Conexion.Conexion;
import DAO.GuiaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david.orellanausam
 */
public class GuiaServlet extends HttpServlet {

    Conexion con = new Conexion();
    GuiaDao gdao = new GuiaDao(con);
    RequestDispatcher rd;
    static boolean respuesta, msg;
    List<GuiaBean> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String accion=request.getParameter("action");
        switch(accion){
            case "insertar":insertar(request,response);break;
            case "consultar":consultar(request,response);break;
            case "consultarById":consultarById(request,response);break;
            case "actualizar":actualizar(request,response);break;
            case "eliminar":eliminar(request,response);break;
            case "indexPrincipal":indexPrincipal(request,response);break;
            case "registrar":registrar(request,response);break;
            case "indexZona":indexZona(request,response);break;
            case "update":update(request,response);break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GuiaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GuiaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // ESTOS SON REDIRECCIONAMINETOS
    
    protected void indexZona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/guia/index.jsp");
        rd.forward(request, response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/guia/actualizar.jsp");
        rd.forward(request, response);
    }
    
    // EN este metodo se llena de una vez el select
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        rd = request.getRequestDispatcher("/guia/registrar.jsp");
        rd.forward(request, response);
    }

    protected void indexPrincipal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    // _______________________________________________________________________________________________________________
    
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-mm-dd");
        GuiaBean gb=new GuiaBean(0);
        gb.setNombre(request.getParameter("nombre"));
        gb.setDireccion(request.getParameter("direccion"));
        gb.setFecha_inicio_Trabajar(formato.parse(request.getParameter("fecha_inicio_Trabajar")));
        respuesta=gdao.insertar(gb);
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/guia?action=consultar");
    }
    
   protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-mm-dd");
        int idguia=Integer.parseInt(request.getParameter("idguia"));
        GuiaBean gb=new GuiaBean(idguia);
        gb.setNombre(request.getParameter("nombre"));
        gb.setDireccion(request.getParameter("direccion"));
        gb.setFecha_inicio_Trabajar(formato.parse(request.getParameter("fecha_inicio_Trabajar")));
        respuesta=gdao.actualizar(gb);
        lista=gdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        response.sendRedirect("/zoologico/guia?action=consultar");
    }
   
  protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        lista=gdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/guia/mostrar.jsp");
        rd.forward(request, response);
    }
   
  protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int idguia=Integer.parseInt(request.getParameter("idguia"));
        lista=gdao.consultarById(idguia);
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/guia/actualizar.jsp");
        rd.forward(request, response);
    }
   protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int idguia=Integer.parseInt(request.getParameter("idguia"));
        respuesta=gdao.eliminar(idguia);
        lista=gdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/guia/mostrar.jsp");
        rd.forward(request, response);
    }
  

    
}

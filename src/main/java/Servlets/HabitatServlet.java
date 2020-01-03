/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.HabitatBean;
import Conexion.Conexion;
import DAO.HabitatDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author david.orellanausam
 */
public class HabitatServlet extends HttpServlet {

    Conexion con = new Conexion();
    HabitatDao hdao = new HabitatDao(con);
    RequestDispatcher rd;
    static boolean respuesta;
    static boolean msg;
    List<HabitatBean> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("action");
        switch(accion){
            case "insertar":insertar(request,response);break;
            case "consultar":consultar(request,response);break;
            case "consultarById":consultarById(request,response);break;
            case "actualizar":actualizar(request,response);break;
            case "eliminar":eliminar(request,response);break;
            case "indexPrincipal":indexPrincipal(request,response);break;
            case "registrar":registrar(request,response);break;
            case "indexHabitat":indexHabitat(request,response);break;
            case "update":update(request,response);break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    
    // ESTOS SON REDIRECCIONAMINETOS
    
    protected void indexHabitat(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/habitat/index.jsp");
        rd.forward(request, response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/habitat/actualizar.jsp");
        rd.forward(request, response);
    }

    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/habitat/registrar.jsp");
        rd.forward(request, response);
    }

    protected void indexPrincipal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    // _______________________________________________________________________________________________________________
    
    
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HabitatBean hb=new HabitatBean(0);
        hb.setNombre(request.getParameter("nombre"));
        hb.setClima(request.getParameter("clima"));
        hb.setVeg_predominante(request.getParameter("veg_predominante"));
        hb.setContinente_vegetacion(request.getParameter("continente_vegetacion"));
        respuesta=hdao.insertar(hb);
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/habitat?action=consultar");
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idhabitat=Integer.parseInt(request.getParameter("idhabitat"));
        HabitatBean hb=new HabitatBean(idhabitat);
        hb.setNombre(request.getParameter("nombre"));
        hb.setClima(request.getParameter("clima"));
        hb.setVeg_predominante(request.getParameter("veg_predominante"));
        hb.setContinente_vegetacion(request.getParameter("continente_vegetacion"));
        respuesta=hdao.actualizar(hb);
        lista=hdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/habitat?action=consultar");
    }
    
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista=hdao.consultar();
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/habitat/mostrar.jsp");
        rd.forward(request, response);
    }
    
    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idhabitat=Integer.parseInt(request.getParameter("idhabitat"));
        lista=hdao.consultarById(idhabitat);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/habitat/actualizar.jsp");
        rd.forward(request, response);
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idhabitat=Integer.parseInt(request.getParameter("idhabitat"));
        respuesta=hdao.eliminar(idhabitat);
        lista=hdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd=request.getRequestDispatcher("/habitat/mostrar.jsp");
        rd.forward(request, response);
    }

}

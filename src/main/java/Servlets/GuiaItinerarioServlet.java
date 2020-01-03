/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.GuiaBean;
import Bean.Guia_itinerarioBean;
import Bean.ItinerarioBean;
import Conexion.Conexion;
import DAO.GuiaDao;
import DAO.GuiaItinerarioDAO;
import DAO.ItinerarioDao;
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
public class GuiaItinerarioServlet extends HttpServlet {
    
    Conexion con=new Conexion();
    GuiaItinerarioDAO gidao=new GuiaItinerarioDAO(con);
    RequestDispatcher rd;
    List<Guia_itinerarioBean> lista;
    static boolean respuesta,msg;

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
            case "guiaItinerario":guiaItinerario(request,response);break;
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
    
    protected void guiaItinerario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/guiaItinerario/index.jsp");
        rd.forward(request, response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/guiaItinerario/actualizar.jsp");
        rd.forward(request, response);
    }
    
    // EN este metodo se llena de una vez el select
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GuiaDao guiadao=new GuiaDao(con);
        ItinerarioDao idao=new ItinerarioDao(con);
        
        List<GuiaBean>guias=guiadao.consultar();
        List<ItinerarioBean>itinerarios=idao.consultar();
        
        request.setAttribute("guias", guias);
        request.setAttribute("itinerarios", itinerarios);
        
        rd = request.getRequestDispatcher("/guiaItinerario/registrar.jsp");
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
        Guia_itinerarioBean gib= new Guia_itinerarioBean(0);
        gib.setIdguia(Integer.parseInt(request.getParameter("idguia")));
        gib.setIditinerario(Integer.parseInt(request.getParameter("iditinerario")));
        respuesta=gidao.insertar(gib);
        msg=respuesta?true:false;
        lista=gidao.consultar();
        response.sendRedirect("/zoologico/guiaItinerario?action=consultar");
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idguiaItinerario=Integer.parseInt(request.getParameter("idguia_itinerario"));
        Guia_itinerarioBean gib= new Guia_itinerarioBean(idguiaItinerario);
        gib.setIdguia(Integer.parseInt(request.getParameter("idguia")));
        gib.setIditinerario(Integer.parseInt(request.getParameter("iditinerario")));
        respuesta=gidao.actualizar(gib);
        msg=respuesta?true:false;
        lista=gidao.consultar();
        response.sendRedirect("/zoologico/guiaItinerario?action=consultar");
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista=gidao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/guiaItinerario/mostrar.jsp");
        rd.forward(request, response);
    }
    
    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idguiaItinerario=Integer.parseInt(request.getParameter("idguia_itinerario"));
        lista=gidao.consultarById(idguiaItinerario);
         GuiaDao guiadao=new GuiaDao(con);
        ItinerarioDao idao=new ItinerarioDao(con);
        
        List<GuiaBean>guias=guiadao.consultar();
        List<ItinerarioBean>itinerarios=idao.consultar();
        
        
        msg=respuesta?true:false;
        request.setAttribute("lista", lista);
        request.setAttribute("guias", guias);
        request.setAttribute("itinerarios", itinerarios);
        rd=request.getRequestDispatcher("/guiaItinerario/actualizar.jsp");
        rd.forward(request, response);
    }
    
     protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idguiaItinerario=Integer.parseInt(request.getParameter("idguia_itinerario"));
        respuesta=gidao.eliminar(idguiaItinerario);
        msg=respuesta?true:false;
        lista=gidao.consultar();
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/guiaItinerario/mostrar.jsp");
        rd.forward(request, response);
    }
    
    

}

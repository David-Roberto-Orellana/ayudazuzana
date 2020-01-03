/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.EspecieBean;
import Bean.ZonaBean;
import Conexion.Conexion;
import DAO.EspecieDao;
import DAO.ZonaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
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
public class ZonaServlet extends HttpServlet {

    Conexion con= new Conexion();
    ZonaDao zdao=new ZonaDao(con);
    RequestDispatcher rd;
    List<ZonaBean>lista;
    static boolean respuesta,msg;
    EspecieDao edao=new EspecieDao(con);
    
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
            case "indexZona":indexZona(request,response);break;
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
    
    protected void indexZona(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/zona/index.jsp");
        rd.forward(request, response);
    }
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/zona/actualizar.jsp");
        rd.forward(request, response);
    }
    
    // EN este metodo se llena de una vez el select
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EspecieBean>listaEspecie=edao.consultar();
        request.setAttribute("listaEspecie", listaEspecie);
        rd = request.getRequestDispatcher("/zona/registrar.jsp");
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
        ZonaBean zb=new ZonaBean(0);
        zb.setNombrezona(request.getParameter("nombrezona"));
        zb.setNumerozona(Integer.parseInt(request.getParameter("numerozona")));
        zb.setExtenTerritorial(Double.parseDouble(request.getParameter("extenTerritorial")));
        zb.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
        respuesta=zdao.insertar(zb);
        msg=respuesta?true:false;
        lista=zdao.consultar();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/zona?action=consultar");
        
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idzona=Integer.parseInt(request.getParameter("idzona"));
        ZonaBean zb=new ZonaBean(idzona);
        
        zb.setNombrezona(request.getParameter("nombrezona"));
        zb.setNumerozona(Integer.parseInt(request.getParameter("numerozona")));
        zb.setExtenTerritorial(Double.parseDouble(request.getParameter("extenTerritorial")));
        zb.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
        respuesta=zdao.actualizar(zb);
        msg=respuesta?true:false;
        lista=zdao.consultar();
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/zona?action=consultar");
        
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista=zdao.consultar();
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/zona/mostrar.jsp");
        rd.forward(request, response);
    }
    
     protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int idzona=Integer.parseInt(request.getParameter("idzona"));
         List<EspecieBean>listaEspecie=edao.consultar();
        request.setAttribute("listaEspecie", listaEspecie);
        lista=zdao.consultarById(idzona);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/zona/actualizar.jsp");
        rd.forward(request, response);
    }
     
      protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int idzona=Integer.parseInt(request.getParameter("idzona"));
        respuesta=zdao.eliminar(idzona);
        lista=zdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/zona/mostrar.jsp");
        rd.forward(request, response);
    }
    


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.EspecieBean;
import Bean.ItinerarioBean;
import Conexion.Conexion;
import DAO.EspecieDao;
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
public class ItinerarioServlet extends HttpServlet {

    Conexion con = new Conexion();

    ItinerarioDao idao = new ItinerarioDao(con);
    EspecieDao edao = new EspecieDao(con);
    RequestDispatcher rd;
    static boolean msg, respuesta;
    List<ItinerarioBean> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("action");
        switch (accion) {
            case "insertar":
                insertar(request, response);
                break;
            case "consultar":
                consultar(request, response);
                break;
            case "consultarById":
                consultarById(request, response);
                break;
            case "asignarById":
                asignarById(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            case "indexPrincipal":
                indexPrincipal(request, response);
                break;
            case "registrar":
                registrar(request, response);
                break;
            case "indexItinerario":
                indexItinerario(request, response);
                break;
            case "update":
                update(request, response);
                break;
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
    protected void indexItinerario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/itinerario/index.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/itinerario/actualizar.jsp");
        rd.forward(request, response);
    }

    // EN este metodo se llena de una vez el select
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EspecieBean> listaEspecie = edao.consultar();
        request.setAttribute("listaEspecie", listaEspecie);
        rd = request.getRequestDispatcher("/itinerario/registrar.jsp");
        rd.forward(request, response);
    }

    protected void indexPrincipal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

// ____________________________________________________________________________________________________
    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ItinerarioBean ib = new ItinerarioBean(0);
        ib.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        ib.setDuracion_recorrido(Integer.parseInt(request.getParameter("duracion_recorrido")));
        ib.setLongitud_itinerario(Double.parseDouble(request.getParameter("longitud_itinerario")));
        ib.setNumero_visitantes(Integer.parseInt(request.getParameter("numero_visitantes")));
        ib.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
        respuesta = idao.insertar(ib);
        msg = respuesta ? true : false;
        lista = idao.consultar();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        response.sendRedirect("/zoologico/itinerario?action=consultar");
    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int iditinerario = Integer.parseInt(request.getParameter("iditinerario"));
        ItinerarioBean ib = new ItinerarioBean(iditinerario);
        ib.setCodigo(Integer.parseInt(request.getParameter("codigo")));
        ib.setDuracion_recorrido(Integer.parseInt(request.getParameter("duracion_recorrido")));
        ib.setLongitud_itinerario(Double.parseDouble(request.getParameter("longitud_itinerario")));
        ib.setNumero_visitantes(Integer.parseInt(request.getParameter("numero_visitantes")));
        ib.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
        respuesta = idao.actualizar(ib);
        msg = respuesta ? true : false;
        lista = idao.consultar();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        response.sendRedirect("/zoologico/itinerario?action=consultar");
    }

    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = idao.consultar();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/itinerario/mostrar.jsp");
        rd.forward(request, response);
    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int iditinerario = Integer.parseInt(request.getParameter("iditinerario"));
        List<EspecieBean>listaEspecie=edao.consultar();
        request.setAttribute("listaEspecie", listaEspecie);
        lista = idao.consultarById(iditinerario);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/itinerario/actualizar.jsp");
        rd.forward(request, response);
    }
    protected void asignarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<EspecieBean> listaEspecie = edao.consultar();
        int iditinerario = Integer.parseInt(request.getParameter("iditinerario"));
        lista = idao.consultarById(iditinerario);
        request.setAttribute("lista", lista);
        request.setAttribute("listaEspecie", listaEspecie);
        rd = request.getRequestDispatcher("/itinerario/actualizar.jsp");
        rd.forward(request, response);
    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        int iditinerario = Integer.parseInt(request.getParameter("iditinerario"));
        respuesta = idao.eliminar(iditinerario);
        lista=idao.consultar();
        request.setAttribute("lista", lista);
        
        rd = request.getRequestDispatcher("/itinerario/mostrar.jsp");
        rd.forward(request, response);
    }
}

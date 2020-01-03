/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.CuidadorBean;
import Conexion.Conexion;
import DAO.CuidadorDao;
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
public class CuidadorServlet extends HttpServlet {

    Conexion con = new Conexion();
    CuidadorDao cdao = new CuidadorDao(con);
    RequestDispatcher rd;
    static boolean respuesta, msg;
    List<CuidadorBean> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
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
            case "indexCuidador":
                indexCuidador(request, response);
                break;
            case "update":
                update(request, response);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CuidadorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CuidadorServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // ESTOS SON REDIRECCIONAMINETOS
    protected void indexCuidador(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/cuidador/index.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/cuidador/actualizar.jsp");
        rd.forward(request, response);
    }

    // EN este metodo se llena de una vez el select
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        rd = request.getRequestDispatcher("/cuidador/registrar.jsp");
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
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
        CuidadorBean cb=new CuidadorBean(0);
        cb.setNombre(request.getParameter("nombre"));
        cb.setDireccion(request.getParameter("direccion"));
        cb.setTelefono(request.getParameter("telefono"));
        cb.setFecha_ingreso(formato.parse(request.getParameter("fecha_ingreso")));
        respuesta=cdao.insertar(cb);
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/cuidador?action=consultar");

    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-mm-dd");
        int idcuidador=Integer.parseInt(request.getParameter("idcuidador"));
        CuidadorBean cb=new CuidadorBean(idcuidador);
        cb.setNombre(request.getParameter("nombre"));
        cb.setDireccion(request.getParameter("direccion"));
        cb.setTelefono(request.getParameter("telefono"));
        cb.setFecha_ingreso(formato.parse(request.getParameter("fecha_ingreso")));
        respuesta=cdao.actualizar(cb);
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/cuidador?action=consultar");

    }
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        lista=cdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/cuidador/mostrar.jsp");
        rd.forward(request, response);

    }
    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int idcuidador=Integer.parseInt(request.getParameter("idcuidador"));
        lista=cdao.consultarById(idcuidador);
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/cuidador/actualizar.jsp");
        rd.forward(request, response);

    }
    
    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int idcuidador=Integer.parseInt(request.getParameter("idcuidador"));
        respuesta=cdao.eliminar(idcuidador);
        lista=cdao.consultar();
        msg=respuesta?true:false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/cuidador/mostrar.jsp");
        rd.forward(request, response);

    }

}

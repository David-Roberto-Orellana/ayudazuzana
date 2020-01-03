/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.EspecieBean;
import Conexion.Conexion;
import DAO.EspecieDao;
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
public class EspecieServlet extends HttpServlet {

    Conexion con = new Conexion();
    EspecieDao edao = new EspecieDao(con);
    RequestDispatcher rd;
    static boolean respuesta;
    static boolean msg;
    List<EspecieBean> lista;

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
            case "eliminar":
                eliminar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "indexEspecie":
                indexEspecie(request, response);
                break;
            case "indexPrincipal":
                indexPrincipal(request, response);
                break;
            case "registrar":
                registrar(request, response);
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

    protected void indexEspecie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/especie/index.jsp");
        rd.forward(request, response);
    }

    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("/zoologico/especie?action=consultar");
    }
   

    protected void indexPrincipal(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

    protected void insertar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EspecieBean eb = new EspecieBean(0);
        eb.setNombre_Espanol(request.getParameter("nombre_Espanol"));
        eb.setNombre_Cientifico(request.getParameter("nombre_Cientifico"));
        eb.setDescripcion(request.getParameter("descripcion"));
        respuesta = edao.insertar(eb);
        msg = respuesta ? true : false;
        request.setAttribute("msg", msg);
        response.sendRedirect("/zoologico/especie?action=consultar");

    }

    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idespecie = Integer.parseInt(request.getParameter("idespecie"));
        EspecieBean eb = new EspecieBean(idespecie);
        eb.setNombre_Espanol(request.getParameter("nombre_Espanol"));
        eb.setNombre_Cientifico(request.getParameter("nombre_Cientifico"));
        eb.setDescripcion(request.getParameter("descripcion"));
        respuesta = edao.actualizar(eb);
        lista = edao.consultar();
        msg = respuesta ? true : false;
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);
        response.sendRedirect("/zoologico/especie?action=consultar");

    }

    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = edao.consultar();
        // System.out.println("lista: "+lista);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/especie/mostrar.jsp");
        rd.forward(request, response);

    }

    protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idespecie = Integer.parseInt(request.getParameter("idespecie"));
        lista = edao.consultarById(idespecie);
        request.setAttribute("lista", lista);
        rd=request.getRequestDispatcher("/especie/actualizar.jsp");
        rd.forward(request, response);

    }

    protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idespecie = Integer.parseInt(request.getParameter("idespecie"));
        respuesta = edao.eliminar(idespecie);
        lista = edao.consultar();
        msg = respuesta ? true : false;
        request.setAttribute("lista", lista);
        request.setAttribute("msg", msg);
        rd = request.getRequestDispatcher("/especie/mostrar.jsp");
        rd.forward(request, response);

    }

}

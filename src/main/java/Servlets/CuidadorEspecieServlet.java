/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Bean.CuidadorBean;
import Bean.Cuidador_EspecieBean;
import Bean.EspecieBean;
import Conexion.Conexion;
import DAO.CuidadorDao;
import DAO.CuidadorEspecieDao;
import DAO.EspecieDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CuidadorEspecieServlet extends HttpServlet {

    Conexion con = new Conexion();
    CuidadorEspecieDao cedao = new CuidadorEspecieDao(con);
    RequestDispatcher rd;
    CuidadorDao cdao = new CuidadorDao(con);
    EspecieDao edao = new EspecieDao(con);
    static boolean respuesta, msg;
    List<Cuidador_EspecieBean> lista;

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
            case "cuidadorEspecie":
                cuidadorEspecie(request, response);
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
            Logger.getLogger(CuidadorEspecieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CuidadorEspecieServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// ESTOS SON REDIRECCIONAMINETOS
    protected void cuidadorEspecie(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        rd = request.getRequestDispatcher("/cuidadorEspecie/index.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idcuidador_especie=Integer.parseInt(request.getParameter("idcuidador_especie"));
        lista=cedao.consultarById(idcuidador_especie);
        List<CuidadorBean>cuidadores=cdao.consultar();
        List<EspecieBean>especies=edao.consultar();
               
        request.setAttribute("lista", lista);
        request.setAttribute("cuidadores", cuidadores);
        request.setAttribute("especies", especies);
        rd = request.getRequestDispatcher("/cuidadorEspecie/actualizar.jsp");
        rd.forward(request, response);
    }

    // EN este metodo se llena de una vez el select
    protected void registrar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<CuidadorBean> cuidadores = cdao.consultar();
        List<EspecieBean> especies = edao.consultar();

        request.setAttribute("cuidadores", cuidadores);
        request.setAttribute("especies", especies);

        rd = request.getRequestDispatcher("/cuidadorEspecie/registrar.jsp");
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
       Cuidador_EspecieBean ceb=new Cuidador_EspecieBean(0);
       ceb.setIdcuidador(Integer.parseInt(request.getParameter("idcuidador")));
       ceb.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
       ceb.setFecha_asignacion(formato.parse(request.getParameter("fecha_asignacion")));
       ceb.setHora_asignacion(LocalTime.parse(request.getParameter("hora_asignacion")));
       respuesta=cedao.insertar(ceb);
       msg=respuesta?true:false;
       lista=cedao.consultar();
       request.setAttribute("lista", lista);
       response.sendRedirect("/zoologico/cuidadorEspecie?action=consultar");
    }
    
    protected void actualizar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        int idcuidador_especie=Integer.parseInt(request.getParameter("idcuidador_especie"));
        SimpleDateFormat formato= new SimpleDateFormat("yyyy-mm-dd");
       Cuidador_EspecieBean ceb=new Cuidador_EspecieBean(idcuidador_especie);
       ceb.setIdcuidador(Integer.parseInt(request.getParameter("idcuidador")));
       ceb.setIdespecie(Integer.parseInt(request.getParameter("idespecie")));
       ceb.setFecha_asignacion(formato.parse(request.getParameter("fecha_asignacion")));
       ceb.setHora_asignacion(LocalTime.parse(request.getParameter("hora_asignacion")));
       respuesta=cedao.actualizar(ceb);
       msg=respuesta?true:false;
       lista=cedao.consultar();
       request.setAttribute("lista", lista);
       response.sendRedirect("/zoologico/cuidadorEspecie?action=consultar");
    }
    
    protected void consultar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista=cedao.consultar();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/cuidadorEspecie/mostrar.jsp");
        rd.forward(request, response);
    }
    
     protected void consultarById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int idcuidador_especie=Integer.parseInt(request.getParameter("idcuidador_especie"));
        lista=cedao.consultarById(idcuidador_especie);
        List<CuidadorBean>cuidadores=cdao.consultar();
        List<EspecieBean>especies=edao.consultar();
               
        request.setAttribute("lista", lista);
        request.setAttribute("cuidadores", cuidadores);
        request.setAttribute("especies", especies);
        rd = request.getRequestDispatcher("/cuidadorEspecie/actualizar.jsp");
        rd.forward(request, response);
    }
     
     protected void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int idcuidador_especie=Integer.parseInt(request.getParameter("idcuidador_especie"));
        respuesta=cedao.eliminar(idcuidador_especie);
        msg=respuesta?true:false;
        lista=cedao.consultar();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/cuidadorEspecie/mostrar.jsp");
        rd.forward(request, response);
    }
}

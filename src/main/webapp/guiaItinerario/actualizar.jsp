<%-- 
    Document   : index
    Created on : 11-11-2019, 09:38:36 AM
    Author     : david.orellanausam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="bootstrap/js/jquery.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <link href="resource/materialize/css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="resource/CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <%@ include file="/resource/head.jsp" %>
        <title>update-Asignaciones</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
         <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
            
            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/guiaItinerario?action=consultar">Mostrar Asignaciones</a>
                </div>
            </div><br>
            <div class="row">
               <div class="col-3"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Registro de Asignaciones</h1><br>
                    <c:forEach items="${lista}" var="lis">
                        <form action="/zoologico/guiaItinerario?action=actualizar&idguia_itinerario=${lis.getIdguia_itinerario()}" method="POST">
                            <label>Guias</label>
                            <select class="form-control" name="idguia">
                                <option value="${lis.getIdguia()}" selected >${lis.getNombre()}</option>
                                <c:forEach items="${guias}" var="gui">
                                    <c:if test="${lis.getIdguia() != gui.getIdguia()}"><option value="${gui.getIdguia()}">${gui.getNombre()}</option></c:if>
                                    <% //  <option value="${listaE.getIdespecie()}" <c:if test="${listaE.getIdespecie() == lis.getIdespecie()}">selected</c:if></option> %>
                                </c:forEach>
                                
                            </select>
                            <label>Itinerarios</label>
                            <select class="form-control" name="iditinerario">
                                <option value="${lis.getIditinerario()}" selected>ITI-00${lis.getCodigo()}</option>
                                <c:forEach items="${itinerarios}" var="i">
                                    <c:if test="${lis.getIditinerario() != i.getIditinerario()}"><option value="${i.getIditinerario()}">ITI-00${i.getCodigo()}</option></c:if>
                                </c:forEach>
                                
                            </select>
                            <br>
                            <button type="submit" class="btn btn-success">Actualizar</button>
                        </form>
                    </c:forEach>

                </div>
               <div class="col-3"></div>
            </div>
        </div>

    </body>
</html>

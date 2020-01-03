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
        <%@ include file="/resource/head.jsp" %>
        <link href="resource/materialize/css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="resource/CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <title>update-zona</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
        <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
            
            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/zona?action=consultar">Mostrar zonas</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-4"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Actualización de zonas</h1><br>
                    <c:forEach items="${lista}" var="lis">
                        <form action="/zoologico/zona?action=actualizar&idzona=${lis.getIdzona()}" method="POST">
                             <label for="nombrezona">Nombre de zona</label>
                            <input type="text" name="nombrezona" class="form-control" value="${lis.getNombrezona()}">
                            <label>Numero de zona</label>
                            <input type="number" name="numerozona" class="form-control" value="${lis.getNumerozona()}">
                            <label>Extencion territorial</label>
                            <input type="number" placeholder="Extencion territorial" name="extenTerritorial" class="form-control" value="${lis.getExtenTerritorial()}">
                            <label>Especie</label>
                            <select class="form-control" name="idespecie">
                                <option value="${lis.getIdespecie()}" selected>${lis.nombre_Espanol}</option>
                                <c:forEach items="${listaEspecie}" var="list">
                                    <c:if test="${lis.getIdespecie() != list.getIdespecie()}"><option value="${list.getIdespecie()}">${list.nombre_Espanol}</option></c:if>
                                    
                                    <% //  <option value="${listaE.getIdespecie()}" <c:if test="${listaE.getIdespecie() == lis.getIdespecie()}">selected</c:if></option> %>
                                </c:forEach>
                                
                            </select>
                            <br>
                            <button type="submit" class="btn btn-success">Actualizar</button>
                        </form><br><br>
                    </c:forEach>

                </div>
                <div class="col-3"></div>
            </div>
        </div>

    </body>
</html>

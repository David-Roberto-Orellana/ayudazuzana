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

                    <a class="btn btn-info" href="/zoologico/cuidadorEspecie?action=consultar">Mostrar Asignaciones</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Actualizacion de Asignaciones</h1><br>
                    <c:forEach items="${lista}" var="lis">
                        <form action="/zoologico/cuidadorEspecie?action=actualizar&idcuidador_especie=${lis.getIdcuidador_especie()}" method="POST">
                            <label>Cuidador</label>
                            <select class="form-control" name="idcuidador">
                                <option value="${lis.getIdcuidador()}" selected >${lis.getNombre()}</option>
                                <c:forEach items="${cuidadores}" var="cu">
                                    <c:if test="${lis.getIdcuidador() != cu.getIdcuidador()}"><option value="${cu.getIdcuidador()}">${cu.getNombre()}</option></c:if>
                                    <% //  <option value="${listaE.getIdespecie()}" <c:if test="${listaE.getIdespecie() == lis.getIdespecie()}">selected</c:if></option> %>
                                </c:forEach>

                            </select>
                            <label>Especie</label>
                            <select class="form-control" name="idespecie">
                                <option value="${lis.getIdespecie()}" selected>${lis.getNombre_Espanol()}</option>
                                <c:forEach items="${especies}" var="e">
                                    <c:if test="${lis.getIdespecie() != e.getIdespecie()}"><option value="${e.getIdespecie()}">${e.getNombre_Espanol()}</option></c:if>
                                </c:forEach>

                            </select>
                            <br>
                            <button type="submit" class="btn btn-success">Actualizar</button>
                        </form><br>
                    </c:forEach>

                </div>
                <div class="col-3"></div>
            </div>
        </div>

    </body>
</html>

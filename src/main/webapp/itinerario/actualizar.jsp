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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link href="resource/materialize/css/materialize.css" rel="stylesheet" type="text/css"/>
         <link href="resource/CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <title>update-Itinerario</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
        <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
            
            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/itinerario?action=consultar">Mostrar Itinerario</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-4"></div>
                <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Actualizacion de Itinerarios</h1><br>
                    <c:forEach items="${lista}" var="lis">
                        <form action="/zoologico/itinerario?action=actualizar&iditinerario=${lis.getIditinerario()}" method="POST">
                            <label>codigo</label>
                            <input type="number" name="codigo" class="form-control" value="${lis.getCodigo()}">
                            <label>Duración</label>
                            <input type="number" name="duracion_recorrido" class="form-control" value="${lis.getDuracion_recorrido()}">
                            <label>Longitud Itinerario</label>
                            <input type="number" name="longitud_itinerario" class="form-control" value="${lis.getLongitud_itinerario()}">
                            <label>Numero de Visitantes</label>
                            <input type="number" name="numero_visitantes" class="form-control" value="${lis.getNumero_visitantes()}">
                            <label>Especie</label>
                            <select class="form-control" name="idespecie">
                                <<option value="${lis.getIdespecie()}" selected>${lis.nombre_Espanol}</option>
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

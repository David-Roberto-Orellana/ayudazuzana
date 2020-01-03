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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>update-Itinerario</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                   <%@ include file="/resource/diseño.jsp" %>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/itinerario?action=consultar">Mostrar Itinerario</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-6">
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
                                <c:forEach items="${listaEspecie}" var="lis">
                                    <option value="${lis.idespecie}">${lis.getNombre_Espanol()}</option>
                                </c:forEach>
                                
                            </select>
                            <br>
                            <button type="submit" class="btn btn-success">Actualizar</button>
                        </form>
                    </c:forEach>

                </div>
            </div>
        </div>

    </body>
</html>

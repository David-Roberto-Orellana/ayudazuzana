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
        <title>update-Guia</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
        <%@ include file="/resource/diseño.jsp" %>
        <div class="container">



            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/guia?action=consultar">Mostrar Guia</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Actualizacion de Guias</h1><br>
                    <c:forEach items="${lista}" var="lis">
                        <form action="/zoologico/guia?action=actualizar&idguia=${lis.getIdguia()}" method="POST">
                            <label>Nombre de Guia</label>
                            <input type="text" name="nombre" class="form-control" value="${lis.getNombre()}">
                            <label>Direccion</label>
                            <input type="text" class="form-control" name="direccion" required value="${lis.getDireccion()}">
                            <label>Fecha de Ingreso</label>
                            <input type="date" name="fecha_inicio_Trabajar" class="form-control" value="${lis.getFecha_inicio_Trabajar()}">
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

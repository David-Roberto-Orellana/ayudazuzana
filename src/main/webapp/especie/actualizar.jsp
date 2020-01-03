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
        <title>update-especie</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
         <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-12">
                   
                </div>
            </div>
            <br>
            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/especie?action=consultar">Mostrar Especies</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-4"></div>
                <div class="col-6 with-header z-depth-2" style="align-content: center;">
                    <h1 class="h1">Actualizacion de especies</h1><br>
                    <c:forEach items="${lista}" var="lis">
                        <form action="/zoologico/especie?action=actualizar&idespecie=${lis.getIdespecie()}" method="POST">
                            <label>Nombre en Español</label>
                            <input type="text" name="nombre_Espanol" class="form-control" value="${lis.getNombre_Espanol()}">
                            <label>Clima</label>
                            <input type="text" name="nombre_Cientifico" class="form-control" value="${lis.getNombre_Cientifico()}">
                            <label>Vegetacion Predominante</label>
                            <input type="text" name="descripcion" class="form-control" value="${lis.getDescripcion()}">
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

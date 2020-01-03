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
       
        <title>update-habitat</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
        <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
            
            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/habitat?action=consultar">Mostrar habitat</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-4"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Registro de habitat</h1><br>
                    <c:forEach items="${lista}" var="lis">
                        <form action="/zoologico/habitat?action=actualizar&idhabitat=${lis.getIdhabitat()}" method="POST">
                             <label>Nombre de Habitat</label>
                            <input type="text" placeholder="Nombre habitat" name="nombre" class="form-control" value="${lis.getNombre()}">
                            <label>Clima</label>
                            <input type="text" placeholder="Clima" name="clima" class="form-control" value="${lis.getClima()}">
                            <label>Vegetacion Predominante</label>
                            <input type="text" placeholder="Vequetacion que predomina" name="veg_predominante" class="form-control" value="${lis.getVeg_predominante()}">
                            <label>Continente de Vegetacion</label>
                            <input type="text" placeholder="Continente Vequetacion." name="continente_vegetacion" class="form-control" value="${lis.getContinente_vegetacion()}">
                            
                            <br>
                            <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                            <br><br>
                    </c:forEach>

                </div>
                <div class="col-3"></div>
            </div>
        </div>

    </body>
</html>

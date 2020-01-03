<%-- 
    Document   : index
    Created on : 11-11-2019, 09:38:36 AM
    Author     : david.orellanausam
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><script src="bootstrap/js/jquery.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <%@ include file="/resource/head.jsp" %>
        <link href="resource/materialize/css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="resource/CSS/estilos.css" rel="stylesheet" type="text/css"/>
        <title>zoologico-asingaciones-guias</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
        <%@ include file="/resource/diseño.jsp" %>
        <div class="container">

            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/guiaItinerario?action=consultar">Mostrar asignaciones</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-4"></div>
                <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Asignación de guia a itinerarios.</h1><br>

                    <form action="/zoologico/guiaItinerario?action=insertar" method="POST">
                        <label style="font-family: 'Arimo', sans-serif;">Guias</label>
                        <select id="guia"class="form-control" name="idguia">
                            <option value="">-- Seleccione Guia</option>
                            <c:forEach items="${guias}" var="g">
                                <option value="${g.idguia}">${g.nombre}</option>
                            </c:forEach>

                        </select><label id="requerido"></label><br>


                        <label style="font-family: 'Arimo', sans-serif;">Itinerarios</label>
                        <select id="itinerario" class="form-control" name="iditinerario">
                            <option value="">-- Seleccione Itinerario</option>
                            <c:forEach items="${itinerarios}" var="i">
                                <option value="${i.iditinerario}">ITI-00${i.codigo}</option>
                            </c:forEach>

                        </select><label id="requerido1"></label><br>

                        <button type="submit" onclick="return asignarGuia();" class="btn btn-success">Asignar</button>
                    </form><br><br>
                </div>
                <div class="col-4"></div>
            </div>


        </div>
    </body>
</html>

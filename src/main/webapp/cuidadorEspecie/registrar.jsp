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
        <title>zoologico-asingaciones-especie</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">
        <%@ include file="/resource/diseño.jsp" %>
        <div class="container">

            <div class="row">
                <div class="col-12">

                    <a class="btn btn-info" href="/zoologico/cuidadorEspecie?action=consultar">Mostrar asignaciones</a>
                </div>
            </div><br>
            <div class="row">
                <div class="col-3"></div>
                <div class="col-6 with-header z-depth-5" style="align-content: center;">
                    <h1 class="h3">Asignación de especie a cuidadores.</h1><br>

                    <form action="/zoologico/cuidadorEspecie?action=insertar" method="POST">

                        <label style="font-family: 'Arimo', sans-serif;">Cuidadores.</label>
                        <select id="nombre" class="form-control" name="idcuidador">
                            <option value="">-- Seleccione Cuidador</option>
                            <c:forEach items="${cuidadores}" var="c">
                                <option value="${c.idcuidador}">${c.nombre}</option>
                            </c:forEach>

                        </select><label id="requerido"></label><br>

                        <label style="font-family: 'Arimo', sans-serif;">Especies</label>
                        <select id="especie" class="form-control" name="idespecie">
                            <option value="">-- Seleccione especie</option>
                            <c:forEach items="${especies}" var="e">
                                <option value="${e.idespecie}">${e.nombre_Espanol}</option>
                            </c:forEach>

                        </select><label id="requerido1"></label><br>

                        <label style="font-family: 'Arimo', sans-serif;">Fecha asignacion</label>
                        <input id="fecha" type="date" class="form-control" name="fecha_asignacion"><label id="requerido2"></label><br>

                        <label style="font-family: 'Arimo', sans-serif;">Hora de asignacion</label>
                        <input id="hora" type="time" class="form-control" name="hora_asignacion"><label id="requerido3"></label><br>
                        <br>
                        <button type="submit" onclick="return cuidadorEspecie();" class="btn btn-success">Asignar</button>
                    </form><br><br>
                </div>
                <div class="col-3"></div>
            </div>


        </div>
    </body>
</html>

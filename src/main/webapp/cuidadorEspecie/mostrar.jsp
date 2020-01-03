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
        <%@ include file="/resource/head.jsp" %>
    <script src="bootstrap/js/jquery.js" type="text/javascript"></script>
 <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <title>mostrar-asignaciones</title>
    


</head>
<body  background="resource/imagenes/fondo.jpg">
    <%@ include file="/resource/diseño.jsp" %>
    <div class="container">
        
        <div class="row">
            <div class="col-12">
                <a class="btn btn-info" href="/zoologico/cuidadorEspecie?action=registrar">Agregar Asignacion</a>

            </div>
        </div><br>
        <div class="row">
            <div class="col-12">

                <h1 class="h3">Asignaciones de Especies a cuidadores</h1><br>
            </div>
        </div>
        <div class="row">

            <div class="coL-sm-12 col-xl-12 col-md-12">

                <table id="table"class="table table-hover">
                    <thead>
                        <tr>
                            <td>N°</td>
                            <td>Cuidador</td>
                            <td>Especie</td>
                            <td>Fecha asignacion</td>
                            <td>Hora asignacion</td>
                            <td>
                                Mantenimientos
                            </td>
                        </tr>
                    </thead>
                    <tbody>
                        <%int correlativo = 1;%>
                        <c:forEach items="${lista}" var="con">
                        <tr> 
                            <td><%out.print(correlativo);%></td>
                                <td>${con.nombre}</td>
                                <td>${con.nombre_Espanol}</td>
                                <td>${con.fecha_asignacion}</td>
                                <td>${con.hora_asignacion}</td>
                                <td>
                                    <a type="button"class="btn btn-warning" href="/zoologico/cuidadorEspecie?action=consultarById&idcuidador_especie=${con.idcuidador_especie}">Modificar</a>
                                    <a type="button" class="btn btn-danger" href="/zoologico/cuidadorEspecie?action=eliminar&idcuidador_especie=${con.idcuidador_especie}">Eliminar</a>
                                </td>
                                <%correlativo++;%>
                            
                        </tr> 
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div><br>


    </div>
</body>
</html>

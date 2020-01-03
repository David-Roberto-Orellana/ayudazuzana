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
    <title>mostrar-Guias</title>
    


</head>
<body background="resource/imagenes/fondo.jpg">
    <%@ include file="/resource/diseño.jsp" %>
    <div class="container">
       

        <div class="row">
            <div class="col-12">
                <a class="btn btn-info" href="/zoologico/guia?action=registrar">Ingresar Guia</a>

            </div>
        </div><br>
        <div class="row">
            <div class="col-12">

                <h1 class="h3">Lista de Guias</h1><br>
            </div>
        </div>
        <div class="row">

            <div class="col-12">

                <table id="table"class="table table-hover">
                    <thead>
                        <tr>
                            <td>N°</td>
                            <td>Nombre</td>
                            <td>Dirección</td>
                            <td>Fecha Inicio</td>
                            
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
                                <td>${con.direccion}</td>
                                <td>${con.fecha_inicio_Trabajar}</td>
                                
                                <td>
                                    <a type="button"class="btn btn-warning" href="/zoologico/guia?action=consultarById&idguia=${con.idguia}">Modificar</a>
                                    <a type="button" class="btn btn-danger" href="/zoologico/guia?action=eliminar&idguia=${con.idguia}">Eliminar</a>
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

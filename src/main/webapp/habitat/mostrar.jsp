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
    <title>mostrar-habitat</title>
    


</head>
<body background="resource/imagenes/fondo.jpg">
     <%@ include file="/resource/diseño.jsp" %>
    <div class="container">
        <div class="row">
            <div class="col-12">
              
            </div>
            <br>
        </div>    

        <div class="row">
            <div class="col-12">
                <a class="btn btn-info" href="/zoologico/habitat?action=registrar">Ingresar habitat</a>

            </div>
        </div><br>
        <div class="row">
            <div class="col-12">

                <h1 class="h3">Lista de habitat</h1><br>
            </div>
        </div>
        <div class="row">

            <div class="col-12">

                <table id="table"class="table table-hover">
                    <thead>
                        <tr>
                            <td>N°</td>
                            <td>Habitat</td>
                            <td>Clima</td>
                            <td>Vegetacion Predominante</td>
                            <td>Continente de la Vegetacion</td>
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
                                <td>${con.clima}</td>
                                <td>${con.veg_predominante}</td>
                                <td>${con.continente_vegetacion}</td>
                                <td>
                                    <a type="button"class="btn btn-warning" href="/zoologico/habitat?action=consultarById&idhabitat=${con.idhabitat}">Modificar</a>
                                    <a type="button" class="btn btn-danger" href="/zoologico/habitat?action=eliminar&idhabitat=${con.idhabitat}">Eliminar</a>
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

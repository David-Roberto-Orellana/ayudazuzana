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
        <script src="http://code.jquery.com/jquery-2.2.4.min.js" integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44=" crossorigin="anonymous"></script>

        <script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.js"></script>

        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/jquery.dataTables.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"><link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
        <script>
            $(document).ready(function () {
                $('.table').DataTable();
               
            });
        </script>
    
    <title>mostrar-Itinerario</title>
    


</head>
<body background="resource/imagenes/fondo.jpg"> 
    <%@ include file="/resource/diseño.jsp" %>
    <div class="container">
        

        <div class="row">
            <div class="col-12">
                <a class="btn btn-info" href="/zoologico/itinerario?action=registrar">Ingresar Itinerario</a>
                <a class="btn btn-info" href="/zoologico/guiaItinerario?action=registrar">Asignar Guia</a>

            </div>
        </div><br>
        <div class="row">
            <div class="col-12">

                <h1 class="h3">Lista de itinerarios</h1><br>
            </div>
        </div>
        <div class="row">

            <div class="col-12">

                <table id="table"class="table table-hover">
                    <thead>
                        <tr>
                            <td>N°</td>
                            <td>Código</td>
                            <td>Duración</td>
                            <td>Longitud</td>
                            <td>N° Visitantes</td>
                            <td>Especie</td>
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
                                <td>ITI-00${con.codigo}</td>
                                <td>${con.duracion_recorrido} horas</td>
                                <td>${con.longitud_itinerario} km</td>
                                <td>${con.numero_visitantes}</td>
                                <td>${con.nombre_Espanol}</td>
                                <td>
                                    <a type="button"class="btn btn-warning" href="/zoologico/itinerario?action=consultarById&iditinerario=${con.iditinerario}">Modificar</a>
                                    <a type="button" class="btn btn-danger" href="/zoologico/itinerario?action=eliminar&iditinerario=${con.iditinerario}">Eliminar</a>
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

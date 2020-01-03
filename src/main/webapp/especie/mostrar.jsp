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
        <script src="resource/bootstrap/js/jquery.js" type="text/javascript"></script>
        <script src="resource/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <%@ include file="/resource/head.jsp" %>

        <title>mostrar-especie</title>



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
                    
                    <!-- Button trigger modal -->
                    <button type="button" class="btn btn-info" data-toggle="modal" data-target="#exampleModalScrollable">
                        Registro de especie
                    </button>
                </div>
            </div><br>
            <div class="row">
                <div class="col-12">

                    <h1 class="h3">Lista de Especies</h1><br>
                </div>
            </div>
            <div class="row z-depth-5" >

                <div class="col-12">

                    <table id="table"class="table table-hover">
                        <thead>
                            <tr>
                                <td>N°</td>
                                <td>Nombre Español</td>
                                <td>Nombre Cientifico</td>
                                <td>Descripcion</td>
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
                                    <td>${con.nombre_Espanol}</td>
                                    <td>${con.nombre_Cientifico}</td>
                                    <td>${con.descripcion}</td>
                                    <td>
                                        <a type="button"class="btn btn-warning" href="/zoologico/especie?action=consultarById&idespecie=${con.idespecie}">Modificar</a>
                                        <a type="button" class="btn btn-danger" href="/zoologico/especie?action=eliminar&idespecie=${con.idespecie}">Eliminar</a>
                                    </td>
                                    <%correlativo++;%>

                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div><br>

            <!-- Modal -->
            <div class="modal fade" id="exampleModalScrollable" tabindex="-1" role="dialog" aria-labelledby="exampleModalScrollableTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-scrollable" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalScrollableTitle">Registro de Especie</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="/zoologico/especie?action=insertar" method="POST">
                            <label>Nombre de Especie en Español</label>
                            <input id="especie" type="text" placeholder="Nombre en Español" name="nombre_Espanol" class="form-control"><label id="requerido"></label><br>
                            <label>Nombre Cientifico</label>
                            <input id="cientifico" type="text" placeholder="Nombre Cientifico" name="nombre_Cientifico" class="form-control" ><label id="requerido1"></label><br>
                            <label>Descripcion</label>
                            <input id="descripcion" type="text" placeholder="Descripcion" name="descripcion" class="form-control" ><label id="requerido2"></label><br>
                            <br>
                            
                            <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="submit" onclick="return Especie();" class="btn btn-success">Guardar</button>
                        
                        </div>
                        </form>
                        </div>
                        
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>

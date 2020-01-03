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
        <title>zoologico-resgistro-zonas</title>
    </head>
      <body background="resource/imagenes/fondo.jpg">
           <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
           
                 <div class="row">
                    <div class="col-12">
                        
                        <a class="btn btn-info" href="/zoologico/zona?action=consultar">Mostrar zonas</a>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                        <h1 class="h3">Registro de zonas</h1><br>
                        
                        <form action="/zoologico/zona?action=insertar" method="POST">
                            <label style="font-family: 'Arimo', sans-serif;">Nombre de zona</label>
                            <input id="nombrez" type="text" placeholder="Nombre zona" name="nombrezona" class="form-control" ><label id="requerido"></label><br>
                            
                            <label style="font-family: 'Arimo', sans-serif;">Numero de zona</label>
                            <input id="numeroz" type="number" name="numerozona" class="form-control" ><label id="requerido1"></label><br>
                            
                            <label style="font-family: 'Arimo', sans-serif;">Extencion territorial</label>
                            <input id="extencionz" type="number" placeholder="Extencion territorial" name="extenTerritorial" class="form-control" ><label id="requerido2"></label><br>
                            
                            <label style="font-family: 'Arimo', sans-serif;">Especie</label>
                            <select id="especiez" class="form-control" name="idespecie" >
                                <option value="">Seleccione especie</option>
                                <c:forEach items="${listaEspecie}" var="lis">
                                    <option value="${lis.idespecie}">${lis.nombre_Espanol}</option>
                                </c:forEach>
                                
                            </select><label id="requerido3"></label><br>
                            <br>
                            <button type="submit" onclick="return ValidacionZona();" class="btn btn-success">Guardar</button>
                        </form><br><br>
                    </div>
                    <div class="col-3"></div>
                </div>
                

            </div>
    </body>
</html>

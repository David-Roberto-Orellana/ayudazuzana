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
        <title>zoologico-resgistro-Itinerarios</title>
    </head>
      <body background="resource/imagenes/fondo.jpg">
          <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
            
                 <div class="row">
                    <div class="col-12">
                        
                        <a class="btn btn-info" href="/zoologico/itinerario?action=consultar">Mostrar itinerarios</a>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-4"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                        <h1 class="h3">Registro de Itinerario</h1><br>
                        
                        <form action="/zoologico/itinerario?action=insertar" method="POST">
                            <label  style="font-family: 'Arimo', sans-serif;">codigo</label>
                            <input id="codigo" type="number" name="codigo" class="form-control"><label id="requerido"></label><br>
                            
                            <label  style="font-family: 'Arimo', sans-serif;">Duración</label>
                            <input id="duracion" type="number" name="duracion_recorrido" class="form-control"><label id="requerido1"></label><br>
                            
                            <label  style="font-family: 'Arimo', sans-serif;">Longitud Itinerario</label>
                            <input id="longitud" type="number" name="longitud_itinerario" class="form-control"><label id="requerido2"></label><br>
                            
                            <label  style="font-family: 'Arimo', sans-serif;">Numero de Visitantes</label>
                            <input id="visitantes" type="number" name="numero_visitantes" class="form-control"><label id="requerido3"></label><br>
                            
                            <label  style="font-family: 'Arimo', sans-serif;">Especie</label>
                            <select id="especie" class="form-control" name="idespecie">
                                <option value="">-- Seleccione especie</option>
                                <c:forEach items="${listaEspecie}" var="lis">
                                    <option value="${lis.idespecie}">${lis.nombre_Espanol}</option>
                                </c:forEach>
                                
                            </select><label id="requerido4"></label><br>
                            <br>
                            <button type="submit"  onclick="return itinerario();"class="btn btn-success">Guardar</button>
                        </form><br><br>
                    </div>
                    <div class="col-3"></div>
                </div>
                

            </div>
    </body>
</html>

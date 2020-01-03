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
        <title>zoologico-resgistro-Guia</title>
    </head>
      <body  background="resource/imagenes/fondo.jpg">
          <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
           
                 <div class="row">
                    <div class="col-12">
                        
                        <a class="btn btn-info" href="/zoologico/guia?action=consultar">Mostrar Guia</a>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-3"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                        <h1 class="h3">Registro de Guias</h1><br>
                        
                        <form action="/zoologico/guia?action=insertar" method="POST">
                            <label style="font-family: 'Arimo', sans-serif;">Nombre de Guia</label>
                            <input id="nombre" type="text" name="nombre" class="form-control"><label id="requerido"></label><br>
                            <label style="font-family: 'Arimo', sans-serif;">Direccion</label>
                            <textarea id="direccion" class="form-control" name="direccion" required></textarea><label id="requerido1"></label><br>
                            <label style="font-family: 'Arimo', sans-serif;">Fecha de Ingreso</label>
                            <input id="fecha" type="date" name="fecha_inicio_Trabajar" class="form-control"><label id="requerido2"></label><br>
                            
                            <br>
                            <button type="submit" onclick="return guia();" class="btn btn-success">Guardar</button>
                        </form><br>
                    </div>
                    <div class="col-3"></div>
                </div>
                

            </div>
    </body>
</html>

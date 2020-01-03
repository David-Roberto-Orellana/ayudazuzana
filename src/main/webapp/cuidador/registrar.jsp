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
        <title>zoologico-resgistro-cuidador</title>
    </head>
      <body  background="resource/imagenes/fondo.jpg">
            <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
           
                 <div class="row">
                    <div class="col-12">
                        
                        <a class="btn btn-info" href="/zoologico/cuidador?action=consultar">Mostrar cuidador</a>
                    </div>
                </div><br>
                <div class="row">
                     <div class="col-4"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                        <h1 class="h3">Registro de cuidador</h1><br>
                        
                        <form action="/zoologico/cuidador?action=insertar" method="POST">
                            <label style="font-family: 'Arimo', sans-serif;">Nombre de cuidador</label>
                            <input id="nombre" type="text" name="nombre" class="form-control"><label id="requerido"></label><br>
                            
                            <label style="font-family: 'Arimo', sans-serif;">Direccion</label>
                            <textarea id="direccion" class="form-control" name="direccion" required></textarea><label id="requerido1"></label><br>
                            
                            <label style="font-family: 'Arimo', sans-serif;">telefono</label>
                            <input id="telefono" type="text" name="telefono" class="form-control"><label id="requerido2"></label><br>
                            
                            <label style="font-family: 'Arimo', sans-serif;">Fecha de Ingreso</label>
                            <input id="fecha" type="date" name="fecha_ingreso" class="form-control"><label id="requerido3"></label><br>
                            
                            <br>
                            <button type="submit" onclick="return cuidador();" class="btn btn-success">Guardar</button>
                        </form> <br> <br>
                    </div>
                      <div class="col-3"></div>
                </div>
                

            </div>
    </body>
</html>

<%-- 
    Document   : index
    Created on : 11-11-2019, 09:38:36 AM
    Author     : david.orellanausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resource/bootstrap/js/jquery.js" type="text/javascript"></script>
        <script src="resource/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <%@ include file="/resource/head.jsp" %>
       <link href="resource/materialize/css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="resource/CSS/estilos.css" rel="stylesheet" type="text/css"/>
       
        <title>zoologico</title>
    </head>
      <body background="resource/imagenes/fondo.jpg">
          <%@ include file="/resource/diseño.jsp" %>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    
                </div>
             </div>
                <br>
                 <div class="row">
                    <div class="col-12">
                        
                        <a class="btn btn-info" href="/zoologico/especie?action=consultar">Mostrar Especies</a>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-3"></div>
                    <div class="col-6 with-header z-depth-5" style="align-content: center;">
                        <h1 class="h1">Registro de especies</h1><br>
                        <form action="/zoologico/especie?action=insertar" method="POST">
                            <label>Nombre de Especie en Español</label>
                            <input id="especie" type="text" placeholder="Nombre en Español" name="nombre_Espanol" class="form-control"><label id="requerido"></label><br>
                            <label>Nombre Cientifico</label>
                            <input id="cientifico" type="text" placeholder="Nombre Cientifico" name="nombre_Cientifico" class="form-control" ><label id="requerido1"></label><br>
                            <label>Descripcion</label>
                            <input id="descripcion" type="text" placeholder="Descripcion" name="descripcion" class="form-control" ><label id="requerido2"></label><br>
                            <br>
                            
                        </form>
                        <br><br>
                    </div>
                    <div class="col-3"></div>
                </div>
                

            </div>
    </body>
</html>

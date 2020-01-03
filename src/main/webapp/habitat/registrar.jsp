<%-- 
    Document   : index
    Created on : 11-11-2019, 09:38:36 AM
    Author     : david.orellanausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="bootstrap/js/jquery.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
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
                        
                        <a class="btn btn-info" href="/zoologico/habitat?action=consultar">Mostrar habitat</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3"></div>
                    <div class="col-6 z-depth-5" style="align-content: center;">
                        <h1 class="h3"> de habitat</h1><br>
                        
                        <form action="/zoologico/habitat?action=insertar" method="POST">
                            <label style="font-family: 'Arimo', sans-serif;">Nombre de Habitat</label>
                            <input id="nombre" type="text" placeholder="Nombre habitat" name="nombre" class="form-control" ><label id="requerido"></label><br>
                            <label style="font-family: 'Arimo', sans-serif;">Clima</label>
                            <input id="clima" type="text" placeholder="Clima" name="clima" class="form-control"><label id="requerido1"></label><br>
                            <label style="font-family: 'Arimo', sans-serif;">Vegetacion Predominante</label>
                            <input id="vegetacion" type="text" placeholder="Vequetacion que predomina" name="veg_predominante" class="form-control" ><label id="requerido2"></label><br>
                            <label style="font-family: 'Arimo', sans-serif;">Continente de Vegetacion</label>
                            <input id="continente" type="text" placeholder="Continente Vequetacion." name="continente_vegetacion" class="form-control" ><label id="requerido3"></label><br>
                            
                            <br>
                            <button type="submit" onclick="return habitat();" class="btn btn-success">Guardar</button>
                        </form><br><br>
                    </div>
                    <div class="col-3"></div>
                </div>
                

            </div>
    </body>
</html>

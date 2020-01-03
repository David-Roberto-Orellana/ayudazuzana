<%-- 
    Document   : index
    Created on : 11-11-2019, 09:38:36 AM
    Author     : david.orellanausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        
        <title>Zoologico-Zonas</title>
    </head>
      <body>
        <div class="container">
            <div class="row">
                <div class="col-12">
                 <%@ include file="/resource/diseño.jsp" %>
                </div>
             </div>
                
                
                
                <div class="row">
                    <div class="col-12">
                        <a class="btn btn-info" href="/zoologico/itinerario?action=registrar">Ingresar Itinerario</a>
                        <a class="btn btn-info" href="/zoologico/itinerario?action=consultar">Mostrar Itinerario</a>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-12">
                        <h1 class="h1">Bienvenido a itinerarios del zoologico</h1>
                    </div>
                </div><br>

            </div>
       
    </body>
</html>

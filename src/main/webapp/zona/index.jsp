<%-- 
    Document   : index
    Created on : 11-11-2019, 09:38:36 AM
    Author     : david.orellanausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <%@ include file="/resource/head.jsp" %>
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
                        <a class="btn btn-info" href="/zoologico/zona?action=registrar">Ingresar zona</a>
                        <a class="btn btn-info" href="/zoologico/zona?action=consultar">Mostrar zona</a>
                    </div>
                </div><br>
                <div class="row">
                    <div class="col-12">
                        <h1 class="h1">Bienvenido a Zonas del zoologico</h1>
                    </div>
                </div><br>

            </div>
       
    </body>
</html>

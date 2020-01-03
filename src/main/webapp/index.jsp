<%-- 
    Document   : index
    Created on : 11-25-2019, 02:06:50 PM
    Author     : david.orellanausam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="resource/bootstrap/js/jquery.js" type="text/javascript"></script>
        <script src="resource/carrucelJS.js" type="text/javascript"></script>
        <link href="resource/CSS/galeria.css" rel="stylesheet" type="text/css"/>
        <script src="resource/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="resource/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="resource/CSS/estilos.css" rel="stylesheet" type="text/css"/>


        <%@ include file="/resource/head.jsp" %>
        <title>Index</title>
    </head>
    <body background="resource/imagenes/fondo.jpg">

        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xl-12">
                    <%@ include file="/resource/diseño.jsp" %>
                </div>
            </div>
                
                <div class="row">
                    <div class="col-sm-2 col-xl-2 col-md-2"></div>
                    <div class="col-md-8 col-xl-8 col-sm-8">
                        <h1 style="color: black"><p style="font-size: 150px; font-weight: bold">ZOOLOGICO</p></h1>
                    </div>
                    <div class="col-sm-2 col-xl-2 col-md-2"></div>
                </div>
            <div class="row">
                <div class="col-md-12 col-xl-12 col-sm-12">
                    
                    <div class="photo-album">
                            <a href="#" class="large polaroid img1">
                            <img src="resource/imagenes/imagen13.jpg" alt=""/>
                            Mono
                        </a>
                        <a href="#" class="polaroid img2">
                            
                            Zorro
                            <img src="resource/imagenes/imagen4.jpg" alt=""/>
                        </a>		

                        <a href="#" class="medium polaroid img4">
                            <img src="resource/imagenes/imagen10.jpg" alt=""/>
                            Elefante
                        </a>


                        <a href="#" class="polaroid img5">
                            <img src="resource/imagenes/imagen1.jpg" alt=""/>
                            Leon
                        </a>


                        <a href="#" class="polaroid img6">
                            <img src="resource/imagenes/imagen8.jpg" alt=""/>
                            Serpiente
                        </a>

                        <a href="#" class="polaroid img7">
                            <img src="resource/imagenes/imagen3.jpg" alt=""/>
                            Guacamaya			
                        </a>
                        <a href="#" class="small polaroid img8">
                            <img src="resource/imagenes/imagen11.jpg" alt=""/>
                            Rinoceronte
                        </a>
                        <a href="#" class="medium polaroid img9">
                            <img src="resource/imagenes/imagen12.jpg" alt=""/>
                            Tucán
                        </a>
                        <a href="#" class="polaroid img10">
                            <img src="resource/imagenes/imagen14.jpg" alt=""/>
                            Hipopótamo
                        </a>
                        <a href="#" class="small polaroid img11">
                            <img src="resource/imagenes/imagen15.png" alt=""/>
                            Osos
                        </a>
                        <a href="#" class="small polaroid img12">
                            <img src="resource/imagenes/imagen2.jpg" alt=""/>
                            Cebra
                        </a>
                        <a href="#" class="small polaroid img13">
                            <img src="resource/imagenes/imagen9.jpg" alt=""/>
                            Tigre
                        </a>
                        <a href="#" class="small polaroid img14">
                            <img src="resource/imagenes/imagen6.png" alt=""/>
                            Lobo
                        </a>
                        <a href="#" class="polaroid img15">
                            <img src="resource/imagenes/imagen7.jpg" alt=""/>
                            Tortuga
                        </a>
                    </div>
                    

                </div>
            </div>

    </body>
</html>

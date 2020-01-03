function itinerario(){
    var codigo=document.getElementById("codigo").value;
    var duracion=document.getElementById("duracion").value;
    var longitud=document.getElementById("longitud").value;
    var visitantes=document.getElementById("visitantes").value;
    var especie=document.getElementById("especie").value;
    var mensaje1="* Campo Requerido";
    var mensaje2="Excelente";
    
    if(isNaN(codigo) || codigo.length ==0){
        document.getElementById("codigo").style.boxShadow ='0 0 10px red';
        document.getElementById("codigo").placeholder ="Campo obligatorio";
        document.getElementById("requerido").innerHTML=mensaje1;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="red";
        document.getElementById("requerido").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("codigo").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido").innerHTML=mensaje2;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="green";
        document.getElementById("requerido").style.fontSize="15px";
    }
    
    if(isNaN(duracion) || duracion.length ==0){
        document.getElementById("duracion").style.boxShadow ='0 0 10px red';
        document.getElementById("duracion").placeholder ="Campo obligatorio";
        document.getElementById("requerido1").innerHTML=mensaje1;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="red";
        document.getElementById("requerido1").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("duracion").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido1").innerHTML=mensaje2;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="green";
        document.getElementById("requerido1").style.fontSize="15px";
    }
    
    if(isNaN(longitud) || longitud.length ==0){
        document.getElementById("longitud").style.boxShadow ='0 0 10px red';
        document.getElementById("longitud").placeholder ="Campo obligatorio";
        document.getElementById("requerido2").innerHTML=mensaje1;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="red";
        document.getElementById("requerido2").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("longitud").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido2").innerHTML=mensaje2;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="green";
        document.getElementById("requerido2").style.fontSize="15px";
    }
    if(isNaN(visitantes) || visitantes.length ==0){
        document.getElementById("visitantes").style.boxShadow ='0 0 10px red';
        document.getElementById("visitantes").placeholder ="Campo obligatorio";
        document.getElementById("requerido3").innerHTML=mensaje1;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="red";
        document.getElementById("requerido3").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("visitantes").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido3").innerHTML=mensaje2;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="green";
        document.getElementById("requerido3").style.fontSize="15px";
    }
    
    if(especie.length ==0){
        document.getElementById("especie").style.boxShadow ='0 0 10px red';
        document.getElementById("especie").placeholder ="Campo obligatorio";
        document.getElementById("requerido4").innerHTML=mensaje1;
        document.getElementById("requerido4").style.fontFamily="arial";
        document.getElementById("requerido4").style.color="red";
        document.getElementById("requerido4").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("especie").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido4").innerHTML=mensaje2;
        document.getElementById("requerido4").style.fontFamily="arial";
        document.getElementById("requerido4").style.color="green";
        document.getElementById("requerido4").style.fontSize="15px";
    }
    return true;
}


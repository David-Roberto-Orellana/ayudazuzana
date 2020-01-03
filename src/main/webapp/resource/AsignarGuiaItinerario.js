function asignarGuia(){
    var guia=document.getElementById("guia").value;
    var itinerario=document.getElementById("itinerario").value;
    var mensaje1="* Campo Requerido";
    var mensaje2="Excelente";
    
    if (guia.length == 0) {
        document.getElementById("guia").style.boxShadow ='0 0 10px red';
        document.getElementById("guia").placeholder ="Campo obligatorio";
        document.getElementById("requerido").innerHTML=mensaje1;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="red";
        document.getElementById("requerido").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("guia").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido").innerHTML=mensaje2;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="green";
        document.getElementById("requerido").style.fontSize="15px";
    }
    
    if (itinerario.length == 0) {
        document.getElementById("itinerario").style.boxShadow ='0 0 10px red';
        document.getElementById("itinerario").placeholder ="Campo obligatorio";
        document.getElementById("requerido1").innerHTML=mensaje1;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="red";
        document.getElementById("requerido1").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("itinerario").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido1").innerHTML=mensaje2;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="green";
        document.getElementById("requerido1").style.fontSize="15px";
    }
    return true;
}



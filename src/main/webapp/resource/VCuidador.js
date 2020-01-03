function cuidador(){
    var nombre=document.getElementById("nombre").value;
    var direccion=document.getElementById("direccion").value;
    var telefono=document.getElementById("telefono").value;
    var fecha=document.getElementById("fecha").value;
     var mensaje1="* Campo Requerido";
    var mensaje2="Excelente";
    
    if(nombre.length == 0){
        document.getElementById("nombre").style.boxShadow = '0 0 10px red';
        document.getElementById("nombre").placeholder ="Campo obligatorio";
        document.getElementById("requerido").innerHTML=mensaje1;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="red";
        document.getElementById("requerido").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("nombre").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido").innerHTML=mensaje2;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="green";
        document.getElementById("requerido").style.fontSize="15px";
    }
    if(direccion.length == 0){
        document.getElementById("direccion").style.boxShadow = '0 0 10px red';
        document.getElementById("direccion").placeholder ="Campo obligatorio";
        document.getElementById("requerido1").innerHTML=mensaje1;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="red";
        document.getElementById("requerido1").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("direccion").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido1").innerHTML=mensaje2;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="green";
        document.getElementById("requerido1").style.fontSize="15px";
    }
    
    if(telefono.length == 0){
        document.getElementById("telefono").style.boxShadow = '0 0 10px red';
        document.getElementById("telefono").placeholder ="Campo obligatorio";
        document.getElementById("requerido2").innerHTML=mensaje1;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="red";
        document.getElementById("requerido2").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("telefono").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido2").innerHTML=mensaje2;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="green";
        document.getElementById("requerido2").style.fontSize="15px";
    }
    
    if(fecha == ""){
        document.getElementById("fecha").style.boxShadow = '0 0 10px red';
        document.getElementById("fecha").placeholder ="Campo obligatorio";
        document.getElementById("requerido3").innerHTML=mensaje1;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="red";
        document.getElementById("requerido3").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("fecha").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido3").innerHTML=mensaje2;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="green";
        document.getElementById("requerido3").style.fontSize="15px";
    }
}



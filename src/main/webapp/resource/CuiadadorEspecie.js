function cuidadorEspecie(){
    var nombre=document.getElementById("nombre").value;
    var especie=document.getElementById("especie").value;
    var fecha=document.getElementById("fecha").value;
    var hora=document.getElementById("hora").value;
    var mensaje1="* Campo requerido";
    var mensaje2="Excelente";
    
    if(nombre ==0){
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
    
     if(especie == 0){
        document.getElementById("especie").style.boxShadow = '0 0 10px red';
        document.getElementById("especie").placeholder ="Campo obligatorio";
        document.getElementById("requerido1").innerHTML=mensaje1;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="red";
        document.getElementById("requerido1").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("especie").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido1").innerHTML=mensaje2;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="green";
        document.getElementById("requerido1").style.fontSize="15px";
    }
    
    if(fecha == ""){
        document.getElementById("fecha").style.boxShadow = '0 0 10px red';
        document.getElementById("fecha").placeholder ="Campo obligatorio";
        document.getElementById("requerido2").innerHTML=mensaje1;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="red";
        document.getElementById("requerido2").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("fecha").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido2").innerHTML=mensaje2;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="green";
        document.getElementById("requerido2").style.fontSize="15px";
    }
    
    if(hora == 0){
        document.getElementById("hora").style.boxShadow = '0 0 10px red';
        document.getElementById("hora").placeholder ="Campo obligatorio";
        document.getElementById("requerido3").innerHTML=mensaje1;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="red";
        document.getElementById("requerido3").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("hora").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido3").innerHTML=mensaje2;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="green";
        document.getElementById("requerido3").style.fontSize="15px";
    }
    return true;
}



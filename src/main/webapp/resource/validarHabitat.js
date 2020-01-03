
function habitat(){
    var nombre=document.getElementById("nombre").value;
    var clima=document.getElementById("clima").value;
    var vegetacion=document.getElementById("vegetacion").value;
    var continente=document.getElementById("continente").value;
    var mensaje1="* Campo requerido";
    var mensaje2="Excelente";
    
    if(nombre.length == 0){
        document.getElementById("nombre").style.boxShadow='0 0 10px red';
        document.getElementById("nombre").placeholder="Campo Obligatorio";
        document.getElementById("requerido").innerHTML=mensaje1;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.fontSize="15px"
        document.getElementById("requerido").style.color="red";
        return false;
    }
    else{
        document.getElementById("nombre").style.boxShadow='0 0 10px green';
        document.getElementById("requerido").innerHTML=mensaje2;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.fontSize="15px"
        document.getElementById("requerido").style.color="green";
    }
    
    if(clima.length == 0){
        document.getElementById("clima").style.boxShadow='0 0 10px red';
        document.getElementById("clima").placeholder="Campo Obligatorio";
        document.getElementById("requerido1").innerHTML=mensaje1;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.fontSize="15px"
        document.getElementById("requerido1").style.color="red";
        return false;
    }
    else{
        document.getElementById("clima").style.boxShadow='0 0 10px green';
        document.getElementById("requerido1").innerHTML=mensaje2;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.fontSize="15px"
        document.getElementById("requerido1").style.color="green";
    }
    
    if(vegetacion.length == 0){
        document.getElementById("vegetacion").style.boxShadow='0 0 10px red';
        document.getElementById("vegetacion").placeholder="Campo Obligatorio";
        document.getElementById("requerido2").innerHTML=mensaje1;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.fontSize="15px"
        document.getElementById("requerido2").style.color="red";
        return false;
    }
    else{
        document.getElementById("vegetacion").style.boxShadow='0 0 10px green';
        document.getElementById("requerido2").innerHTML=mensaje2;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.fontSize="15px"
        document.getElementById("requerido2").style.color="green";
    }
    
      if(continente.length == 0){
        document.getElementById("continente").style.boxShadow='0 0 10px red';
        document.getElementById("continente").placeholder="Campo Obligatorio";
        document.getElementById("requerido3").innerHTML=mensaje1;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.fontSize="15px"
        document.getElementById("requerido3").style.color="red";
        return false;
    }
    else{
        document.getElementById("continente").style.boxShadow='0 0 10px green';
        document.getElementById("requerido3").innerHTML=mensaje2;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.fontSize="15px"
        document.getElementById("requerido3").style.color="green";
    }
    return true;
}

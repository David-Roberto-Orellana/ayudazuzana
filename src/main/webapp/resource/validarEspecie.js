function Especie(){
    var especie = document.getElementById("especie").value;
    var cientifico=document.getElementById("cientifico").value;
    var descripcion=document.getElementById("descripcion").value;
    var mensaje="* Campo requerido";
    var mensaje2="Excelente";
    
    if(especie.length == 0){
        document.getElementById("especie").style.boxShadow='0 0 10px red';
        document.getElementById("especie").placeholder ="Campo obligatorio";
        document.getElementById("requerido").innerHTML=mensaje;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="red";
        document.getElementById("requerido").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("especie").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido").innerHTML=mensaje2;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="green";
        document.getElementById("requerido").style.fontSize="15px";
        
    }
    
    if(cientifico.length == 0){
        document.getElementById("cientifico").style.boxShadow='0 0 10px red';
        document.getElementById("cientifico").placeholder ="Campo obligatorio";
        document.getElementById("requerido1").innerHTML=mensaje;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="red";
        document.getElementById("requerido1").style.fontSize="15px";
        return false;
       
    }else{
        document.getElementById("cientifico").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido1").innerHTML=mensaje2;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="green";
        document.getElementById("requerido1").style.fontSize="15px";
    }
    
    if(descripcion.length == 0){
        document.getElementById("descripcion").style.boxShadow='0 0 10px red';
        document.getElementById("descripcion").placeholder ="Campo obligatorio";
        document.getElementById("requerido2").innerHTML=mensaje;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="red";
        document.getElementById("requerido2").style.fontSize="15px";
        return false;
      
    }else{
        document.getElementById("descripcion").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido2").innerHTML=mensaje2;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="green";
        document.getElementById("requerido2").style.fontSize="15px";
    }
    return true;
}


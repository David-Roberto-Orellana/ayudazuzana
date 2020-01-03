
function ValidacionZona(){
    
    var nombre=document.getElementById("nombrez").value;
    var numero=document.getElementById("numeroz").value;
    var extencion=document.getElementById("extencionz").value;
    var especie=document.getElementById("especiez").value;
    var mensaje="* Campo requerido";
    var mensaje2="Excelente";
    
    // validando campo obligatorio
    if(nombre.length ==0){
        document.getElementById("nombrez").style.boxShadow = '0 0 10px red';
        document.getElementById("nombrez").placeholder ="Campo obligatorio";
        document.getElementById("requerido").innerHTML=mensaje;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="red";
        document.getElementById("requerido").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("nombrez").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido").innerHTML=mensaje2;
        document.getElementById("requerido").style.fontFamily="arial";
        document.getElementById("requerido").style.color="green";
        document.getElementById("requerido").style.fontSize="15px";
    }
    
    // validaon el numero de la zona
    if(isNaN(numero) || numero.length==0){
        document.getElementById("numeroz").style.boxShadow ='0 0 10px red';
        document.getElementById("numeroz").placeholder ="Campo obligatorio";
        document.getElementById("requerido1").innerHTML=mensaje;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="red";
        document.getElementById("requerido1").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("numeroz").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido1").innerHTML=mensaje2;
        document.getElementById("requerido1").style.fontFamily="arial";
        document.getElementById("requerido1").style.color="green";
        document.getElementById("requerido1").style.fontSize="15px";
    }
    
     // validando la extencion
    if(isNaN(extencion) || extencion.length==0){
        document.getElementById("extencionz").style.boxShadow = '0 0 15px red';
        document.getElementById("extencionz").placeholder ="Campo obligatorio";
        document.getElementById("requerido2").innerHTML=mensaje;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="red";
        document.getElementById("requerido2").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("extencionz").style.boxShadow = '0 0 15px green';
        document.getElementById("requerido2").innerHTML=mensaje2;
        document.getElementById("requerido2").style.fontFamily="arial";
        document.getElementById("requerido2").style.color="green";
        document.getElementById("requerido2").style.fontSize="15px";
    }
    
    if(especie == 0){
        document.getElementById("especiez").style.boxShadow = '0 0 10px red';
        document.getElementById("especiez").placeholder ="Campo obligatorio";
        document.getElementById("requerido3").innerHTML=mensaje;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="red";
        document.getElementById("requerido3").style.fontSize="15px";
        return false;
    }else{
        document.getElementById("especiez").style.boxShadow = '0 0 10px green';
        document.getElementById("requerido3").innerHTML=mensaje2;
        document.getElementById("requerido3").style.fontFamily="arial";
        document.getElementById("requerido3").style.color="green";
        document.getElementById("requerido3").style.fontSize="15px";
    }
    
    return true;
    
}

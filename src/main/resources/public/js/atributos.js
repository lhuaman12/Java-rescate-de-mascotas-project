function agregar_opciones(){
    const select = document.getElementById("tipo_de_pregunta");
    
    const opcion1 = document.getElementById("opcion_1");
        const opcion2 = document.getElementById("opcion_2");
        const opcion3 = document.getElementById("opcion_3");
    if(select.value == "multiple_choice"){
        
        opcion1.type="text";
        opcion2.type="text";
        opcion3.type="text";
        opcion1.disabled = false;
        opcion2.disabled = false;
        opcion3.disabled = false;
    }
    else{
        opcion1.type="hidden";
        opcion2.type="hidden";
        opcion3.type="hidden";
        opcion1.disabled = true;
        opcion2.disabled = true;
        opcion3.disabled = true;
    }
}
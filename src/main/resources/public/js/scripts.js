

// devuelve el array de las provincias junto a su ID
let obtenerProvincias = async () =>{
    let response = await fetch('https://apis.datos.gob.ar/georef/api/provincias');
    let info = await response.json();
    return info.provincias;
}

// devuelve todos los nombres de municipios por id
let obtenerMunicipios = async (id) =>{
    const URL = `https://apis.datos.gob.ar/georef/api/municipios?provincia=${id}&campos=id,nombre&max=200`;
    let response = await fetch(URL);
    let info = await response.json();
    return info.municipios.map(municipio=>municipio.nombre);
}
// devuelve solo el de bsas
let obtenerMunicipiosBsAs = async () =>{
    let response = await fetch('https://apis.datos.gob.ar/georef/api/municipios?provincia=06&campos=id,nombre&max=200');
    let info = await response.json();
    return info.municipios.map(municipio=>municipio.nombre);

}
//agrega las provincias al select y las devuelve
let agregarProvincias = async() =>{
    const provincias = await obtenerProvincias();
    const select = document.getElementById("provincias");
     for (let i = 0; i < provincias.length;i++ ) {
        var option = document.createElement("option");
        option.text = provincias[i].nombre;
        option.value = provincias[i].nombre;
        select.appendChild(option);
    }

}
//choreado 
function removeOptions(select) {
    var i, L = select.options.length - 1;
    for(i = L; i >= 0; i--) {
       select.remove(i);
    }
 }

let agregarMunicipios = async()=>{
    const provincias = await obtenerProvincias();
    const provinciaElegida = document.getElementById("provincias").value;
    const id = provincias.find(provincia=>provincia.nombre==provinciaElegida).id;
    
    const municipios = await obtenerMunicipios(id);
    const select = document.getElementById("municipios");
    removeOptions(select);
    if(municipios.length==0){
        var option = document.createElement("option");
        option.text = 'No hay municipios cargados';
        option.value = 'empty';
        select.appendChild(option);
    }
    else {
            for (let i = 0; i < municipios.length;i++ ) {
            var option = document.createElement("option");
            option.text = municipios[i];
            option.value = municipios[i];
            select.appendChild(option);
        }
   }
};

agregarProvincias();

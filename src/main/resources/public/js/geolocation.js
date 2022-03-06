function getLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(fillPosition);

    } else { 
      x.innerHTML = "Geolocation is not supported by this browser.";
    }
  }
  function fillPosition(position) {    
    const inputLongitud = document.getElementById("latitud");
    const inputLatitud = document.getElementById("longitud");
    inputLatitud.value = position.coords.latitude;
    inputLongitud.value = position.coords.longitude;

  }

  getLocation();




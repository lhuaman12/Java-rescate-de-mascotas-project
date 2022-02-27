function eliminarAtributo(idAtributo,idUsuario){
    
      $.ajax({
          type: "DELETE",
          url: "/usuario/"+idUsuario+"/eliminar_atributo/"+idAtributo,
          success: function(result){
              location.reload(true);
          }
      });
  }

  
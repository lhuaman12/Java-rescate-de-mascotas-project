package domain.controllers;

import db.EntityManagerHelper;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrganizacionController {
    private Repositorio<Usuario> usuarios;
    private Repositorio<Organizacion> organizaciones;

    public OrganizacionController() {
        this.usuarios = FactoryRepositorio.get(Usuario.class);
        this.organizaciones = FactoryRepositorio.get(Organizacion.class);
        //this.repositorioCuenta = FactoryRepositorio.get(Cuenta.class);
    }

    public ModelAndView panelDeAdmnistrador(Request request, Response response){
        Map<String,Object> params = new HashMap<>();
        String idUsuario = request.params("id");
        Usuario usuario = usuarios.buscar(Integer.valueOf(idUsuario));
        //Organizacion organizacion = organizaciones.buscar(Integer.valueOf(idOrg));
        Organizacion organizacion = organizaciones.buscar(3);

        List<Atributo> preguntasDeRegistro = organizacion.getPreguntasRequeridas().stream()
                .filter(p -> p.getTipoDeRegistro().getNombre().equals("registro_de_mascota") ).collect(Collectors.toList());
        List<Atributo> preguntasDeRescate = organizacion.getPreguntasRequeridas().stream()
                .filter(p -> p.getTipoDeRegistro().getNombre().equals("rescate") ).collect(Collectors.toList());
        List<Atributo> preguntasDeAdopcion = organizacion.getPreguntasRequeridas().stream()
                .filter(p -> p.getTipoDeRegistro().getNombre().equals("adopcion") ).collect(Collectors.toList());

        params.put("usuario",usuario);
        params.put("preguntas_de_registro",preguntasDeRegistro);
        params.put("preguntas_de_rescate",preguntasDeRescate);
        params.put("preguntas_de_adopcion",preguntasDeAdopcion);
        params.put("org",organizacion);
        return new ModelAndView(params,"administrador_panel.hbs");
    }

    public Response editarAtributo(Request request, Response response){
        String idAtributo = request.params("id");
        Atributo atributo =(Atributo)EntityManagerHelper.createQuery("from atributo where id="+idAtributo);
        String nombreCaracteristica = request.queryParams("nombre_caracteristica");
        //String opci


        return response;
    }
    public Response agregarAtributo(Request request,Response response){
        return response;
    }
}

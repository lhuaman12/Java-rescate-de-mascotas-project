package domain.controllers;

import db.EntityManagerHelper;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.organizaciones.PreguntasONG.OpcionDePregunta;
import domain.entities.organizaciones.PreguntasONG.TipoDePregunta;
import domain.entities.organizaciones.PreguntasONG.TipoDeRegistro;
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
    private Repositorio<Atributo> atributos;

    public OrganizacionController() {
        this.usuarios = FactoryRepositorio.get(Usuario.class);
        this.organizaciones = FactoryRepositorio.get(Organizacion.class);
        this.atributos = FactoryRepositorio.get(Atributo.class);
        //this.repositorioCuenta = FactoryRepositorio.get(Cuenta.class);
    }

    public ModelAndView panelDeAdmnistrador(Request request, Response response){
        Map<String,Object> params = new HashMap<>();
        String idUsuario = request.params("id_usuario");
        //String idOrganizacion = request.params("id_org");
        Usuario usuario = usuarios.buscar(Integer.valueOf(idUsuario));
        Organizacion organizacion = usuario.getOrganizacion();

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

    public ModelAndView editarAtributo(Request request, Response response){
        HashMap<String,Object> map = new HashMap<>();

        String idAtributo = request.params("id_atributo");
        String idUsuario = request.params("id_usuario");

        Usuario usuario = usuarios.buscar(Integer.valueOf(idUsuario));
        Atributo atributo = (Atributo)EntityManagerHelper.createQuery("from Atributo where id="+idAtributo).getSingleResult();

        //String tipoDeRegistro = atributo.getTipoDeRegistro().getNombre();

        map.put("atributo",atributo);
        map.put("usuario",usuario);
        //map.put("tipoDeRegistro",tipoDeRegistro);

        return new ModelAndView(map,"editar_atributo.hbs");
    }

    public Response handleEditarAtributo(Request request,Response response){
        String idusuario = request.params("id_usuario");
        String idAtributo = request.params("id_atributo");

        Atributo atributo = atributos.buscar(Integer.valueOf(idAtributo));
        atributo.setCaracteristicaNombre(request.queryParams("caracteristica"));

        if(atributo.getTipoDePregunta().getNombre().equals("multiple_choice")){
            int j=1;
            for(int i = 0; i < atributo.getOpciones().size() ; i++ ){
                atributo.getOpciones().get(i).setNombreOpcion(request.queryParams("opcion_"+ j));
                j++;
            }

        }
        atributos.modificar(atributo);
        response.redirect("/usuario/"+idusuario+"/panel");

        return response;
    }

    public Response handleEliminarAtributo(Request request, Response response){
        Repositorio<TipoDePregunta> tipoDePreguntaRepositorio = FactoryRepositorio.get(TipoDePregunta.class);
        Repositorio<TipoDeRegistro> tipoDeRegistroRepositorio = FactoryRepositorio.get(TipoDeRegistro.class);

        String idAtributo = request.params("id_atributo");
        String idUsuario = request.params("id_usuario");
        Usuario usuario = usuarios.buscar(Integer.valueOf(idUsuario));
        //
        Atributo atributo = atributos.buscar(Integer.valueOf(idAtributo));
        usuario.getOrganizacion().getPreguntasRequeridas().remove(atributo);

        organizaciones.modificar(usuario.getOrganizacion());
        tipoDePreguntaRepositorio.eliminar(atributo.getTipoDePregunta());
        tipoDeRegistroRepositorio.eliminar(atributo.getTipoDeRegistro());
        atributos.eliminar(atributo);
        return response;
    }


    public ModelAndView agregarAtributo(Request request, Response response){
        HashMap<String,Object> map = new HashMap<>();
        String idUsuario = request.params("id_usuario");
        map.put("id_usuario",idUsuario);
        return new ModelAndView(map,"agregar_atributo.hbs");
    }
    public Response handleAgregarAtributo(Request request,Response response) {
        String idUsuario = request.params("id_usuario");
        Usuario usuario = usuarios.buscar(Integer.valueOf(idUsuario));

        Atributo atributo = new Atributo();
        TipoDePregunta tipoDePregunta = new TipoDePregunta();
        TipoDeRegistro tipoDeRegistro = new TipoDeRegistro();

        atributo.setTipoDeRegistro(tipoDeRegistro);
        atributo.setTipoDePregunta(tipoDePregunta);
        atributo.setAdministradorResponsable(usuario);
        atributo.setOrganizacion(usuario.getOrganizacion());

        String tipoDeRegistroValue = request.queryParams("tipo_de_registro");
        String tipoDePreguntaValue = request.queryParams("tipo_de_pregunta");
        String caracteristica = request.queryParams("nombre_caracteristica");

        atributo.setCaracteristicaNombre(caracteristica);

        switch(tipoDePreguntaValue){
            case "boolean":
                tipoDePregunta.setNombre("boolean");
                break;
            case "multiple_choice":
                tipoDePregunta.setNombre("multiple_choice");
                for(int i=1 ; i<=3 ; i++ ){
                    String opcion = request.queryParams("opcion_"+i);
                    if(opcion!=null){
                        OpcionDePregunta opcionDePregunta = new OpcionDePregunta();
                        opcionDePregunta.setAtributo(atributo);
                        opcionDePregunta.setNombreOpcion(opcion);
                        atributo.getOpciones().add(opcionDePregunta);
                    }
                }
                break;
            case "pregunta":
                tipoDePregunta.setNombre("pregunta");
                break;
        }
        switch(tipoDeRegistroValue){
            case "rescate":
                tipoDeRegistro.setNombre("rescate");
                break;
            case "adopcion":
                tipoDeRegistro.setNombre("adopcion");
                break;
            case "registro":
                tipoDeRegistro.setNombre("registro_de_mascota");
                break;
        }
        usuario.getOrganizacion().getPreguntasRequeridas().add(atributo);
        organizaciones.modificar(usuario.getOrganizacion());
        atributos.agregar(atributo);

        response.redirect("/usuario/"+idUsuario+"/panel");
        return response;

    }
}

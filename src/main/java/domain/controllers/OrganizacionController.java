package domain.controllers;

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
        Organizacion organizacion = organizaciones.buscar(2);
        /*
        List<Atributo> preguntasDeRegistro = organizacion.getPreguntasRequeridas().stream()
                .filter(p -> p.getTipoDeAtributo() == TipoDeAtributo.REGISTRO).collect(Collectors.toList());
        List<Atributo> preguntasDeAdopcion = organizacion.getPreguntasRequeridas().stream()
                .filter(p -> p.getTipoDeAtributo() == TipoDeAtributo.ADOPCION).collect(Collectors.toList());
        List<Atributo> preguntasDeRescate = organizacion.getPreguntasRequeridas().stream()
                .filter(p -> p.getTipoDeAtributo() == TipoDeAtributo.RESCATE).collect(Collectors.toList());
        */
        //organizacion.getPreguntasRequeridas().get(1).getTipoDeDato().
        params.put("usuario",usuario);
        //params.put("preguntas_de_registro",preguntasDeRegistro);
        //params.put("pre")
        params.put("org",organizacion);
        return new ModelAndView(params,"administrador_panel.hbs");
    }
}

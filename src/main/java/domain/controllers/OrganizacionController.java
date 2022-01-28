package domain.controllers;

import db.EntityManagerHelper;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        params.put("usuario",usuario);
        params.put("org",usuario.getOrganizacion());
        return new ModelAndView(params,"administrador_panel.hbs");
    }
}

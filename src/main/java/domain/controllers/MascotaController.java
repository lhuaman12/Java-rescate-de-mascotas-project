package domain.controllers;

import domain.controllers.utils.UtilsRequest;
import domain.entities.mascotas.Mascota;
import domain.entities.mascotas.MascotaPerdida;
import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import org.apache.commons.io.IOUtils;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletException;
import javax.servlet.http.Part;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MascotaController {

    private Repositorio<Mascota> repo;
    private Repositorio<MascotaRegistrada> repoMascotaRegistrada;
    private Repositorio<MascotaPerdida> repoMascotaPerdida;
    private Repositorio<Usuario> repoUsuarios;
    private Repositorio<Organizacion> organizaciones;


    public MascotaController() {
        this.repo = FactoryRepositorio.get(Mascota.class);
        this.repoMascotaRegistrada = FactoryRepositorio.get(MascotaRegistrada.class);
        this.repoMascotaPerdida = FactoryRepositorio.get(MascotaPerdida.class);
        this.repoUsuarios = FactoryRepositorio.get(Usuario.class);
    }

    public ModelAndView registrarMascota(Request request, Response response) {
        String id  = request.params("id");
        Map<String,Object> params = new HashMap<>();
        Usuario usuario = this.repoUsuarios.buscar(Integer.valueOf(id));
        params.put("usuario", usuario);
        return new ModelAndView(params, "registro_mascota.hbs");
    }

    public Response guardarMascota(Request request, Response response) throws ServletException, IOException {
        String id = request.params("id");
        Usuario usuario = this.repoUsuarios.buscar(Integer.valueOf(id));

        request.attribute("org.eclipse.jetty.multipartConfig", new MultipartConfigElement("/temp"));
        //String result = UtilsRequest.ObtainAttributeByName(request,"nombre");
        //System.out.println(result);
        //System.out.println(request.raw().getPart("files").toString());
        Collection<Part> part = request.raw().getParts();
        Iterator<Part> iterator = part.iterator();
        /*
        while(iterator.hasNext()){
            iterator.next().getInputStream().
            //System.out.println("value="+iterator.next());
        }
        */


        /*try (InputStream is = request.raw().getPart("files").getInputStream()) {
            File targetFile = new File("src/main/resources/duenios/"+id+"/targetFile.jpeg");

        }
        */




        return response;
    }

    public ModelAndView mostrar(Request request, Response response) {
        Mascota mascota = this.repo.buscar(new Integer(request.params("id")));
        Map<String, Object> params = new HashMap<>();
        params.put("mascota", mascota);

        return new ModelAndView(new HashMap<>(), "mascota.hbs");
    }

    public ModelAndView mostrarTodas(Request request, Response response) {
        return null;
    }

    public Response guardarRegistroMascota(Request request, Response response) {


        return response;
    }

    public Response modificar(Request request, Response response) {

        String id = request.params("id");
        String nombre = request.params("nombre");
        String apodo = request.params("apodo");

        MascotaRegistrada mascota = this.repoMascotaRegistrada.buscar(new Integer(id));
        mascota.setNombre(nombre);
        mascota.setApodo(apodo);
        this.repoMascotaRegistrada.modificar(mascota);

        response.redirect("/mascotas");
        return response;
    }
}

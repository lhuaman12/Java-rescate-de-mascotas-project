package usuarios;

import db.EntityManagerHelper;
import domain.entities.distancia.Distancia;
import domain.entities.domicilio.Domicilio;
import domain.entities.domicilio.Municipio;
import domain.entities.domicilio.Provincia;
import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Rol;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UsuariosTest {
    @Test
    public void creacionDuenio(){
        Usuario duenio = new Usuario();
    }

    @Test
    public void crearVoluntarioDeOrg(){
        Repositorio<Organizacion> repoOrg = FactoryRepositorio.get(Organizacion.class);
        Organizacion organizacion = repoOrg.buscar(1);
        //Organizacion organizacion = (Organizacion) EntityManagerHelper.createQuery("from organizacion where id=1");

        Usuario usuario = new Usuario();
        Contacto contacto = new Contacto();
        Domicilio domicilio = new Domicilio();
        Municipio municipio = new Municipio();
        Provincia provincia = new Provincia();
        Rol rol = new Rol();

        usuario.setNombre("Leandro");
        usuario.setApellido("Rodriguez");
        usuario.setTipoDocumento(TipoDocumento.DNI);
        usuario.setNroDocumento("3000000");
        usuario.setOrganizacion(organizacion);

        domicilio.setCodPostal("1646");
        domicilio.setCalle("Independencia");
        domicilio.setLongitud(0.001);
        domicilio.setLatitud(0.001);
        domicilio.setAltura(444);

        provincia.setNombre("Buenos Aires");

        rol.setNombre("voluntario");

        municipio.setProvincia(provincia);
        usuario.getContactos().add(contacto);
        usuario.setDomicilio(domicilio);
        domicilio.setMunicipio(municipio);
        usuario.getRoles().add(rol);

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(usuario);
        EntityManagerHelper.commit();

    }

    @Test
    public void obtenerOrganizacionMasCercana(){
        Organizacion organizacion1 = new Organizacion();
        Domicilio domicilio1 = new Domicilio();
        Organizacion organizacion2 = new Organizacion();
        Domicilio domicilio2 = new Domicilio();
        Usuario usuario= new Usuario();
        Domicilio domicilio3 = new Domicilio();
        List<Organizacion> organizaciones = new ArrayList<>();
        ///
        domicilio1.setLongitud(-12.55);
        domicilio1.setLatitud(-15.22);
        organizacion1.setNombre("org1");
        organizacion1.setDomicilio(domicilio1); //8166.07 KMS
        //
        domicilio2.setLongitud(-100.55);
        domicilio2.setLatitud(-100.22);
        organizacion2.setNombre("org2");
        organizacion2.setDomicilio(domicilio2); //2215.23 KMS
        //
        domicilio3.setLatitud(-80.00);
        domicilio3.setLongitud(-80.00);
        usuario.setDomicilio(domicilio3);
        //
        organizaciones.add(organizacion1);
        organizaciones.add(organizacion2);
        // TEST
        //System.out.println(Distancia.calcularDistancia(organizacion2.getDomicilio().getLatitud(),organizacion2.getDomicilio().getLongitud(),usuario.getDomicilio().getLatitud(),usuario.getDomicilio().getLongitud()));
        //System.out.println(Distancia.calcularDistancia(organizacion1.getDomicilio().getLatitud(),organizacion1.getDomicilio().getLongitud(),usuario.getDomicilio().getLatitud(),usuario.getDomicilio().getLongitud()));
        Organizacion organizacionMasCercana = usuario.getOrganizacionMasCercana(organizaciones);
        Assert.assertEquals(organizacion2,organizacionMasCercana);

    }
}

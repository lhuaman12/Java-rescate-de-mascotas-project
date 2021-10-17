package database;

import db.EntityManagerHelper;
import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.MascotaRegistrada;
import domain.entities.mascotas.Sexo;
import domain.entities.mascotas.TamanioMascota;
import domain.entities.mascotas.TipoMascota;
import domain.entities.organizaciones.Organizacion;
import domain.entities.rescate.RescateConQR;
import domain.entities.rescate.RescateSinQR;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;


public class EntityManagerTest {

    // Login
    @Test
    public void persistirLoginTest() {

        // Login
        Login login = new Login();
        login.setUsername("test");
        login.setPassword("123456");

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(login);
        EntityManagerHelper.commit();
    }

    @Test
    public void recuperarLoginTest() {
        Login login = (Login) EntityManagerHelper.createQuery("from Login where username = 'test'").getSingleResult();
        Assert.assertEquals("test", login.getUsername());
    }


    // Usuario
    @Test
    public void persistirUsuarioTest() {

        // Login
        Login login = new Login();
        login.setUsername("jperez");
        login.setPassword("123456");

        // Domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle Usuario 1");
        domicilio.setAltura(1234);

        // Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setTipoDocumento(TipoDocumento.DNI);
        usuario.setNroDocumento("123456789");
        usuario.setFechaNacimiento(Date.from(Instant.now()));
        usuario.setLogin(login);
        usuario.setDomicilio(domicilio);

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(login);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.commit();
    }


    // Organización
    @Test
    public void persistirOrganizacionTest() {

        // Domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle Organización 1");
        domicilio.setAltura(1234);

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organización 1");
        organizacion.setDescripcion("Descripción Organización 1");
        organizacion.setDomicilio(domicilio);

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.commit();
    }


    // Mascota registrada
    @Test
    public void persistirMascotaRegistradaTest() {

        // Domicilio Organización
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organización 1");
        domicilioOrg.setAltura(1234);

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organización 1");
        organizacion.setDescripcion("Descripción Organización 1");
        organizacion.setDomicilio(domicilioOrg);

        // Login
        Login login = new Login();
        login.setUsername("jperez");
        login.setPassword("123456");

        // Domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle Usuario 1");
        domicilio.setAltura(1234);

        // Dueño
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setTipoDocumento(TipoDocumento.DNI);
        usuario.setNroDocumento("123456789");
        usuario.setFechaNacimiento(Date.from(Instant.now()));
        usuario.setLogin(login);
        usuario.setDomicilio(domicilio);

        // Mascota
        MascotaRegistrada mascota = new MascotaRegistrada();
        mascota.setNombre("Nombre Firulais");
        mascota.setApodo("Apodo Firulais");
        mascota.setFechaNac(Date.from(Instant.now()));
        mascota.setTipoMascota(TipoMascota.PERRO);
        mascota.setSexo(Sexo.MACHO);
        mascota.setTamanioMascota(TamanioMascota.MEDIANA);
        mascota.setDateTime(LocalDateTime.now());
        mascota.setOrganizacion(organizacion);
        mascota.setDuenio(usuario);

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(domicilioOrg);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(login);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.getEntityManager().persist(mascota);
        EntityManagerHelper.commit();

    }

    // Rescate con QR
    @Test
    public void persistirRescateConQRTest() {

        // Domicilio organización
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organización 2");
        domicilioOrg.setAltura(1234);

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organizacion 2");
        organizacion.setDescripcion("Descripción Organización 2");
        organizacion.setDomicilio(domicilioOrg);

        // Rescatista
        Usuario rescatista = new Usuario();
        rescatista.setNombre("Juan");
        rescatista.setApellido("Rescatista");
        rescatista.setTipoDocumento(TipoDocumento.DNI);
        rescatista.setNroDocumento("123456789");

        // Dueño
        Usuario duenio = new Usuario();
        duenio.setNombre("Juan");
        duenio.setApellido("Dueño");
        duenio.setTipoDocumento(TipoDocumento.DNI);
        duenio.setNroDocumento("987654321");

        // Domicilio rescate
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle");
        domicilio.setAltura(1234);

        // Rescate con QR
        RescateConQR rescateConQR = new RescateConQR();
        rescateConQR.setRescatista(rescatista);
        rescateConQR.setDomicilio(domicilio);
        rescateConQR.setDescripcion("Descripción del estado en que se encontró a la mascota con QR.");
        rescateConQR.setLocalDateTime(LocalDateTime.now());
        rescateConQR.setDuenio(duenio);
        rescateConQR.setOrganizacion(organizacion);

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(domicilioOrg);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(rescatista);
        EntityManagerHelper.getEntityManager().persist(duenio);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(rescateConQR);
        EntityManagerHelper.commit();

    }


    // Rescate sin QR
    @Test
    public void persistirRescateSinQRTest() {

        // Domicilio organización
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organización 3");
        domicilioOrg.setAltura(1234);

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organizacion 3");
        organizacion.setDescripcion("Descripción Organización 3");
        organizacion.setDomicilio(domicilioOrg);

        // Rescatista
        Usuario rescatista = new Usuario();
        rescatista.setNombre("Pedro");
        rescatista.setApellido("Rescatista");
        rescatista.setTipoDocumento(TipoDocumento.DNI);
        rescatista.setNroDocumento("123456789");

        // Domicilio rescate
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle");
        domicilio.setAltura(5678);

        // Rescate sin QR
        RescateSinQR rescateSinQR = new RescateSinQR();
        rescateSinQR.setRescatista(rescatista);
        rescateSinQR.setDomicilio(domicilio);
        rescateSinQR.setDescripcion("Descripción del estado en que se encontró a la mascota sin QR.");
        rescateSinQR.setLocalDateTime(LocalDateTime.now());
        rescateSinQR.setOrganizacion(organizacion);

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(domicilioOrg);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(rescatista);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(rescateSinQR);
        EntityManagerHelper.commit();
    }

}



package database;

import db.EntityManagerHelper;
import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.*;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.organizaciones.PreguntasONG.TipoDeAtributo;
import domain.entities.organizaciones.PreguntasONG.TipoDeDato;
import domain.entities.rescate.RescateConQR;
import domain.entities.rescate.RescateSinQR;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Array;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    // Contacto
    @Test
    public void persistirContactoTest() {

        // Contacto
        Contacto contacto = new Contacto();
        contacto.setNombre("Nombre contacto 1");
        contacto.setApellido("Apellido contacto 1");
        contacto.setTelefono("1234567890");
        contacto.setEmail("contacto1@mail.com");

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(contacto);
        EntityManagerHelper.commit();
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

        // Contacto
        Contacto contacto = new Contacto();
        contacto.setNombre("Nombre contacto Juan Pérez");
        contacto.setApellido("Apellido contacto Juan Pérez");
        contacto.setTelefono("1144448888");
        contacto.setEmail("contactoDeJuanPérez@mail.com");

        // Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setTipoDocumento(TipoDocumento.DNI);
        usuario.setNroDocumento("123456789");
        usuario.setFechaNacimiento(LocalDate.parse("1950-11-21"));
        usuario.setLogin(login);
        usuario.setDomicilio(domicilio);
        usuario.setContactos(contacto);

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

        // Domicilio organización
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organización 3");
        domicilioOrg.setAltura(1234);
        domicilioOrg.setLongitud(-80.00);
        domicilioOrg.setLatitud(-80.00);

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Los bichos");
        organizacion.setDescripcion("Rescatar y darles hogar a todos los animales");
        organizacion.setDomicilio(domicilioOrg);
        // Nuevo atributo tipo registro
        Atributo atributo1 = new Atributo(TipoDeAtributo.REGISTRO);
        atributo1.setTipoDeDato(TipoDeDato.PREGUNTA);
        atributo1.setCaracteristicaNombre("El perro tiene marcas de lesiones o cicatrices visibles");
        organizacion.getPreguntasRequeridas().add(atributo1);

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(domicilioOrg);
        EntityManagerHelper.persist(atributo1);
        EntityManagerHelper.persist(organizacion);
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
        usuario.setFechaNacimiento(LocalDate.parse("1844-11-21"));
        usuario.setLogin(login);
        usuario.setDomicilio(domicilio);

        // Mascota
        MascotaRegistrada mascota = new MascotaRegistrada();
        mascota.setNombre("Nombre Firulais");
        mascota.setApodo("Apodo Firulais");
        //mascota.setFechaNac(Date.from(Instant.now()));
        mascota.setTipoMascota(TipoMascota.PERRO);
        mascota.setSexo(Sexo.MACHO);
        //mascota.setTamanioMascota(TamanioMascota.MEDIANA);
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

    // Recuperar mascota registrada
    @Test
    public void recuperarMascotaRegistradaTest() {
        MascotaRegistrada mascotaRegistrada = (MascotaRegistrada) EntityManagerHelper.createQuery("from Mascota where id = 2").getSingleResult();
        Assert.assertEquals("Nombre Firulais", mascotaRegistrada.getNombre());
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
        domicilioOrg.setLongitud(-80.00);
        domicilioOrg.setLatitud(-80.00);

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Los bichos");
        organizacion.setDescripcion("Rescatar y darles hogar a todos los animales");
        organizacion.setDomicilio(domicilioOrg);
        // Nuevo atributo tipo registro
        Atributo atributo1 = new Atributo(TipoDeAtributo.REGISTRO);
        atributo1.setTipoDeDato(TipoDeDato.PREGUNTA);
        atributo1.setCaracteristicaNombre("El perro tiene marcas de lesiones o cicatrices visibles");
        organizacion.getPreguntasRequeridas().add(atributo1);

        // Mascota
        MascotaPerdida mascota = new MascotaPerdida();
        mascota.setEdadAproximada(EdadAproximada.ABUELO);
        mascota.setTipoMascota(TipoMascota.PERRO);
        mascota.setSexo(Sexo.MACHO);
        mascota.setTamanioMascota(TamanioMascota.MEDIANO);
        mascota.setDateTime(LocalDateTime.now());

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
        rescateSinQR.setMascotaPerdida(mascota);

        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(domicilioOrg);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(mascota);
        EntityManagerHelper.getEntityManager().persist(rescatista);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(rescateSinQR);
        EntityManagerHelper.commit();
    }

}



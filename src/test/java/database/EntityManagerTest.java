package database;

import db.EntityManagerHelper;
import domain.entities.domicilio.Domicilio;
import domain.entities.organizaciones.Organizacion;
import domain.entities.rescate.RescateConQR;
import domain.entities.rescate.RescateSinQR;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;


public class EntityManagerTest {

    @Test
    public void persistirLoginTest() {
        Login login = new Login();
        login.setUsername("test");
        login.setPassword("123456");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(login);
        EntityManagerHelper.commit();
    }

    @Test
    public void recuperarLoginTest() {
        Login login = (Login) EntityManagerHelper.createQuery("from Login where username = 'test'").getSingleResult();
        Assert.assertEquals("test", login.getUsername());
    }

    @Test
    public void persistirUsuarioAlternativoTest() {
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Pérez");
        usuario.setTipoDocumento(TipoDocumento.DNI);
        usuario.setNroDocumento("123456789");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(usuario);
        EntityManagerHelper.commit();
    }

    @Test
    public void persistirRescateConQRTest() {

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organizacion 1");
        organizacion.setDescripcion("Descripción Organización 1");

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

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(rescatista);
        EntityManagerHelper.getEntityManager().persist(duenio);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(rescateConQR);
        EntityManagerHelper.commit();

    }

    @Test
    public void persistirRescateSinQRTest() {

        // Organización
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organizacion 2");
        organizacion.setDescripcion("Descripción Organización 2");

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

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(rescatista);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(rescateSinQR);
        EntityManagerHelper.commit();
    }

}



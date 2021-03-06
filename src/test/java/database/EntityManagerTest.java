package database;

import db.EntityManagerHelper;
import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.*;
import domain.entities.organizaciones.Configuraciones.CalidadImagen;
import domain.entities.organizaciones.Configuraciones.EstandarImagen;
import domain.entities.organizaciones.Configuraciones.TamanioImagen;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.organizaciones.PreguntasONG.OpcionDePregunta;
import domain.entities.organizaciones.PreguntasONG.TipoDePregunta;
import domain.entities.organizaciones.PreguntasONG.TipoDeRegistro;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;


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

    //levantar
    @Test
    public void persistirVirtudes() {

        Repositorio<Virtud> virtudes = FactoryRepositorio.get(Virtud.class);

        Virtud virtud1 = new Virtud();
        Virtud virtud2 = new Virtud();
        Virtud virtud3 = new Virtud();
        Virtud virtud4 = new Virtud();
        Virtud virtud5 = new Virtud();
        Virtud virtud6 = new Virtud();

        virtud1.setNombre("carinioso"); //CARINIOSO,MANSO,PROTECTOR,TIMIDO,ALEGRE,CARACTER_FUERTE
        virtud2.setNombre("manso");
        virtud3.setNombre("protector");
        virtud4.setNombre("timido");
        virtud5.setNombre("alegre");
        virtud6.setNombre("caracter_fuerte");

        virtudes.agregar(virtud1);
        virtudes.agregar(virtud2);
        virtudes.agregar(virtud3);
        virtudes.agregar(virtud4);
        virtudes.agregar(virtud5);
        virtudes.agregar(virtud6);
    }
    /*
    public void persistirTipoDePreguntasyRegistros(){
        TipoDeRegistro tipoDeRegistro1 = new TipoDeRegistro();
        TipoDeRegistro tipoDeRegistro2 = new TipoDeRegistro();
        TipoDeRegistro tipoDeRegistro3 = new TipoDeRegistro();
        TipoDePregunta tipoDePregunta1 = new TipoDePregunta();
        TipoDePregunta tipoDePregunta2 = new TipoDePregunta();
        TipoDePregunta tipoDePregunta3 = new TipoDePregunta();

        tipoDeRegistro1.setNombre("adopcion");
        tipoDeRegistro2.setNombre("rescate");
        tipoDeRegistro3.setNombre("registro_de_mascota");
        tipoDePregunta1.setNombre("boolean");
        tipoDePregunta2.setNombre("multiple_choice");
        tipoDePregunta3.setNombre("pregunta");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(tipoDeRegistro1);
        EntityManagerHelper.persist(tipoDeRegistro2);
        EntityManagerHelper.persist(tipoDeRegistro3);
        EntityManagerHelper.persist(tipoDePregunta1);
        EntityManagerHelper.persist(tipoDePregunta2);
        EntityManagerHelper.persist(tipoDePregunta3);
        EntityManagerHelper.commit();

    }
    */
    // Organizaci??n
    @Test
    public void persistirPreguntasDeOrganizacionTest() {

        // Domicilio organizaci??n
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organizaci??n 3");
        domicilioOrg.setAltura(1234);
        domicilioOrg.setLongitud(-80.00);
        domicilioOrg.setLatitud(-80.00);


        // Organizaci??n
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Los bichos");
        organizacion.setDescripcion("Rescatar y darles hogar a todos los animales");
        organizacion.setDomicilio(domicilioOrg);

        // Config imagen
        EstandarImagen configImagen = new EstandarImagen();
        TamanioImagen tamanioImagen = new TamanioImagen();
        tamanioImagen.setAncho(700);
        tamanioImagen.setAlto(700);
        configImagen.setCalidadImagen(CalidadImagen.ALTA);
        configImagen.setTamanioImagen(tamanioImagen);
        organizacion.setEstandarImagen(configImagen);

        // Nuevo atributo tipo registro y boolean
        Atributo atributo1 = new Atributo();
        TipoDeRegistro tipoDeRegistro = new TipoDeRegistro();
        TipoDePregunta tipoDePregunta = new TipoDePregunta();
        tipoDeRegistro.setNombre("registro_de_mascota");
        tipoDePregunta.setNombre("boolean");
        atributo1.setTipoDeRegistro(tipoDeRegistro);
        atributo1.setTipoDePregunta(tipoDePregunta);
        atributo1.setCaracteristicaNombre("El perro tiene marcas de lesiones o cicatrices visibles");
        atributo1.setOrganizacion(organizacion);
        organizacion.getPreguntasRequeridas().add(atributo1);
        //Nuevo atributo tipo registro y boolean
        Atributo atributo2 = new Atributo();
        TipoDePregunta tipoDePregunta1 = new TipoDePregunta();
        TipoDeRegistro tipoDeRegistro1 = new TipoDeRegistro();
        tipoDeRegistro1.setNombre("registro_de_mascota");
        tipoDePregunta1.setNombre("boolean");
        atributo2.setCaracteristicaNombre("El perro presenta un peso inferior a 10 kgs");
        atributo2.setTipoDePregunta(tipoDePregunta1);
        atributo2.setTipoDeRegistro(tipoDeRegistro1);
        atributo2.setOrganizacion(organizacion);
        organizacion.getPreguntasRequeridas().add(atributo2);
        // Nuevo atributo tipo registro de multiple_choice
        Atributo atributo3 = new Atributo();
        TipoDePregunta tipoDePregunta2 = new TipoDePregunta();
        TipoDeRegistro tipoDeRegistro2 = new TipoDeRegistro();
        tipoDeRegistro2.setNombre("registro_de_mascota");
        tipoDePregunta2.setNombre("multiple_choice");
        atributo3.setTipoDePregunta(tipoDePregunta2);
        atributo3.setTipoDeRegistro(tipoDeRegistro2);
        atributo3.setOrganizacion(organizacion);
        atributo3.setCaracteristicaNombre("cuantas patas tiene");
        OpcionDePregunta opcion1 = new OpcionDePregunta();
        opcion1.setNombreOpcion("1");
        OpcionDePregunta opcion2 = new OpcionDePregunta();
        opcion2.setNombreOpcion("2");
        OpcionDePregunta opcion3 = new OpcionDePregunta();
        opcion3.setNombreOpcion("3");
        opcion1.setAtributo(atributo3);
        opcion2.setAtributo(atributo3);
        opcion3.setAtributo(atributo3);

        atributo3.getOpciones().add(opcion1);
        atributo3.getOpciones().add(opcion2);
        atributo3.getOpciones().add(opcion3);



        //
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(domicilioOrg);
        //
        EntityManagerHelper.persist(tipoDeRegistro);
        EntityManagerHelper.persist(tipoDePregunta);
        EntityManagerHelper.persist(atributo1);
        //
        EntityManagerHelper.persist(tipoDeRegistro1);
        EntityManagerHelper.persist(tipoDePregunta1);
        EntityManagerHelper.persist(atributo2);

        //
        EntityManagerHelper.persist(tipoDeRegistro2);
        EntityManagerHelper.persist(tipoDePregunta2);
        EntityManagerHelper.persist(opcion3);
        EntityManagerHelper.persist(opcion2);
        EntityManagerHelper.persist(opcion1);
        EntityManagerHelper.persist(tipoDePregunta2);
        EntityManagerHelper.persist(atributo3);
        //
        EntityManagerHelper.persist(organizacion);
        EntityManagerHelper.commit();
    }


    // Mascota registrada
    @Test
    public void persistirMascotaRegistradaTest() {

        // Domicilio Organizaci??n
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organizaci??n 1.jpg");
        domicilioOrg.setAltura(1234);

        // Organizaci??n
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organizaci??n 1.jpg");
        organizacion.setDescripcion("Descripci??n Organizaci??n 1.jpg");
        organizacion.setDomicilio(domicilioOrg);

        // Login
        Login login = new Login();
        login.setUsername("jperez");
        login.setPassword("123456");

        // Domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle Usuario 1.jpg");
        domicilio.setAltura(1234);

        // Due??o
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("P??rez");
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
        mascota.setTamanioMascota(TamanioMascota.MEDIANO);
        mascota.setDateTime(LocalDateTime.now());
        mascota.setOrganizacion(organizacion);
        mascota.setDuenio(usuario);

        // EntityManager
        EntityManagerHelper.beginTransaction();
        //EntityManagerHelper.getEntityManager().persist(domicilioOrg);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        //EntityManagerHelper.getEntityManager().persist(login);
        //EntityManagerHelper.getEntityManager().persist(domicilio);
        EntityManagerHelper.getEntityManager().persist(usuario);
        //EntityManagerHelper.getEntityManager().persist(mascota);
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

        // Domicilio organizaci??n
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organizaci??n 2");
        domicilioOrg.setAltura(1234);

        // Organizaci??n
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Organizacion 2");
        organizacion.setDescripcion("Descripci??n Organizaci??n 2");
        organizacion.setDomicilio(domicilioOrg);

        // Rescatista
        Usuario rescatista = new Usuario();
        rescatista.setNombre("Juan");
        rescatista.setApellido("Rescatista");
        rescatista.setTipoDocumento(TipoDocumento.DNI);
        rescatista.setNroDocumento("123456789");

        // Due??o
        Usuario duenio = new Usuario();
        duenio.setNombre("Juan");
        duenio.setApellido("Due??o");
        duenio.setTipoDocumento(TipoDocumento.DNI);
        duenio.setNroDocumento("987654321");

        // Domicilio rescate
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Calle");
        domicilio.setAltura(1234);

        // Rescate con QR
        /*
        RescateConQR rescateConQR = new RescateConQR();
        rescateConQR.setRescatista(rescatista);
        rescateConQR.setDomicilio(domicilio);
        rescateConQR.setDescripcion("Descripci??n del estado en que se encontr?? a la mascota con QR.");
        rescateConQR.setLocalDateTime(LocalDateTime.now());
        rescateConQR.setDuenio(duenio);
        rescateConQR.setOrganizacion(organizacion);
        */
        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(domicilioOrg);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(rescatista);
        EntityManagerHelper.getEntityManager().persist(duenio);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        //EntityManagerHelper.getEntityManager().persist(rescateConQR);
        EntityManagerHelper.commit();

    }


    // Rescate sin QR
    @Test
    public void persistirRescateSinQRTest() {

        // Domicilio organizaci??n
        Domicilio domicilioOrg = new Domicilio();
        domicilioOrg.setCalle("Calle Organizaci??n 3");
        domicilioOrg.setAltura(1234);
        domicilioOrg.setLongitud(-80.00);
        domicilioOrg.setLatitud(-80.00);

        // Organizaci??n
        Organizacion organizacion = new Organizacion();
        organizacion.setNombre("Los bichos");
        organizacion.setDescripcion("Rescatar y darles hogar a todos los animales");
        organizacion.setDomicilio(domicilioOrg);
        // Nuevo atributo tipo registro
        Atributo atributo1 = new Atributo();
     //   atributo1.setTipoDeDato(TipoDeDato.PREGUNTA);
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
        /*
        RescateSinQR rescateSinQR = new RescateSinQR();
        rescateSinQR.setRescatista(rescatista);
        rescateSinQR.setDomicilio(domicilio);
        rescateSinQR.setDescripcion("Descripci??n del estado en que se encontr?? a la mascota sin QR.");
        rescateSinQR.setLocalDateTime(LocalDateTime.now());
        rescateSinQR.setOrganizacion(organizacion);
        rescateSinQR.setMascotaPerdida(mascota);
        */
        // EntityManager
        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.getEntityManager().persist(domicilioOrg);
        EntityManagerHelper.getEntityManager().persist(organizacion);
        EntityManagerHelper.getEntityManager().persist(mascota);
        EntityManagerHelper.getEntityManager().persist(rescatista);
        EntityManagerHelper.getEntityManager().persist(domicilio);
        //EntityManagerHelper.getEntityManager().persist(rescateSinQR);
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
        domicilio.setCalle("Calle Usuario 1.jpg");
        domicilio.setAltura(1234);

        // Contacto
        Contacto contacto = new Contacto();
        contacto.setNombre("Nombre contacto Juan P??rez");
        contacto.setApellido("Apellido contacto Juan P??rez");
        contacto.setTelefono("1144448888");
        contacto.setEmail("contactoDeJuanP??rez@mail.com");

        // Usuario
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("P??rez");
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

}



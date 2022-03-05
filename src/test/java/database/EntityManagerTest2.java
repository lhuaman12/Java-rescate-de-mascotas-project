package database;

import db.EntityManagerHelper;
import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.*;
import domain.entities.organizaciones.Organizacion;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

public class EntityManagerTest2 {
    package database;

import db.EntityManagerHelper;
import domain.entities.adopcion.Adoptar;
import domain.entities.adopcion.DarAdopcion;
import domain.entities.adopcion.Pregunta;
import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.*;
import domain.entities.organizaciones.Organizacion;
import domain.entities.rescate.RescateConQR;
import domain.entities.rescate.RescateSinQR;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Login;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import domain.repositories.RepositorioDeUsuarios;
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

        // Contacto
        @Test
        public void persistirContactoTest() {

            // Contacto
            Contacto contacto = new Contacto();
            contacto.setNombre("Nombre contacto 1");
            contacto.setApellido("Apellido contacto 1");
            contacto.setTelefono("1234567890");
            contacto.setEmail("contacto1@email.com");

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
            domicilio.setAltura("1234");

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
            usuario.setFechaNacimiento(Date.from(Instant.now()));
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
        @Test
        public void persistirUsuarioTest2() {

            Usuario duenio1 = new Usuario();
            duenio1.setNombre("Nombre Dueño 1");
            duenio1.setApellido("Apellido Dueño 1");
            duenio1.setNroDocumento("12345678");
            //duenio1.setLogin(loginDue1);
            duenio1.setUsername("duenio1");
            duenio1.setPassword("duenio1");

            // EntityManager
            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().persist(duenio1);
            EntityManagerHelper.commit();
        }
        @Test
        public void persistirOrganizacionTest() {

            // Domicilio Organización 1
            Domicilio domicilioOrg1 = new Domicilio();
            domicilioOrg1.setCalle("Calle Organización 1");
            domicilioOrg1.setAltura("100");
            domicilioOrg1.setLocalidad("Localidad Organización 1");
            domicilioOrg1.setMunicipio("Municipio Organización 1");
            domicilioOrg1.setProvincia("Provincia Organización 1");

            // Domicilio Organización 2
            Domicilio domicilioOrg2 = new Domicilio();
            domicilioOrg2.setCalle("Calle Organización 2");
            domicilioOrg2.setAltura("200");
            domicilioOrg2.setLocalidad("Localidad Organización 2");
            domicilioOrg2.setMunicipio("Municipio Organización 2");
            domicilioOrg2.setProvincia("Provincia Organización 2");

            // Domicilio Organización 3
            Domicilio domicilioOrg3 = new Domicilio();
            domicilioOrg3.setCalle("Calle Organización 3");
            domicilioOrg3.setAltura("300");
            domicilioOrg3.setLocalidad("Localidad Organización 3");
            domicilioOrg3.setMunicipio("Municipio Organización 3");
            domicilioOrg3.setProvincia("Provincia Organización 3");

            // Domicilio Dueño 1
            Domicilio domicilioDue1 = new Domicilio();
            domicilioDue1.setCalle("Calle Dueño 1");
            domicilioDue1.setAltura("1000");
            domicilioDue1.setLocalidad("Localidad Dueño 1");
            domicilioDue1.setMunicipio("Municipio Dueño 1");
            domicilioDue1.setProvincia("Provincia Dueño 1");

            // Domicilio Dueño 2
            Domicilio domicilioDue2 = new Domicilio();
            domicilioDue2.setCalle("Calle Dueño 2");
            domicilioDue2.setAltura("2000");
            domicilioDue2.setLocalidad("Localidad Dueño 2");
            domicilioDue2.setMunicipio("Municipio Dueño 2");
            domicilioDue2.setProvincia("Provincia Dueño 2");

            // Domicilio Dueño 3
            Domicilio domicilioDue3 = new Domicilio();
            domicilioDue3.setCalle("Calle Dueño 3");
            domicilioDue3.setAltura("3000");
            domicilioDue3.setLocalidad("Localidad Dueño 3");
            domicilioDue3.setMunicipio("Municipio Dueño 3");
            domicilioDue3.setProvincia("Provincia Dueño 3");

            // Domicilio Dueño 4
            Domicilio domicilioDue4 = new Domicilio();
            domicilioDue4.setCalle("Calle Dueño 4");
            domicilioDue4.setAltura("4000");
            domicilioDue4.setLocalidad("Localidad Dueño 4");
            domicilioDue4.setMunicipio("Municipio Dueño 4");
            domicilioDue4.setProvincia("Provincia Dueño 4");

            // Domicilio Dueño 5
            Domicilio domicilioDue5 = new Domicilio();
            domicilioDue5.setCalle("Calle Dueño 5");
            domicilioDue5.setAltura("5000");
            domicilioDue5.setLocalidad("Localidad Dueño 5");
            domicilioDue5.setMunicipio("Municipio Dueño 5");
            domicilioDue5.setProvincia("Provincia Dueño 5");

            // Contacto 1 Dueño 1
            Contacto contacto1Due1 = new Contacto();
            contacto1Due1.setNombre("Nombre Contacto 1 Dueño 1");
            contacto1Due1.setApellido("Apellido Contacto 1 Dueño 1");
            contacto1Due1.setTelefono("1111 1111");
            contacto1Due1.setEmail("contacto1Due1@email.com");
            contacto1Due1.setMail("1");
            contacto1Due1.setWhatsapp("1");
            contacto1Due1.setSms("1");

            // Contacto 1 Dueño 2
            Contacto contacto1Due2 = new Contacto();
            contacto1Due2.setNombre("Nombre Contacto 1 Dueño 2");
            contacto1Due2.setApellido("Apellido Contacto 1 Dueño 2");
            contacto1Due2.setTelefono("1111 2222");
            contacto1Due2.setEmail("contacto1Due2@email.com");
            contacto1Due2.setMail("1");
            contacto1Due2.setWhatsapp("1");
            contacto1Due2.setSms("0");

            // Contacto 1 Dueño 3
            Contacto contacto1Due3 = new Contacto();
            contacto1Due3.setNombre("Nombre Contacto 1 Dueño 3");
            contacto1Due3.setApellido("Apellido Contacto 1 Dueño 3");
            contacto1Due3.setTelefono("1111 3333");
            contacto1Due3.setEmail("contacto1Due3@email.com");
            contacto1Due3.setMail("1");
            contacto1Due3.setWhatsapp("0");
            contacto1Due3.setSms("0");

            // Contacto 1 Dueño 4
            Contacto contacto1Due4 = new Contacto();
            contacto1Due4.setNombre("Nombre Contacto 1 Dueño 4");
            contacto1Due4.setApellido("Apellido Contacto 1 Dueño 4");
            contacto1Due4.setTelefono("1111 4444");
            contacto1Due4.setEmail("contacto1Due4@email.com");
            contacto1Due4.setMail("0");
            contacto1Due4.setWhatsapp("1");
            contacto1Due4.setSms("1");

            // Contacto 1 Dueño 5
            Contacto contacto1Due5 = new Contacto();
            contacto1Due5.setNombre("Nombre Contacto 1 Dueño 5");
            contacto1Due5.setApellido("Apellido Contacto 1 Dueño 5");
            contacto1Due5.setTelefono("1111 5555");
            contacto1Due5.setEmail("contacto1Due5@email.com");
            contacto1Due5.setMail("0");
            contacto1Due5.setWhatsapp("0");
            contacto1Due5.setSms("1");

            // Organización 1
            Organizacion organizacion1 = new Organizacion();
            organizacion1.setNombre("Organización 1");
            organizacion1.setDescripcion("Descripción Organización 1");
            organizacion1.setEmail("email@organizacion1.com");
            organizacion1.setTelefono("1111 1111");
            organizacion1.setDomicilio(domicilioOrg1);

            // Organización 2
            Organizacion organizacion2 = new Organizacion();
            organizacion2.setNombre("Organización 2");
            organizacion2.setDescripcion("Descripción Organización 2");
            organizacion2.setEmail("email@organizacion2.com");
            organizacion2.setTelefono("2222 2222");
            organizacion2.setDomicilio(domicilioOrg2);

            // Organización 3
            Organizacion organizacion3 = new Organizacion();
            organizacion3.setNombre("Organización 3");
            organizacion3.setDescripcion("Descripción Organización 3");
            organizacion3.setEmail("email@organizacion3.com");
            organizacion3.setTelefono("3333 3333");
            organizacion3.setDomicilio(domicilioOrg3);


/*
        // Login test
        Login test = new Login();
        test.setUsername("test");
        test.setPassword("test");

        // Login Dueño 1 - 5
        Login loginDue1 = new Login();
        loginDue1.setUsername("duenio1");
        loginDue1.setPassword("duenio1");

        Login loginDue2 = new Login();
        loginDue2.setUsername("duenio2");
        loginDue2.setPassword("duenio2");

        Login loginDue3 = new Login();
        loginDue3.setUsername("duenio3");
        loginDue3.setPassword("duenio3");

        Login loginDue4 = new Login();
        loginDue4.setUsername("duenio4");
        loginDue4.setPassword("duenio4");

        Login loginDue5 = new Login();
        loginDue5.setUsername("duenio5");
        loginDue5.setPassword("duenio5");
*/


            // Dueño 1
            Usuario duenio1 = new Usuario();
            duenio1.setNombre("Nombre Dueño 1");
            duenio1.setApellido("Apellido Dueño 1");
            duenio1.setNroDocumento("12345678");
            duenio1.setDomicilio(domicilioDue1);
            duenio1.setContactos(contacto1Due1);
            //duenio1.setLogin(loginDue1);
            duenio1.setUsername("duenio1");
            duenio1.setPassword("duenio1");

            // Dueño 2
            Usuario duenio2 = new Usuario();
            duenio2.setNombre("Nombre Dueño 2");
            duenio2.setApellido("Apellido Dueño 2");
            duenio2.setNroDocumento("12345678");
            duenio2.setDomicilio(domicilioDue2);
            duenio2.setContactos(contacto1Due2);
            //duenio2.setLogin(loginDue2);
            duenio2.setUsername("duenio2");
            duenio2.setPassword("duenio2");


            // Dueño 3
            Usuario duenio3 = new Usuario();
            duenio3.setNombre("Nombre Dueño 3");
            duenio3.setApellido("Apellido Dueño 3");
            duenio3.setNroDocumento("12345678");
            duenio3.setDomicilio(domicilioDue3);
            duenio3.setContactos(contacto1Due3);
            //duenio3.setLogin(loginDue3);
            duenio3.setUsername("duenio3");
            duenio3.setPassword("duenio3");


            // Dueño 4
            Usuario duenio4 = new Usuario();
            duenio4.setNombre("Nombre Dueño 4");
            duenio4.setApellido("Apellido Dueño 4");
            duenio4.setNroDocumento("12345678");
            duenio4.setDomicilio(domicilioDue4);
            duenio4.setContactos(contacto1Due4);
            //duenio4.setLogin(loginDue4);
            duenio4.setUsername("duenio4");
            duenio4.setPassword("duenio4");


            // Dueño 5
            Usuario duenio5 = new Usuario();
            duenio5.setNombre("Nombre Dueño 5");
            duenio5.setApellido("Apellido Dueño 5");
            duenio5.setNroDocumento("12345678");
            duenio5.setDomicilio(domicilioDue5);
            duenio5.setContactos(contacto1Due5);
            //duenio5.setLogin(loginDue5);
            duenio5.setUsername("duenio5");
            duenio5.setPassword("duenio5");


            // Mascota Registrada 1 Organización 1 Dueño 1
            MascotaRegistrada mascota1Due1 = new MascotaRegistrada();
            mascota1Due1.setOrganizacion(organizacion1);
            mascota1Due1.setTipoMascota(TipoMascota.GATO);
            mascota1Due1.setSexo(Sexo.HEMBRA);
            mascota1Due1.setTamanioMascota(TamanioMascota.CHICA);
            mascota1Due1.setNombre("Nombre Mascota 1 Dueño 1");
            mascota1Due1.setApodo("Apodo Mascota 1 Dueño 1");
            mascota1Due1.setDescripcion("Descripción Mascota 1 Dueño 1");
            mascota1Due1.setEdadAprox(EdadAproximada.CACHORRO);
            mascota1Due1.setDuenio(duenio1);
            mascota1Due1.setOrganizacion(organizacion1);
            mascota1Due1.setTokenRescate("1");

            // Mascota Registrada 1 Organización 1 Dueño 2
            MascotaRegistrada mascota1Due2 = new MascotaRegistrada();
            mascota1Due2.setOrganizacion(organizacion1);
            mascota1Due2.setTipoMascota(TipoMascota.PERRO);
            mascota1Due2.setSexo(Sexo.MACHO);
            mascota1Due2.setTamanioMascota(TamanioMascota.MEDIANA);
            mascota1Due2.setNombre("Nombre Mascota 1 Dueño 2");
            mascota1Due2.setApodo("Apodo Mascota 1 Dueño 2");
            mascota1Due2.setDescripcion("Descripción Mascota 1 Dueño 2");
            mascota1Due2.setEdadAprox(EdadAproximada.JOVEN);
            mascota1Due2.setDuenio(duenio2);
            mascota1Due1.setOrganizacion(organizacion1);
            mascota1Due2.setTokenRescate("2");

            // Mascota Registrada 1 Organización 1 Dueño 3
            MascotaRegistrada mascota1Due3 = new MascotaRegistrada();
            mascota1Due3.setOrganizacion(organizacion2);
            mascota1Due3.setTipoMascota(TipoMascota.GATO);
            mascota1Due3.setSexo(Sexo.MACHO);
            mascota1Due3.setTamanioMascota(TamanioMascota.CHICA);
            mascota1Due3.setNombre("Nombre Mascota 1 Dueño 3");
            mascota1Due3.setApodo("Apodo Mascota 1 Dueño 3");
            mascota1Due3.setDescripcion("Descripción Mascota 1 Dueño 3");
            mascota1Due3.setEdadAprox(EdadAproximada.ADULTO);
            mascota1Due3.setDuenio(duenio3);
            mascota1Due3.setTokenRescate("3");

            // Mascota Registrada 1 Organización 1 Dueño 4
            MascotaRegistrada mascota1Due4 = new MascotaRegistrada();
            mascota1Due4.setOrganizacion(organizacion2);
            mascota1Due4.setTipoMascota(TipoMascota.PERRO);
            mascota1Due4.setSexo(Sexo.HEMBRA);
            mascota1Due4.setTamanioMascota(TamanioMascota.GRANDE);
            mascota1Due4.setNombre("Nombre Mascota 1 Dueño 4");
            mascota1Due4.setApodo("Apodo Mascota 1 Dueño 4");
            mascota1Due4.setDescripcion("Descripción Mascota 1 Dueño 4");
            mascota1Due4.setEdadAprox(EdadAproximada.ABUELO);
            mascota1Due4.setDuenio(duenio4);
            mascota1Due4.setTokenRescate("4");

            // Mascota Registrada 1 Organización 1 Dueño 5
            MascotaRegistrada mascota1Due5 = new MascotaRegistrada();
            mascota1Due5.setOrganizacion(organizacion3);
            mascota1Due5.setTipoMascota(TipoMascota.PERRO);
            mascota1Due5.setSexo(Sexo.HEMBRA);
            mascota1Due5.setTamanioMascota(TamanioMascota.CHICA);
            mascota1Due5.setNombre("Nombre Mascota 1 Dueño 5");
            mascota1Due5.setApodo("Apodo Mascota 1 Dueño 5");
            mascota1Due5.setDescripcion("Descripción Mascota 1 Dueño 5");
            mascota1Due5.setEdadAprox(EdadAproximada.JOVEN);
            mascota1Due5.setDuenio(duenio5);
            mascota1Due5.setTokenRescate("5");

            // Intención adopción 1 Dueño 1
            Adoptar adoptar1Due1 = new Adoptar();
            adoptar1Due1.setOrganizacion(organizacion1);
            adoptar1Due1.setUsuario(duenio1);
            adoptar1Due1.setTipoMascota(TipoMascota.PERRO);
            adoptar1Due1.setSexo(Sexo.MACHO);
            adoptar1Due1.setTamanioMascota(TamanioMascota.CHICA);
            adoptar1Due1.setEdadAprox(EdadAproximada.CACHORRO);
            adoptar1Due1.setEstado("PENDIENTE");

            // Intención adopción 2 Dueño 1
            Adoptar adoptar2Due1 = new Adoptar();
            adoptar2Due1.setOrganizacion(organizacion1);
            adoptar2Due1.setUsuario(duenio1);
            adoptar2Due1.setTipoMascota(TipoMascota.GATO);
            adoptar2Due1.setSexo(Sexo.HEMBRA);
            adoptar2Due1.setTamanioMascota(TamanioMascota.CHICA);
            adoptar2Due1.setEdadAprox(EdadAproximada.JOVEN);
            adoptar2Due1.setEstado("PENDIENTE");

            // Dar en adopción 1 Dueño 1
            DarAdopcion darAdopcion1Due1 = new DarAdopcion();
            darAdopcion1Due1.setOrganizacion(organizacion1);
            darAdopcion1Due1.setUsuario(duenio1);
            darAdopcion1Due1.setTipoMascota(TipoMascota.PERRO);
            darAdopcion1Due1.setSexo(Sexo.HEMBRA);
            darAdopcion1Due1.setTamanioMascota(TamanioMascota.MEDIANA);
            darAdopcion1Due1.setEdadAprox(EdadAproximada.CACHORRO);
            darAdopcion1Due1.setEstado("PENDIENTE");

            // Dar en adopción 2 Dueño 1
            DarAdopcion darAdopcion2Due1 = new DarAdopcion();
            darAdopcion2Due1.setOrganizacion(organizacion1);
            darAdopcion2Due1.setUsuario(duenio1);
            darAdopcion2Due1.setTipoMascota(TipoMascota.GATO);
            darAdopcion2Due1.setSexo(Sexo.MACHO);
            darAdopcion2Due1.setTamanioMascota(TamanioMascota.CHICA);
            darAdopcion2Due1.setEdadAprox(EdadAproximada.JOVEN);
            darAdopcion2Due1.setEstado("PENDIENTE");


            // EntityManager
            // Begin transaction
            EntityManagerHelper.beginTransaction();
            // Domicilio Organización 1 - 3
            EntityManagerHelper.getEntityManager().persist(domicilioOrg1);
            EntityManagerHelper.getEntityManager().persist(domicilioOrg2);
            EntityManagerHelper.getEntityManager().persist(domicilioOrg3);
            // Domicilio Dueño 1 - 5
            EntityManagerHelper.getEntityManager().persist(domicilioDue1);
            EntityManagerHelper.getEntityManager().persist(domicilioDue2);
            EntityManagerHelper.getEntityManager().persist(domicilioDue3);
            EntityManagerHelper.getEntityManager().persist(domicilioDue4);
            EntityManagerHelper.getEntityManager().persist(domicilioDue5);
            // Contacto 1 - 5
            EntityManagerHelper.getEntityManager().persist(contacto1Due1);
            EntityManagerHelper.getEntityManager().persist(contacto1Due2);
            EntityManagerHelper.getEntityManager().persist(contacto1Due3);
            EntityManagerHelper.getEntityManager().persist(contacto1Due4);
            EntityManagerHelper.getEntityManager().persist(contacto1Due5);
            // Organización 1 - 3
            EntityManagerHelper.getEntityManager().persist(organizacion1);
            EntityManagerHelper.getEntityManager().persist(organizacion2);
            EntityManagerHelper.getEntityManager().persist(organizacion3);
/*        // Login test
        EntityManagerHelper.getEntityManager().persist(test);
        // Login Dueño 1 - 5
        EntityManagerHelper.getEntityManager().persist(loginDue1);
        EntityManagerHelper.getEntityManager().persist(loginDue2);
        EntityManagerHelper.getEntityManager().persist(loginDue3);
        EntityManagerHelper.getEntityManager().persist(loginDue4);
        EntityManagerHelper.getEntityManager().persist(loginDue5);*/
            // Dueño 1 - 5
            EntityManagerHelper.getEntityManager().persist(duenio1);
            EntityManagerHelper.getEntityManager().persist(duenio2);
            EntityManagerHelper.getEntityManager().persist(duenio3);
            EntityManagerHelper.getEntityManager().persist(duenio4);
            EntityManagerHelper.getEntityManager().persist(duenio5);
            // Mascota Registrada 1 - 5
            EntityManagerHelper.getEntityManager().persist(mascota1Due1);
            EntityManagerHelper.getEntityManager().persist(mascota1Due2);
            EntityManagerHelper.getEntityManager().persist(mascota1Due3);
            EntityManagerHelper.getEntityManager().persist(mascota1Due4);
            EntityManagerHelper.getEntityManager().persist(mascota1Due5);
            // Intención adopción 1 - 2 Dueño 1
            EntityManagerHelper.getEntityManager().persist(adoptar1Due1);
            EntityManagerHelper.getEntityManager().persist(adoptar2Due1);
            // Intención adopción 1 - 2 Dueño 1
            EntityManagerHelper.getEntityManager().persist(darAdopcion1Due1);
            EntityManagerHelper.getEntityManager().persist(darAdopcion2Due1);
            // Commit transaction
            EntityManagerHelper.commit();
        }


        // Mascota registrada
        @Test
        public void persistirMascotaRegistradaTest() {

            // Domicilio Organización
            Domicilio domicilioOrg = new Domicilio();
            domicilioOrg.setCalle("Calle Organización 1");
            domicilioOrg.setAltura("1234");

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
            domicilio.setAltura("1234");

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
            domicilioOrg.setAltura("1234");

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
            domicilio.setAltura("1234");

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
            domicilioOrg.setAltura("1234");

            // Organización
            Organizacion organizacion = new Organizacion();
            organizacion.setNombre("Organizacion 3");
            organizacion.setDescripcion("Descripción Organización 3");
            organizacion.setDomicilio(domicilioOrg);

            // Mascota
            MascotaPerdida mascota = new MascotaPerdida();
            mascota.setEdadAprox(EdadAproximada.ABUELO);
            mascota.setTipoMascota(TipoMascota.PERRO);
            mascota.setSexo(Sexo.MACHO);
            mascota.setTamanioMascota(TamanioMascota.MEDIANA);
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
            domicilio.setAltura("5678");

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



}

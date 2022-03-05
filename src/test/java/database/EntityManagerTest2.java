package database;

import db.EntityManagerHelper;

import domain.entities.usuarios.Usuario;
import org.junit.Test;



public class EntityManagerTest2 {


        @Test
        public void persistirOrganizacionTest() {
            /*
            // Domicilio Organización 1
            Domicilio domicilioOrg1 = new Domicilio();
            Municipio municipio = new Municipio();
            domicilioOrg1.setCalle("Calle Organización 1");
            domicilioOrg1.setAltura(100);

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
            */


            // Dueño 1
            Usuario duenio1 = new Usuario();
            duenio1.setNombre("Nombre Dueño 1");
            duenio1.setApellido("Apellido Dueño 1");
            duenio1.setNroDocumento("12345678");
            //duenio1.setDomicilio(domicilioDue1);
            //duenio1.setContactos(contacto1Due1);
            //duenio1.setLogin(loginDue1);
            duenio1.setUsername("duenio1");
            duenio1.setPassword("duenio1");

            // Dueño 2
            Usuario duenio2 = new Usuario();
            duenio2.setNombre("Nombre Dueño 2");
            duenio2.setApellido("Apellido Dueño 2");
            duenio2.setNroDocumento("12345678");
            //duenio2.setDomicilio(domicilioDue2);
            //duenio2.setContactos(contacto1Due2);
            //duenio2.setLogin(loginDue2);
            duenio2.setUsername("duenio2");
            duenio2.setPassword("duenio2");


            // Dueño 3
            Usuario duenio3 = new Usuario();
            duenio3.setNombre("Nombre Dueño 3");
            duenio3.setApellido("Apellido Dueño 3");
            duenio3.setNroDocumento("12345678");
            //duenio3.setDomicilio(domicilioDue3);
            //duenio3.setContactos(contacto1Due3);
            //duenio3.setLogin(loginDue3);
            duenio3.setUsername("duenio3");
            duenio3.setPassword("duenio3");


            // Dueño 4
            Usuario duenio4 = new Usuario();
            duenio4.setNombre("Nombre Dueño 4");
            duenio4.setApellido("Apellido Dueño 4");
            duenio4.setNroDocumento("12345678");
            //duenio4.setDomicilio(domicilioDue4);
            //duenio4.setContactos(contacto1Due4);
            //duenio4.setLogin(loginDue4);
            duenio4.setUsername("duenio4");
            duenio4.setPassword("duenio4");


            // Dueño 5
            Usuario duenio5 = new Usuario();
            duenio5.setNombre("Nombre Dueño 5");
            duenio5.setApellido("Apellido Dueño 5");
            duenio5.setNroDocumento("12345678");
            //duenio5.setDomicilio(domicilioDue5);
            //duenio5.setContactos(contacto1Due5);
            //duenio5.setLogin(loginDue5);
            duenio5.setUsername("duenio5");
            duenio5.setPassword("duenio5");
            EntityManagerHelper.beginTransaction();
            /*
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
            /*
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
             */
            // Commit transaction
            EntityManagerHelper.commit();
        }

}

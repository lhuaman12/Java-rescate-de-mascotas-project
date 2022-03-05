package database;

import db.EntityManagerHelper;
import domain.entities.domicilio.Domicilio;
import domain.entities.domicilio.Municipio;
import domain.entities.domicilio.Provincia;
import domain.entities.mascotas.Virtud;
import domain.entities.organizaciones.Configuraciones.CalidadImagen;
import domain.entities.organizaciones.Configuraciones.EstandarImagen;
import domain.entities.organizaciones.Configuraciones.TamanioImagen;
import domain.entities.organizaciones.Organizacion;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.organizaciones.PreguntasONG.OpcionDePregunta;
import domain.entities.organizaciones.PreguntasONG.TipoDePregunta;
import domain.entities.organizaciones.PreguntasONG.TipoDeRegistro;
import domain.entities.usuarios.Contacto;
import domain.entities.usuarios.Rol;
import domain.entities.usuarios.TipoDocumento;
import domain.entities.usuarios.Usuario;
import domain.repositories.Repositorio;
import domain.repositories.factories.FactoryRepositorio;
import org.junit.Test;

public class EntityManagerTest3 {
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
    // Persiste organizacion y sus preguntas
    @Test
    public void persistirPreguntasDeOrganizacionTest() {

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

    @Test

    public void crearUsuario(){

        Usuario duenio1 = new Usuario();
        Contacto contacto = new Contacto();
        Domicilio domicilio = new Domicilio();
        Municipio municipio = new Municipio();
        Provincia provincia = new Provincia();
        Rol rol = new Rol();

        duenio1.setNombre("Leandro");
        duenio1.setApellido("Rodriguez");
        duenio1.setTipoDocumento(TipoDocumento.DNI);
        duenio1.setNroDocumento("3000000");

        domicilio.setCodPostal("1646");
        domicilio.setCalle("Independencia");
        domicilio.setLongitud(0.001);
        domicilio.setLatitud(0.001);
        domicilio.setAltura(444);

        provincia.setNombre("Buenos Aires");

        rol.setNombre("duenio");

        municipio.setProvincia(provincia);
        duenio1.getContactos().add(contacto);
        duenio1.setDomicilio(domicilio);
        domicilio.setMunicipio(municipio);
        duenio1.getRoles().add(rol);

        duenio1.setUsername("duenio1");
        duenio1.setPassword("duenio1");

        EntityManagerHelper.beginTransaction();
        EntityManagerHelper.persist(duenio1);
        EntityManagerHelper.commit();

    }

}

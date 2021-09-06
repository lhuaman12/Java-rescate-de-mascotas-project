package InstanciadorCuentas;

import domain.InstanciadorCuentas.*;
import domain.InstanciadorMascotas.GeneradorQR;
import domain.InstanciadorMascotas.ImagenABytes;
import domain.InstanciadorMascotas.InstanciadorMascotas;
import domain.InstanciadorMascotas.NormalizadorFotos;
import domain.Mascotas.*;
import domain.Organizaciones.*;
import domain.Organizaciones.Caracterisiticas.*;
import domain.Organizaciones.Configuraciones.CalidadImagen;
import domain.Organizaciones.Configuraciones.ConfiguracionImagen;
import domain.Organizaciones.Configuraciones.TamanioImagen;
import domain.Plataforma.*;
import domain.Usuarios.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import password.*;

import java.awt.geom.Point2D;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class InstanciarCuentasTest {

    //defino para validacion password
    ValidatePassword validatePassword = new ValidatePassword();
    ValidatePasswordLength validatePasswordLength = new ValidatePasswordLength();
    ValidatePasswordNumber validatePasswordNumber = new ValidatePasswordNumber();
    ValidatePasswordLowercaseCharacter validatePasswordLowercaseCharacter = new ValidatePasswordLowercaseCharacter();
    ValidatePasswordUppercaseCharacter validatePasswordUppercaseCharacter = new ValidatePasswordUppercaseCharacter();
    ValidatePasswordSpecialCharacter validatePasswordSpecialCharacter = new ValidatePasswordSpecialCharacter();
    ValidatePasswordDictionary validatePasswordDictionary = new ValidatePasswordDictionary();

    ArrayList<PasswordCriteria> passwordCriteria = new ArrayList<>();

    //defino e instancio entidades generales
    private ValidadorUser validadorUser = ValidadorUser.getValidadorUser();
    private ValidadorPass validadorPass= ValidadorPass.getValidadorPass();
    private Plataforma plataforma =  Plataforma.getPlataforma();
    private GeneradorQR generadorQR = GeneradorQR.getGeneradorQR();
    private NormalizadorFotos normalizadorFotos = NormalizadorFotos.getNormalizadorFotos();


    //instancio validador de cuentas
    private ValidadorCuenta validadorCuenta = ValidadorCuenta.getValidadorCuenta().setValidadores(validadorUser,validadorPass);

    //genero instanciador de cuentas y mascotas
    private InstanciadorCuenta instanciadorCuenta = InstanciadorCuenta.getInstanciadorCuenta().setConfiguraciones(plataforma,validadorCuenta);

    //genero instanciador de mascotas
    private InstanciadorMascotas instanciadorMascotas = InstanciadorMascotas.getInstanciadorMascotas().setConfiguraciones(plataforma,normalizadorFotos,generadorQR);

    //defino personas
    private Duenio d1,d2,d3,d4;

    //defino contactos de personas
    private Contacto con1,con2,con3,con4,con5,con6;

    //seteo cuenta a plataforma usuarios existentes
    private Cuenta c1,c2;

    //instanciar fotos y coleccion de fotos de mascotas
    private Imagen img1_m1,img1_m2,img2_m1,img2_m2,img3_m1,img4_m1,img4_m2;

    //instancio arrray de fotos de mascota

    //defino mascotas
    private Mascota m1,m2,m3,m4;

    //defino organizaciones existente
    private Organizacion org1,org2,org3;

    //caracteristicas mascotas
    private Caracterisitica color_ojos,personalidad,color_primario,color_secundario,
        peso, castrada,vacuna_rabia,color_terciario;

    @Before
    public void init(){

        //Aagrego criterios para validar passwords
        passwordCriteria.add(validatePasswordLength);
        passwordCriteria.add(validatePasswordNumber);
        passwordCriteria.add(validatePasswordLowercaseCharacter);
        passwordCriteria.add(validatePasswordUppercaseCharacter);
        passwordCriteria.add(validatePasswordSpecialCharacter);
        passwordCriteria.add(validatePasswordDictionary);

        //seteo criterios de password al validador de passwords
        validatePassword.setPasswordCriteria(passwordCriteria);

        //seteo validador externo a mi validador
        validadorPass.setValidador(validatePassword);


        //instanciar contactos
        con1=new Contacto().nombre("Nicolás").apellido("González").telefono(1134084444).mail("nicolas.gonzalez15@gmail.com")
                .agregarFormaNotificacion(MetodoNotificacion.EMAIL)
                .agregarFormaNotificacion(MetodoNotificacion.WHATSAPP)
                .agregarFormaNotificacion(MetodoNotificacion.SMS);

        con2=new Contacto().nombre("Tito").apellido("González").telefono(1544342232).mail("tito.gonzalez15@gmail.com")
                .agregarFormaNotificacion(MetodoNotificacion.EMAIL)
                .agregarFormaNotificacion(MetodoNotificacion.WHATSAPP);
        con3=new Contacto().nombre("Francisco").apellido("Cibrian").telefono(1164322323).mail("pepecibrian15@gmail.com")
                .agregarFormaNotificacion(MetodoNotificacion.EMAIL)
                .agregarFormaNotificacion(MetodoNotificacion.WHATSAPP);

        con4=new Contacto().nombre("Ana").apellido("Campoy").mail("anamariacampoy@gmail.com")
                .agregarFormaNotificacion(MetodoNotificacion.EMAIL);

        con5=new Contacto().nombre("Pamela").apellido("Anderson").telefono(1577422322)
                .agregarFormaNotificacion(MetodoNotificacion.WHATSAPP)
                .agregarFormaNotificacion(MetodoNotificacion.SMS);

        con6=new Contacto().nombre("Sophia").apellido("Xeon").telefono(1544342223).mail("sophiemsmsmsms@gmail.com")
                .agregarFormaNotificacion(MetodoNotificacion.EMAIL)
                .agregarFormaNotificacion(MetodoNotificacion.SMS);

        //instanciar dueños
        d1= (Duenio) new Duenio().nombre("Nicolás").apellido("González").tipoDoc(Documento.DNI).nroDoc(35429785)
                .fechaNacimiento(LocalDate.of(1991,01,12))
                .agregarContacto(con1)
                .agregarContacto(con2);

        d2 = (Duenio) new Duenio().nombre("Pepito").apellido("Cibrian").tipoDoc(Documento.DNI).nroDoc(5432765)
                .fechaNacimiento(LocalDate.of(1945,04,06))
                .agregarContacto(con3)
                .agregarContacto(con4);

        d3 = (Duenio) new Duenio().nombre("Pamela").apellido("Anderson").tipoDoc(Documento.PASAPORTE).nroDoc(111121313)
                .fechaNacimiento(LocalDate.of(1970,05,21))
                .agregarContacto(con5);


        d4 = (Duenio) new Duenio().nombre("Sophie").apellido("Xeon").tipoDoc(Documento.PASAPORTE).nroDoc(123823112)
                .fechaNacimiento(LocalDate.of(1985,02,29))
                .agregarContacto(con6);


        //seteo cuentas en la plataforma de usuarios existentes
        c1 = new Cuenta("user1","NinoRlz145!!!");
        c2 = new Cuenta("user2","Passw$4!=");

        //instanciar imágenes de mascotas

        ImagenABytes imagenABytes = new ImagenABytes();

        Imagen img1_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img1_m2= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img2_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img2_m2= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img3_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img4_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img4_m2= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));


        //instanciar mascotas
        m1 = new Mascota().tipoMascota(TipoMascota.PERRO).nombre("Copito").apodo("Copi").edadAprox(5).sexo(Sexo.MACHO)
                .tamanioMascota(TamanioMascota.CHICA)
                .descripcion("Perro Yokshire, chiquito amable y ladrador")
                .agregarImagen(img1_m1)
                .agregarImagen(img1_m2);

        m2 = new Mascota().tipoMascota(TipoMascota.GATO).nombre("David").apodo("Chuchi").edadAprox(2).sexo(Sexo.MACHO)
                .tamanioMascota(TamanioMascota.CHICA)
                .descripcion("Gatito siames, con los ojos como bowie")
                .agregarImagen(img2_m1)
                .agregarImagen(img2_m2);

        m3 = new Mascota().tipoMascota(TipoMascota.PERRO).nombre("Dolores").apodo("Lola").edadAprox(12).sexo(Sexo.HEMBRA)
                .tamanioMascota(TamanioMascota.GRANDE)
                .descripcion("Labrador negra mayor, tiene la cola con manchas")
                .agregarImagen(img3_m1);

        m4 = new Mascota().tipoMascota(TipoMascota.PERRO).nombre("Pakistan").apodo("Paki").edadAprox(1).sexo(Sexo.MACHO)
                .tamanioMascota(TamanioMascota.MEDIANA)
                .descripcion("Cachorro buldog francés, muy juguetón")
                .agregarImagen(img4_m1)
                .agregarImagen(img4_m2);


        //instanciar caracteristicas de mascotas para una organización

        color_ojos=new Caracterisitica().descripcion("Color Ojos").valor(new TipoCadena("Azules"));
        personalidad= new Caracterisitica().descripcion("Personalidad").valor(new TipoCadena("Amigable"));
        peso= new Caracterisitica().descripcion("Peso").valor(new TipoDouble(5.80));
        castrada= new Caracterisitica().descripcion("Está Castrada").valor(new TipoBool(true));
        vacuna_rabia=new Caracterisitica().descripcion("Vacuna antirrábica").valor(new TipoBool(false));
        color_primario=new Caracterisitica().descripcion("Color primario").valor(new TipoColor(Color.BLANCO));
        color_secundario=new Caracterisitica().descripcion("Color secundario").valor(new TipoColor(Color.NEGRO));
        color_terciario=new Caracterisitica().descripcion("Color terciario").valor(new TipoColor(Color.MANCHADO));


        //instanciar organizaciones
        org1= new Organizacion().nombre("Felices Los Bichos")
                .direccion("La Pampa 1512, Villa Urquiza, CABA")
                .coordenadas(new Point2D.Double(-86.123123,-11.123123123))
                .agregarCaracteristica(color_ojos)
                .agregarCaracteristica(personalidad)
                .setConfiguracionImagen(new ConfiguracionImagen(CalidadImagen.ALTA,new TamanioImagen(500,1250)));

        org2= new Organizacion().nombre("Save Pets")
                .direccion("Araoz 1514, Palermo, CABA")
                .coordenadas(new Point2D.Double(-86.234234,-0.123123123))
                .agregarCaracteristica(personalidad)
                .agregarCaracteristica(peso)
                .agregarCaracteristica(castrada)
                .setConfiguracionImagen(new ConfiguracionImagen(CalidadImagen.BAJA,new TamanioImagen(200,350)));


        org3= new Organizacion().nombre("Bichejos")
                .direccion("Raffo 1514, Florencio Varela, BS.AS")
                .coordenadas(new Point2D.Double(-0.123123,-11.3455))
                .agregarCaracteristica(color_primario)
                .agregarCaracteristica(peso)
                .agregarCaracteristica(vacuna_rabia)
                .setConfiguracionImagen(new ConfiguracionImagen(CalidadImagen.MEDIA,new TamanioImagen(400,1000)));


        //agrego organizaciones a plataforma
           plataforma.agregarOrganizacion(org1);
           plataforma.agregarOrganizacion(org2);
           plataforma.agregarOrganizacion(org3);
    }

    @Test
    public void validarContenidoPlataforma() {
        plataforma.addCuenta(c2);
        Assert.assertEquals(1,plataforma.getCuentas().size());
    }

    @Test
    public void validarQueUserYPassSeanValidos() throws IOException {
        Assert.assertEquals(false,this.instanciadorCuenta.validarCreacionCuenta("ninorules","12345"));
        Assert.assertEquals(true,this.instanciadorCuenta.validarCreacionCuenta("ninorules2","NinoRlz13%"));
    }
    @Test
    public void validarUsuariosExistentesEnPlataforma() throws IOException {
        this.plataforma.addCuenta(c1);
        Assert.assertEquals(false,this.instanciadorCuenta.validarCreacionCuenta("user1","NinoRlz145!!!"));
        Assert.assertEquals(false,this.instanciadorCuenta.validarCreacionCuenta("user5","1234"));
        Assert.assertEquals(true,this.instanciadorCuenta.validarCreacionCuenta("ninorules","NinoRlz144!!!"));
    }
    @Test
    public void validarCrearCuentaEnPlataformaOK() throws IOException {
        this.instanciadorCuenta.crearCuenta("pepito","Pepito12!$",d2);
        Assert.assertEquals("pepito",this.d2.getCuenta().getUsername());
    }

    @Test
    public void validarONGSeleccionadaEnRegistroMascota(){

        Point2D.Double ubicacion = new Point2D.Double(-0.123123,-11.3455);
        Assert.assertEquals(org3,this.plataforma.getOrganizacionMasCercana(ubicacion));
    }
    @Test
    public void validarRegistroDeMascotasOK(){
        //seteo coleccion de mascotas para dueño 1
        List<Mascota> mascotasNino =  new ArrayList<>();
        mascotasNino.add(m1);
        mascotasNino.add(m2);
        d1.registrarMascotas(mascotasNino,org1);

        //seteo coleccion de mascotas para dueño 2
        List<Mascota> mascotasPepito =  new ArrayList<>();
        mascotasPepito.add(m3);
        d2.registrarMascotas(mascotasPepito,org2);

        //seteo coleccion de mascotas para dueño 2
        List<Mascota> mascotasPamela =  new ArrayList<>();
        mascotasPamela.add(m4);
        d3.registrarMascotas(mascotasPamela,org3);

        Assert.assertEquals(2,d1.getMascotas().size());
        Assert.assertEquals(1,d2.getMascotas().size());
        Assert.assertEquals(1,d3.getMascotas().size());

    }

    @Test
    public void validarGeneracionQRMascotaOK() throws Exception {
        TipoQR nuevoQr;
        generadorQR.setAtributosGeneradorQR(new Adapter.AdapterQR.ZXing.ZXingAdapter(), "https://patitas.com.ar/mascotaperdida=55@YHASD","src/main/resources/QR/QR.jpg");
        generadorQR.crear();
        nuevoQr= generadorQR.generarQR(m1);
        Assert.assertEquals("https://patitas.com.ar/mascotaperdida=55@YHASD",nuevoQr.getPath());
    }



}
package InstanciadorCuentas;

import QR.QR.FabricadorQR;
import domain.InstanciadorCuentas.*;
import domain.InstanciadorMascotas.GeneradorQR;
import domain.InstanciadorMascotas.ImagenABytes;
import domain.InstanciadorMascotas.InstanciadorMascotas;
import domain.InstanciadorMascotas.NormalizadorFotos;
import domain.Mascotas.*;
import domain.Organizaciones.*;
import domain.Organizaciones.Configuraciones.TamanioImagen;
import domain.Plataforma.*;
import domain.Usuarios.*;

import normalizador.Adapter.Adaptees.Adapter1;
import normalizador.NormalizadorDeImagen.NormalizarImagen;
import normalizador.Parametros.CalidadImagen;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import password.*;

import javax.imageio.ImageIO;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.*;
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
    private Dueño d1,d2,d3,d4;

    //defino contactos de personas
    private Contacto con1,con2,con3,con4,con5,con6;

    //seteo cuenta a plataforma usuarios existentes
    private Cuenta c1,c2;

    //instanciar fotos y coleccion de fotos de mascotas
    private Imagen img1_m1,img1_m2,img2_m1,img2_m2,img3_m1,img4_m1,img4_m2;

    //instancio arrray de fotos de mascota
    //

    //defino mascotas
    private Mascota m1,m2,m3,m4;

    //defino organizaciones existente
    private Organizacion org1,org2,org3;

    //defino caracteristicas de organizaciones y/o plataforma
    //caracteristicas imagen
    private TipoCadena calidad_img;
    private TipoNumero tamaño_img;
    //caracteristicas mascotas
    private TipoCadena color_ojos,personalidad;
    private TipoNumero peso;
    private TipoBool castrada;
   


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

        //instanciar dueños
        d1= new Dueño("Nico","Gonza",Documento.DNI,35429785,12011991, Genero.HOMBRE);
        d2 = new Dueño("Pepito","Cibrian",Documento.DNI,5432983,11011942,Genero.HOMBRE);
        d3 = new Dueño("Pamela","Anderson",Documento.PASAPORTE,11123234,4071956,Genero.MUJER);
        d4 = new Dueño("Sophie","Xeon",Documento.PASAPORTE,123823112,11009990, Genero.OTRO);

        //instanciar contactos
        con1=new Contacto("Nicolás","González",1134084444,"nicolas.gonzalez15@gmail.com");
        con2=new Contacto("Tito","González",1544342232,"tito.gonzalez15@gmail.com");
        con3=new Contacto("Francisco","Cibrian",1164322323,"pepecibrian15@gmail.com");
        con4=new Contacto("Ana ","Campoy",1125345355,"anamariacampoy@gmail.com");
        con5=new Contacto("Pamela","Anderson",1577422322,"pamanderson01@gmail.com");
        con6=new Contacto("Sophia","Xeon",1544342223,"sophiemsmsmsms@gmail.com");

        //determino listas de metodos de notificacion disponibles
        List<MetodoNotificacion> metodosDisponibles1= new ArrayList<>();
        metodosDisponibles1.add(MetodoNotificacion.EMAIL);
        metodosDisponibles1.add(MetodoNotificacion.SMS);
        metodosDisponibles1.add(MetodoNotificacion.WHATSAPP);

        List<MetodoNotificacion> metodosDisponibles2= new ArrayList<>();
        metodosDisponibles1.add(MetodoNotificacion.EMAIL);
        metodosDisponibles1.add(MetodoNotificacion.WHATSAPP);

        //agrego metodos de notificacion disponibles
        con1.setFormasNotificacion(metodosDisponibles1);
        con1.setFormasNotificacion(metodosDisponibles1);
        con3.setFormasNotificacion(metodosDisponibles1);
        con4.setFormasNotificacion(metodosDisponibles2);
        con5.setFormasNotificacion(metodosDisponibles1); 
        con6.setFormasNotificacion(metodosDisponibles2);

        //seteo contactos a los dueños que ya existen
        d1.agregarContacto(con1);
        d1.agregarContacto(con2);
        d2.agregarContacto(con3);
        d2.agregarContacto(con4);
        d3.agregarContacto(con5);
        d4.agregarContacto(con6);

        //seteo cuentas en la plataforma de usuarios existentes
        c1 = new Cuenta("user1","NinoRlz145!!!");
        c2 = new Cuenta("user2","Passw$4!=");

        //instanciar fotos de mascotas

        ImagenABytes imagenABytes = new ImagenABytes();

        Imagen img1_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img1_m2= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img2_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img2_m2= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img3_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img4_m1= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));
        Imagen img4_m2= new Imagen(imagenABytes.setPathAndReturn("src/main/resources/Normalizador/Test-02.jpg").traerBytes(),new TamanioImagen(300,200));


        //agregar fotos a coleccion de fotos de mascota

        List<Imagen> imagenesMascota_m1=new ArrayList<>();
        List<Imagen> imagenesMascota_m2=new ArrayList<>();
        List<Imagen> imagenesMascota_m3=new ArrayList<>();
        List<Imagen> imagenesMascota_m4=new ArrayList<>();


        imagenesMascota_m1.add(img1_m1);
        imagenesMascota_m1.add(img1_m2);
        imagenesMascota_m2.add(img2_m1);
        imagenesMascota_m2.add(img2_m2);
        imagenesMascota_m3.add(img3_m1);
        imagenesMascota_m4.add(img4_m1);
        imagenesMascota_m4.add(img4_m2);

        //instanciar mascotas
        m1 = new Mascota(TipoMascota.PERRO,"Copito","Copi",5,"Perro Yokshire, chiquito amable y ladrador", Sexo.MACHO);
        m2 = new Mascota(TipoMascota.GATO,"David","Chuchi",2,"Gatito siames, con los ojos como bowie", Sexo.MACHO);
        m3 = new Mascota(TipoMascota.PERRO,"Dolores","Lola",12,"Labrador negra mayor, tiene la cola con manchas",Sexo.HEMBRA);
        m4 = new Mascota(TipoMascota.PERRO,"Pakistan","Paki",1,"Cachorro buldog francés, muy juguetón",Sexo.MACHO);

        //agregar fotos a colección de mascotas
        m1.setFotos(imagenesMascota_m1);
        m2.setFotos(imagenesMascota_m2);
        m3.setFotos(imagenesMascota_m3);
        m4.setFotos(imagenesMascota_m4);

        //instanciar caracteristicas mascotas
        calidad_img = new TipoCadena();
        calidad_img.agregarDatosCaracteristica(Categoria.IMAGEN,TipoCaract.CALIDAD);
        calidad_img.setearValor("HD");

        tamaño_img=new TipoNumero();
        tamaño_img.agregarDatosCaracteristica(Categoria.IMAGEN,TipoCaract.TAMAÑO);
        tamaño_img.setearValor(200);

        color_ojos=new TipoCadena();
        color_ojos.agregarDatosCaracteristica(Categoria.MASCOTAS,TipoCaract.COLOR_OJOS);
        color_ojos.setearValor("AZUL");

        personalidad= new TipoCadena();
        personalidad.agregarDatosCaracteristica(Categoria.MASCOTAS,TipoCaract.PERSONALIDAD);
        personalidad.setearValor("Mansa");

        peso=new TipoNumero();
        peso.agregarDatosCaracteristica(Categoria.MASCOTAS,TipoCaract.PESO);
        peso.setearValor(15);

        castrada=new TipoBool();
        castrada.agregarDatosCaracteristica(Categoria.MASCOTAS,TipoCaract.CASTRADA);
        castrada.setearValor(true);

        //instanciar organizaciones
        org1= new Organizacion("Felices Los Bichos","La Pampa 1512, Villa Urquiza, CABA",new Point2D.Double(-86.123123,-11.123123123));
        org2= new Organizacion("Save Pets","Araoz 1514, Palermo, CABA",new Point2D.Double(-86.234234,-0.123123123));
        org3= new Organizacion("Bichejos","Raffo 1514, Florencio Varela, BS.AS",new Point2D.Double(-0.123123,-11.3455));

        //agregar caracteristicas a organizaciones
        org1.agregarCaracteristica(calidad_img);
        org1.agregarCaracteristica(tamaño_img);
        org1.agregarCaracteristica(color_ojos);
        org1.agregarCaracteristica(castrada);

        org2.agregarCaracteristica(calidad_img);
        org2.agregarCaracteristica(tamaño_img);
        org2.agregarCaracteristica(personalidad);

        org3.agregarCaracteristica(calidad_img);
        org3.agregarCaracteristica(tamaño_img);
        org3.agregarCaracteristica(color_ojos);
        org3.agregarCaracteristica(peso);

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
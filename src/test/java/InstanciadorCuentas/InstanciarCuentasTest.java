package InstanciadorCuentas;

import InstanciadorMascotas.GeneradorQR;
import InstanciadorMascotas.InstanciadorMascotas;
import InstanciadorMascotas.NormalizadorFotos;
import Mascotas.*;
import Organizaciones.*;
import Plataforma.*;
import Usuarios.*;
import InstanciadorCuentas.ValidadorCuenta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class InstanciarCuentasTest {

 //defino e instancio entidades generales
    private ValidadorUser validadorUser = ValidadorUser.getValidadorUser();
    private ValidadorPass validadorPass= ValidadorPass.getValidadorPass();
    private Plataforma plataforma =  Plataforma.getPlataforma();
    private GeneradorQR generadorQR = GeneradorQR.getGeneradorQR();
    private NormalizadorFotos normalizadorFotos = NormalizadorFotos.normalizadorFotos();

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
    private Foto foto1_m1,foto1_m2,foto2_m1,foto2_m2,foto2_m3,foto3_m1,foto4_m1,foto4_m2;

    //instancio arrray de fotos de mascota
    private List<Foto> fotosMascota_m1,fotosMascota_m2,fotosMascota_m3,fotosMascota_m4= new ArrayList<>();

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

        //seteo contactos a los dueños que ya existen
        d1.agregarContacto(con1);
        d1.agregarContacto(con2);
        d2.agregarContacto(con3);
        d2.agregarContacto(con4);
        d3.agregarContacto(con5);
        d4.agregarContacto(con6);

        //seteo cuentas en la plataforma de usuarios existentes
        c1 = new Cuenta("user1","paspas");
        c2 = new Cuenta("user2","paspas2");

        //instanciar fotos de mascotas
        foto1_m1=new Foto(20, Calidad.MEDIA);
        foto1_m2=new Foto(50,Calidad.ALTA);
        foto2_m1=new Foto(20, Calidad.BAJA);
        foto2_m2=new Foto(70,Calidad.STANDARD);
        foto2_m3=new Foto(45, Calidad.BAJA);
        foto3_m1=new Foto(100,Calidad.ALTA);
        foto4_m1=new Foto(10, Calidad.MEDIA);
        foto4_m2=new Foto(35,Calidad.ALTA);

        //agregar fotos a coleccion de fotos de mascota
        fotosMascota_m1.add(foto1_m1);
        fotosMascota_m1.add(foto1_m2);
        fotosMascota_m2.add(foto2_m1);
        fotosMascota_m2.add(foto2_m2);
        fotosMascota_m2.add(foto2_m3);
        fotosMascota_m3.add(foto3_m1);
        fotosMascota_m4.add(foto4_m1);
        fotosMascota_m4.add(foto4_m2);

        //instanciar mascotas
        m1 = new Mascota(TipoMascota.PERRO,"Copito","Copi",5,"Perro Yokshire, chiquito amable y ladrador", Sexo.MACHO);
        m2 = new Mascota(TipoMascota.GATO,"David","Chuchi",2,"Gatito siames, con los ojos como bowie", Sexo.MACHO);
        m3 = new Mascota(TipoMascota.PERRO,"Dolores","Lola",12,"Labrador negra mayor, tiene la cola con manchas",Sexo.HEMBRA);
        m4 = new Mascota(TipoMascota.PERRO,"Pakistan","Paki",1,"Cachorro buldog francés, muy juguetón",Sexo.MACHO);

        //agregar fotos a colección de mascotas
        m1.setFotos(fotosMascota_m1);
        m2.setFotos(fotosMascota_m2);
        m3.setFotos(fotosMascota_m3);
        m4.setFotos(fotosMascota_m4);

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


    }

    @Test
    public void validarContenidoPlataforma(){
        Assert.assertEquals(0,this.plataforma.getCuentas().size());
    }

    @Test
    public void validarQueUserYPassSeanValidos(){
        Assert.assertEquals(true,this.instanciadorCuenta.validarCreacionCuenta("ninorules","1234"));
        Assert.assertEquals(false,this.instanciadorCuenta.validarCreacionCuenta("ninorules2","1234X"));
    }
    @Test
    public void validarUsuariosExistentesEnPlataforma(){
        this.plataforma.addCuenta(c1);
        Assert.assertEquals(false,this.instanciadorCuenta.validarCreacionCuenta("user1","1234"));
        Assert.assertEquals(true,this.instanciadorCuenta.validarCreacionCuenta("user5","1234"));
        Assert.assertEquals(true,this.instanciadorCuenta.validarCreacionCuenta("ninorules","1234"));
    }
    @Test
    public void validarCrearCuentaEnPlataformaOK(){
        this.instanciadorCuenta.crearCuenta("pepito","spiderman123",d2);
        Assert.assertEquals("pepito",this.d2.getCuenta().getUser());
    }

    @Test
    public void validarONGSeleccionadaEnRegistroMascota(){
        this.instanciadorCuenta.crearCuenta("pepito","spiderman123",d2);
        Assert.assertEquals("pepito",this.d2.getCuenta().getUser());
    }


}

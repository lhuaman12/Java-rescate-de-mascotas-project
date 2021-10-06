package domain.entities.usuarios;

import domain.entities.domicilio.Domicilio;
import domain.entities.mascotas.*;
import domain.entities.publicaciones.PublicacionDeAdopcion;
import domain.entities.publicaciones.PublicacionIntencionAdopcion;
import domain.entities.publicaciones.PublicacionRescate;
import domain.entities.rescate.Rescate;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public class Usuario extends Persona{
    @Id
    private int id ;
    private LocalDate fechaDeNacimiento;
    private Domicilio domicilio;
    private TipoDocumento tipoDocumento;
    private String nroDeDocumento;

    private List<Contacto> contactos;
    private List<Rescate> rescates;
    private List<MascotaRegistrada> mascotaRegistradas;
    private List<PublicacionRescate> publicacionesRescate;
    private List<PublicacionDeAdopcion> publicacionesAdopcion;
    private List<PublicacionIntencionAdopcion> publicacionesIntAdopcion;
    static Integer cont = 0;

    // TODO: registro ?
    public Boolean registrarMascota(MascotaBasica mascota,String nombre, String apodo,
                                    LocalDate edadAproximada,List<CaracteristicasONG> caracteristicas
                                    ){

        RegistroDeMascotasHandler registro = RegistroDeMascotasHandler.getInstancia();

        MascotaRegistrada mascotaRegistrada = registro.registrarMascota(mascota,nombre,apodo,edadAproximada,caracteristicas);

        agregarMascota(mascotaRegistrada);

        return true;
    }

    public void agregarMascota(MascotaRegistrada mascotaRegistrada){
        this.mascotaRegistradas.add(mascotaRegistrada);
    }
    public void avisarMascotaPerdida(Rescate rescate){
        rescate.avisarDuenio();
    }
    public void publicarMascotaPerdida(PublicacionRescate publicacionRescate){
        publicacionesRescate.add(publicacionRescate);
    }
    public void publicarIntencionAdopcion(PublicacionIntencionAdopcion publicacion){
        //TODO:generar titulo,cuerpo y publicarse

        publicacionesIntAdopcion.add(publicacion);
    }
    public void publicarDarEnAdopcion(PublicacionDeAdopcion publicacion){
        publicacionesAdopcion.add(publicacion);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}

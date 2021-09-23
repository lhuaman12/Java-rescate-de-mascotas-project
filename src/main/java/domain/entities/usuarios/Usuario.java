package domain.entities.usuarios;

import domain.entities.mascotas.*;
import domain.entities.organizaciones.PreguntasONG.Atributo;
import domain.entities.rescate.Rescate;

import java.time.LocalDate;
import java.util.List;

public class Usuario extends Persona{

    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private Direccion direccion;
    private TipoDocumento tipoDocumento;
    private String nroDeDocumento;
    private List<Contacto> contactos;
    private List<Rescate> rescates;
    private List<MascotaRegistrada> mascotaRegistradas;

    // TODO: investigar clase builder
    public Boolean registrarMascota(MascotaBasica mascota,String nombre, String apodo,
                                    LocalDate edadAproximada,List<Atributo> caracteristicas
                                    ){
        RegistroDeMascotasHandler registro = RegistroDeMascotasHandler.getInstancia();
        List<FotoMascota> fotos = registro.normalizarFotos(mascota.getFotoMascotas());

        MascotaRegistrada mascotaRegistrada = new MascotaRegistrada(
                nombre,
                apodo,
                mascota.getTipoMascota(),
                edadAproximada,
                mascota.getTamanioMascota(),
                mascota.getTieneDiscapacidad(),
                mascota.getDescripcionDiscapacidad(),
                mascota.getSexo(),
                fotos
            );

        //fotos.forEach(foto->mascota.agregarFoto(registro.normalizarFoto(foto)));
        //mascota.agregarQR();
        mascotaRegistrada.agregarToken(registro.generarToken());
        agregarMascota(mascotaRegistrada);

        return true;
    }
    public void agregarMascota(MascotaRegistrada mascotaRegistrada){
        this.mascotaRegistradas.add(mascotaRegistrada);
    }
    public void avisarMascotaPerdida(Rescate rescate){
        rescate.avisarDuenio();
    }


}

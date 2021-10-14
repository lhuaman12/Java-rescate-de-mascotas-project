package domain.entities.mascotas;

import domain.entities.usuarios.Usuario;
import domain.entities.utils.QR.GeneradorQRRescate;
import domain.entities.utils.normalizador.Adapter.AdapterNormalizador;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

// singleton
public final class RegistroDeMascotasHandler {

    private static RegistroDeMascotasHandler registroDeMascotasHandler; // singleton
    private static AdapterNormalizador normalizadorImagen;
    private static GeneradorQRRescate generadorQR= new GeneradorQRRescate();

    public static RegistroDeMascotasHandler getInstancia() {
        if (registroDeMascotasHandler == null) {
            registroDeMascotasHandler = new RegistroDeMascotasHandler();
        }
        return registroDeMascotasHandler;
    }

    public FotoMascota normalizarFoto(FotoMascota foto){
            return null;
    }
    public List<FotoMascota> normalizarFotos(List<FotoMascota> fotos){
        return fotos.stream().map(foto->normalizarFoto(foto)).collect(Collectors.toList());
    }
    public MascotaRegistrada registrarMascota(MascotaBasica mascota, String nombre, String apodo,
                                              LocalDate edadAproximada, List<CaracteristicasONG> caracteristicas){
        List<FotoMascota> fotos = normalizarFotos(mascota.getFotoMascotas());
        MascotaRegistrada mascotaRegistrada = new MascotaRegistrada(
                nombre,
                apodo,
                mascota.getTipoMascota(),
                edadAproximada,
                mascota.getTamanioMascota(),
                caracteristicas,
                mascota.getTieneDiscapacidad(),
                mascota.getDescripcionDiscapacidad(),
                mascota.getSexo(),
                fotos
        );
        fotos.forEach(foto->mascota.agregarFoto(this.normalizarFoto(foto)));
        //mascotaRegistrada.agregarQR();TODO: realizar

        return mascotaRegistrada;
    }

    public String crearQR(MascotaRegistrada mascota, Usuario usuario) throws Exception {
        return generadorQR.crearQR(mascota,usuario);
    }


}


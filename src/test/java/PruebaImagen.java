import normalizador.Adapter.Adaptees.Adapter1;
import normalizador.NormalizadorDeImagen.NormalizarImagen;
import normalizador.Parametros.CalidadImagen;
import normalizador.Parametros.Imagen;
import normalizador.Parametros.TamanioImagen;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

public class PruebaImagen {

    public static void main(String[] args) throws IOException {
        BufferedImage foto = ImageIO.read(new File("src/main/resources/Normalizador/Test-01.jpg"));

        // convertir BufferedImage a byte[]
        ByteArrayOutputStream fotoBytesBuffer = new ByteArrayOutputStream();
        ImageIO.write(foto, "jpg", fotoBytesBuffer);
        byte[] fotoBytes = fotoBytesBuffer.toByteArray();

        // aca empieza la prueba
        Imagen imagen = new Imagen(fotoBytes,new TamanioImagen(300,300));
        NormalizarImagen normalizador = new NormalizarImagen(new Adapter1(),imagen, CalidadImagen.BAJA,new TamanioImagen(1080,720));
        Imagen imagenRespuesta = normalizador.normalizar();

        // convertir byte[] a BufferedImage para guardar

        InputStream is = new ByteArrayInputStream(imagenRespuesta.getDatosImagen());
        BufferedImage newBi = ImageIO.read(is);
        // guardando imagen
        ImageIO.write(newBi, "jpg", new File("src/main/resources/Normalizador/Post-Normalizador-01.jpg"));

    }


}


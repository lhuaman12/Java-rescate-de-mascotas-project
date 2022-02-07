package domain.entities.utils.normalizador.Adapter.Adaptees;

import domain.entities.mascotas.FotoMascota;
import domain.entities.organizaciones.Configuraciones.CalidadImagen;
import domain.entities.organizaciones.Configuraciones.TamanioImagen;
import domain.entities.utils.normalizador.Adapter.AdapterNormalizador;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class Adapter1 implements AdapterNormalizador {

    public void normalizarImagen(FotoMascota fotomascota, CalidadImagen calidadImagen, TamanioImagen tamanioImagen) {

            try{

            byte[] fotoBytes = fotomascota.traerBytesDesdePath();

            ByteArrayInputStream streamImg = new ByteArrayInputStream(fotoBytes);
            // Abrir imagen en buffer desde los bytes
            BufferedImage img = ImageIO.read(streamImg);
            //
            int imgAncho = img.getWidth();
            int imgAlto = img.getHeight();

            if (imgAncho * tamanioImagen.getAlto() < imgAlto* tamanioImagen.getAncho()) {
                fotomascota.setAncho(imgAncho* tamanioImagen.getAlto()/imgAlto);
                fotomascota.setAlto(tamanioImagen.getAlto()); // ?
            } else {
                fotomascota.setAlto(imgAlto* tamanioImagen.getAncho()/imgAncho);
                fotomascota.setAncho(tamanioImagen.getAncho());
            }

            //Convertirlo en clase imagen con otra escala
             Image resultingImage = img.getScaledInstance(fotomascota.getAncho(), fotomascota.getAlto(), Image.SCALE_DEFAULT);
            // crear un buffer con la imagen reescalada
            BufferedImage imagenBuffer = new BufferedImage(fotomascota.getAncho(), fotomascota.getAlto(), BufferedImage.TYPE_INT_RGB);
             imagenBuffer.getGraphics().drawImage(resultingImage, 0, 0, null);

            //ajustando la calidad (comprension)

            ByteArrayOutputStream buffer=null;
            switch(calidadImagen){
                case BAJA:
                    buffer = ajustarCalidad(imagenBuffer,1.0f);
                    break;
                case MEDIA:
                    buffer = ajustarCalidad(imagenBuffer,0.6f);
                    break;
                case ALTA:
                    buffer = ajustarCalidad(imagenBuffer,0.3f);
                    break;
            }

            // exportar a bytes
            // crear la imagen de respuesta;
                InputStream is = new ByteArrayInputStream(buffer.toByteArray());
                BufferedImage newBi = ImageIO.read(is);
                // guardando imagen
                ImageIO.write(newBi, "jpg", new File(fotomascota.getRuta()));
                fotomascota.setAncho(imagenBuffer.getWidth());
                fotomascota.setAlto(imagenBuffer.getHeight());


        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
    // el ajuste de calidad se basa en el metodo de comprension
    private ByteArrayOutputStream ajustarCalidad(BufferedImage imagen, float calidadImagen) throws IOException {
        ImageWriter writer;
        writer = ImageIO.getImageWritersByFormatName("jpeg").next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(calidadImagen);
        //
        ByteArrayOutputStream compressed = new ByteArrayOutputStream();
        ImageOutputStream outputStream = ImageIO.createImageOutputStream(compressed);

        writer.setOutput(outputStream);

        writer.write(null, new IIOImage(imagen, null, null), param);
        return compressed;
    }

}

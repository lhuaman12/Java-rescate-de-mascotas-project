package Adapter.Adaptees;

import Adapter.AdapterNormalizador;
import Parametros.CalidadImagen;
import Parametros.Imagen;
import Parametros.TamanioImagen;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Adapter1 implements AdapterNormalizador {

    public Imagen normalizarImagen(Imagen imagen, TamanioImagen tamanioImagen, CalidadImagen calidadImagen) {

        ByteArrayInputStream streamImg = new ByteArrayInputStream(imagen.getDatosImagen());

        try {
            // Abrir imagen en buffer desde los bytes
            BufferedImage img = ImageIO.read(streamImg);
            //
            int imgAncho = img.getWidth();
            int imgAlto = img.getHeight();

            if (imgAncho * tamanioImagen.getAlto() < imgAlto* tamanioImagen.getAncho()) {
              tamanioImagen.setAncho(imgAncho* tamanioImagen.getAlto()/imgAlto);
            } else {
                tamanioImagen.setAlto(imgAlto* tamanioImagen.getAncho()/imgAncho);
            }
            //Convertirlo en clase imagen con otra escala
             Image resultingImage = img.getScaledInstance(tamanioImagen.getAncho(), tamanioImagen.getAlto(), Image.SCALE_DEFAULT);
            // crear un buffer con la imagen reescalada
            BufferedImage imagenBuffer = new BufferedImage(tamanioImagen.getAncho(), tamanioImagen.getAlto(), BufferedImage.TYPE_INT_RGB);
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
            //ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            //ImageIO.write(imagenBuffer,"JPG",buffer);
            // crear la imagen de respuesta;
            Imagen imagenRespuesta = new Imagen(buffer.toByteArray(),tamanioImagen);

            return imagenRespuesta;
        }
        catch (IOException e){
            System.out.println("Error");
        }

        return null;
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

package domain.InstanciadorMascotas;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ImagenABytes {

    public String path;

    public ImagenABytes(String s) {
        this.path=s;
    }
    public ImagenABytes() {}

    public void setPath(String path) {
        this.path = path;
    }

    public ImagenABytes setPathAndReturn(String path) {
        this.path = path;
        return this;
    }

    public byte[] traerBytes() {
        try {
            BufferedImage foto = ImageIO.read(new File(path));
            ByteArrayOutputStream fotoBytesBuffer = new ByteArrayOutputStream();
            ImageIO.write(foto, "jpg", fotoBytesBuffer);
            byte[] fotoBytes = fotoBytesBuffer.toByteArray();
            return fotoBytes;
        } catch (IOException e) {
            System.out.println("Error al leer archivo");
            return null;
        }
    }
}

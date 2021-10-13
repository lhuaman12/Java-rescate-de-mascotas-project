package domain.entities.utils.QR.AdapteeQR;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;


import java.nio.file.Paths;

public class ZXing {

    public void crearQR(String mensaje, String pathFile) throws Exception {

        BitMatrix matrix = new MultiFormatWriter()
                .encode(mensaje, BarcodeFormat.QR_CODE, 500, 500);

        MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(pathFile));
    }
}

package QR;

import Adapter.AdapterQR.ZXing.ZXingAdapter;
import QR.QR.FabricadorQR;

public class PruebaQR {
    public static void main(String[] args) throws Exception {
        FabricadorQR fabricadorQR = new FabricadorQR(new ZXingAdapter(), "https://patitas.com.ar/mascotaperdida=55@YHASD","src/main/resources/QR/QR.jpg");
        fabricadorQR.crear();
    }

}

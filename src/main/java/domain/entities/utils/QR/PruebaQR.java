package domain.entities.utils.QR;

import Adapter.AdapterQR.ZXing.ZXingAdapter;
import domain.entities.utils.QR.QR.FabricadorQR;

public class PruebaQR {
    public static void main(String[] args) throws Exception {
        FabricadorQR fabricadorQR = new FabricadorQR(new ZXingAdapter(), "https://patitas.com.ar/mascotaperdida=55@YHASD","src/main/resources/Utils.QR/Utils.QR.jpg");
        fabricadorQR.crear();
    }

}

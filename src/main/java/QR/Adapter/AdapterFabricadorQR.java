package Adapter;

import com.google.zxing.WriterException;

import java.io.IOException;

public interface AdapterFabricadorQR {
    public void crear(String mensaje,String pathFile) throws Exception;
}

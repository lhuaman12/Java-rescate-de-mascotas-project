package domain.controllers.utils;

import org.apache.commons.io.IOUtils;
import spark.Request;

import javax.servlet.ServletException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class UtilsRequest {

    public static String ObtainAttributeByName(Request request, String name) throws ServletException, IOException {
        return IOUtils.toString(request.raw().getPart(name).getInputStream(), StandardCharsets.UTF_8);
    }

}

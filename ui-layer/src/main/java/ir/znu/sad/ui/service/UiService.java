package ir.znu.sad.ui.service;

import com.sun.net.httpserver.HttpServer;
import ir.znu.sad.utils.service.ServiceTools;

import java.io.IOException;

public class UiService {

    static int servicePortNumber=8000;

    public static void main(String[] args) throws IOException {
        HttpServer serviceHttpServer = ServiceTools.createHttpServer(
                servicePortNumber,
                "ir.znu.sad.ui",
                "ir.znu.sad.ui.service.handlers");
        serviceHttpServer.start();

        System.out.println(String.format( UiService.class.getName() +
                " jersey application server started and available at" +
                " %s\n", servicePortNumber));

    }

}

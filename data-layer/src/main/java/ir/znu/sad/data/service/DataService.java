package ir.znu.sad.data.service;

import com.sun.net.httpserver.HttpServer;
import ir.znu.sad.utils.service.ServiceTools;

import java.io.IOException;

public class DataService {

    static int servicePortNumber=8002;

    public static void main(String[] args) throws IOException {
        HttpServer serviceHttpServer = ServiceTools.createHttpServer(
                servicePortNumber,
                "ir.znu.sad.data.service",
                "ir.znu.sad.data.service.handlers");
        serviceHttpServer.start();

        System.out.println(String.format( DataService.class.getName() +
                " jersey application server started and available at" +
                " %s\n", servicePortNumber));

    }

}

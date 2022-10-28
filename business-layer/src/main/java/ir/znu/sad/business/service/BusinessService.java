package ir.znu.sad.business.service;

import com.sun.net.httpserver.HttpServer;
import ir.znu.sad.utils.service.ServiceTools;

import java.io.IOException;

public class BusinessService {

    static int servicePortNumber=8001;

    public static void main(String[] args) throws IOException {
        HttpServer serviceHttpServer = ServiceTools.createHttpServer(
                servicePortNumber,
                "ir.znu.sad.business",
                "ir.znu.sad.business.service.handlers");
        serviceHttpServer.start();

        System.out.println(String.format( BusinessService.class.getName() +
                " jersey application server started and available at" +
                " %s\n", servicePortNumber));

    }

}

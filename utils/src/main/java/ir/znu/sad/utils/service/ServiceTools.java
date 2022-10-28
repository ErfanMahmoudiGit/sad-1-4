package ir.znu.sad.utils.service;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

public class ServiceTools {

//    @SuppressWarnings("restriction")
    public static HttpServer createHttpServer(int portNumber,
                                               String rootHandlerPackageName,
                                               String handlerPackageName) throws IOException {

        ResourceConfig resourceConfig = new PackagesResourceConfig(
                rootHandlerPackageName,handlerPackageName
        );
        return HttpServerFactory.create(getURI(portNumber), resourceConfig);
    }

    private static URI getURI(int portNumber) {
        return UriBuilder.fromUri("http://" + getHostName() + "/").port(portNumber).build();
    }

    private static String getHostName() {
        String hostName = "localhost";
        try {
            hostName = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return hostName;
    }
}

package ir.znu.sad.utils.fetcher;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;

import java.io.*;
import java.net.*;
import java.util.Map;


public class HttpFetcher {

    private static final String USER_AGENT = "Mozilla/5.0";
    public static String sendGet(String url) throws IOException {
        return sendGet(url,false);
    }


    public static String sendGetWithTimeOut(String url, int timeout) throws IOException {
        return sendGet(url, false, timeout);
    }

    public static String sendGet(String url,boolean useProxy) throws IOException {
        return sendGet(url, useProxy, 120000);
    }

    public static String sendGet(String url,boolean useProxy, int timeout) throws IOException {

//        String url = "http://www.google.com/search?q=mkyong";

        HttpURLConnection con=null;

        if(useProxy) {
            try {
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 9150));//9150  8118
                con = (HttpURLConnection) new URL(url).openConnection(proxy);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if(con==null) {
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
        }

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        if(timeout > 0){
            con.setReadTimeout(timeout);
        }

        int responseCode = con.getResponseCode();
        System.out.println("Sending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    public static String sendGet(String url, String parameters, boolean printLog) throws Exception {
        return sendGetByteArray(url,parameters,printLog).toString();
    }

    public static StringBuffer sendGetByteArray(String url, String parameters, boolean printLog) throws Exception {

//        String url = "http://www.google.com/search?q=mkyong";

//        String encodedUrl = url + parameters.replaceAll(" ", "%20");//URLEncoder.encode(parameters);
        String encodedUrl = url + URLEncoder.encode(parameters, "utf-8").replace("+", "%20");
        URL obj = new URL(encodedUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setReadTimeout(120000);

        if (printLog) {
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'GET' request to URL : " + url + ",  encodedUrl :" + encodedUrl);
            System.out.println("Response Code : " + responseCode);
        }

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response;
    }

    public static String sendPost(String url, String jsonBody) throws IOException {
        return sendPost(url,jsonBody,120000);
    }

    public static String sendPost(String url, String jsonBody,int timeOut) throws IOException {
        // Create an instance of HttpClient.
        HttpClient client = new HttpClient();

//        client.getHttpConnectionManager().setParameter("http.protocol.content-charset", "UTF-8");

        // Create a method instance.
        PostMethod method = new PostMethod(url);

//        method.setRequestHeader("accept-charset", "UTF-8");

        method.setRequestBody(jsonBody);
        client.setTimeout(timeOut);


        method.addRequestHeader("Content-Type", "application/json;charset=utf-8");


        // Execute the method.
        int statusCode = client.executeMethod(method);

        if (statusCode != HttpStatus.SC_OK) {
            System.out.println("Method failed: " + method.getStatusLine());
            throw new HttpException("url: " + url + ". " + method.getStatusLine().toString());
        }

        // Read the response body.
        return new String(method.getResponseBody());

    }

}

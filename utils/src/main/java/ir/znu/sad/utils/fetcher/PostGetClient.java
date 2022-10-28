package ir.znu.sad.utils.fetcher;


import ir.znu.sad.utils.fetcher.HttpFetcher;

import java.io.IOException;


public abstract class PostGetClient {

    protected String ip;
    protected int port;


    public PostGetClient(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public String getHost() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public final String get(String remainUrl) throws IOException {
        return HttpFetcher.sendGet("http://"+ip+":"+port+remainUrl);
    }

    public final String get(String remainUrl,String parameter) throws Exception {
        return HttpFetcher.sendGet("http://"+ip+":"+port+remainUrl,parameter,false);
    }

    public final String get(String remainUrl,int timeOutMS) throws IOException {
        return HttpFetcher.sendGetWithTimeOut("http://"+ip+":"+port+remainUrl,timeOutMS);
    }

    public final String postJsonParam(String remainUrl,String jsonBody) throws IOException {
        String result = HttpFetcher.sendPost("http://" + ip + ":" + port + remainUrl, jsonBody);
        return result;
    }

}

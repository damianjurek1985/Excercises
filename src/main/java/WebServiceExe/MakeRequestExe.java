package WebServiceExe;

import com.sun.deploy.net.BasicHttpRequest;
import com.sun.deploy.net.HttpRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MakeRequestExe {

    public static void main(String[] args) {
        new MakeRequestExe().makeRequest(new BasicHttpRequest());
    }

    public void makeRequest(HttpRequest httpRequest, URL url) {
        try {
            httpRequest.doGetRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void makeRequest(HttpRequest httpRequest, String url) {
        try {
            makeRequest(httpRequest, new URL(url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public void makeRequest(HttpRequest httpRequest) {
        makeRequest(httpRequest, "http://google.com");
    }

}


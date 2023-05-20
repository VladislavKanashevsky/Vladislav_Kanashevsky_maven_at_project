package day21;

import org.apache.hc.core5.http.ParseException;

import java.io.IOException;
import java.net.URISyntaxException;

public class MyHttpClientRunner {
    public static void main(String[] args) throws URISyntaxException, IOException, ParseException {
        MyHttpClient myHttpClient = new MyHttpClient();
        //myHttpClient.httpGet();
        myHttpClient.search(new Search("",true));
    }
}

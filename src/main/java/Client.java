import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Client {
    public static void main(String[] args) {

        //Create a client instance
        CloseableHttpClient httpClient = HttpClients.createDefault();

        //Create a Get Request where you defined the url you want to open
        HttpGet httpGet = new HttpGet("https://www.google.com");

        try {
            //execute the request in the client
            CloseableHttpResponse response = httpClient.execute(httpGet);

            //Get the body of the request and transform it into a string
            String urlResponseString = EntityUtils.toString(response.getEntity());

            //Print it out to the console
            System.out.println(urlResponseString);

            //release the resources by closing the response
            response.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package url;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class RequestJson {
    public static String read(HttpURLConnection connection) {
        StringBuilder response = new StringBuilder();
        try (BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;
            while ((line = responseReader.readLine()) != null) {
                response.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response.toString();
    }

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://api.nbp.pl/api/exchangerates/rates/a/usd/2018-04-05/?forma");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");

        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode != 200) {
            String responseMessage = httpURLConnection.getResponseMessage();
            throw new Exception(String.format("[%d] %s", responseCode, responseMessage));
        }
        String jsonString = read(httpURLConnection);

        Object obj = JSONValue.parse(jsonString);
        JSONObject jsonObject = (JSONObject) obj;

        System.out.println(jsonString);
        String txt = jsonObject.get("rates").toString();
        int index = txt.indexOf("\"mid\":");
        txt = txt.substring(index+6);
        System.out.println(txt);
        String result = "";
        int i = 0;
        while (true) {
            if (txt.charAt(i) == ',' || txt.charAt(i) == '}') {
                break;
            }
            result += txt.charAt(i);
            i++;
        }

        System.out.println(result);

    }
}

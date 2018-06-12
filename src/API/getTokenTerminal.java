package API;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import org.json.JSONException;
import org.json.simple.JSONObject;
import API.TokenStorage;




public class getTokenTerminal{

	public getTokenTerminal(){

	}

	public static void main(String[] args) throws IOException {
		System.out.println("lala");

		String id = "23";
		String login = "dtu123";
		String password = "123456";
		String token = null;


		try {

		URL url = new URL("https://runnerrunner.herokuapp.com/rest/terminal/token");

		JSONObject data = new JSONObject();

		 data.put("id", id);
         data.put("login", login);
         data.put("password", password);

		HttpsURLConnection httpConnection  = (HttpsURLConnection) url.openConnection();


		// URL and parameters for the connection, This particulary returns the information passed
		httpConnection.setDoOutput(true);
        httpConnection.setRequestMethod("POST");
        httpConnection.setRequestProperty("Content-Type", "application/json");
        httpConnection.setRequestProperty("Accept", "application/json");




     // Writes the JSON parsed as string to the connection
        DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
        wr.write(data.toString().getBytes());
        Integer responseCode = httpConnection.getResponseCode();

        System.out.println("Response code is: " + responseCode );
        BufferedReader bufferedReader;

        // Creates a reader buffer
        if (responseCode > 199 && responseCode < 300) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
        }


        // To receive the response
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();

        token = content.toString();

        if(token.contains("token")){
           token = token.replace("{\"token\":\"","");
           token = token.replace("\"}\n","");
        }




		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(token);

	}

}
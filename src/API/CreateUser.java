package API;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import API.TokenStorage;
import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.omg.CORBA.RepositoryIdHelper;

public class CreateUser{

	public CreateUser() {

	}

	public boolean CreateUser(String username,String firstName, String middleName, String lastName, String email, String password) throws IOException {


		URL url = new URL("https://runnerrunner.herokuapp.com/rest/user");

		JSONObject data = new JSONObject();

		data.put("Username", username);
		data.put("firstName", firstName);
		data.put("middleName", middleName);
		data.put("lastName", lastName);
		data.put("email", email);
		data.put("password", password);

		HttpsURLConnection httpConnection = (HttpsURLConnection) url.openConnection();

		// URL and parameters for the connection, This particulary returns the
		// information passed
		httpConnection.setDoOutput(true);
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		httpConnection.setRequestProperty("Accept", "application/json");
		httpConnection.setRequestProperty("Authorization", "Bearer "+ TokenStorage.getInstance().getTerminalToken());

		// Writes the JSON parsed as string to the connection
		DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
		wr.write(data.toString().getBytes());
		Integer responseCode = httpConnection.getResponseCode();

		System.out.println("Response code is: " + responseCode);
		BufferedReader bufferedReader;

		// Creates a reader buffer
		if (responseCode == 200) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		} else {
			return false;
		}

		// To receive the response
		StringBuilder content = new StringBuilder();
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			content.append(line).append("\n");
		}
		bufferedReader.close();

		return true;
	}

}

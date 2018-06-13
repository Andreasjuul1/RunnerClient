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

public class TerminalTokenLogic {

	public TerminalTokenLogic() {

	}

	public Boolean getToken(String login, String password, String id) throws IOException {

		String token = null;

		URL url = new URL("https://runnerrunner.h"
				+ "erokuapp.com/rest/terminal/token");

		JSONObject data = new JSONObject();

		data.put("id", id);
		data.put("login", login);
		data.put("password", password);

		HttpsURLConnection httpConnection = (HttpsURLConnection) url.openConnection();

		// URL and parameters for the connection, This particulary returns the
		// information passed
		httpConnection.setDoOutput(true);
		httpConnection.setRequestMethod("POST");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		httpConnection.setRequestProperty("Accept", "application/json");

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

		token = content.toString();

		if (token.contains("token")) {
			token = token.replace("{\"token\":\"", "");
			token = token.replace("\"}\n", "");

			API.TokenStorage.getInstance().setTerminalToken(token);
		}

		return true;
	}

}

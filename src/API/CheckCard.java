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

public class CheckCard {

	public CheckCard() {

	}

	public Boolean getCard(String cardnumber) throws IOException {

		URL url = new URL("https://runnerrunner.herokuapp.com/rest/card?cardnumber="+cardnumber);

		HttpsURLConnection httpConnection = (HttpsURLConnection) url.openConnection();

		// URL and parameters for the connection, This particulary returns the
		// information passed
		httpConnection.setDoOutput(true);
		httpConnection.setRequestMethod("PUT");
		httpConnection.setRequestProperty("Content-Type", "application/json");
		httpConnection.setRequestProperty("Authorization", "Bearer "+ TokenStorage.getInstance().getTerminalToken());

		// Writes the JSON parsed as string to the connection
		DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
		Integer responseCode = httpConnection.getResponseCode();

		System.out.println("Response code is: " + responseCode + " Check Kort");
		BufferedReader bufferedReader;

		// Creates a reader buffer
		if (responseCode == 200) {
			bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
		} else {
			return false;
		}

		return true;
	}

}

package API;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import API.TokenStorage;
import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONObject;
import org.omg.CORBA.RepositoryIdHelper;

public class AttendingRun {

	public AttendingRun() {

	}

	public Boolean userAttending(String runID, String cardNumber) throws IOException
	{
		URL obj = new URL("https://runnerrunner.herokuapp.com/rest/run/attend?run_id=" + runID + "&cardnumber=" + cardNumber);

        HttpURLConnection con = (HttpURLConnection) obj.openConnection();


        // Setting request method
        con.setRequestMethod("GET");

        // setting authorizationtoken header
        con.setRequestProperty("Authorization", "Bearer " + TokenStorage.getInstance());
        final String USER_AGENT = "Mozilla/5.0";
        // setting user agent
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

        String inputLine;

        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null)
        {
            response.append(inputLine);
        }

        in.close();

        System.out.println(responseCode);

        if(responseCode == 200)
        {
            return true;
        }
        return false;
	}
}

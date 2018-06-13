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

	public Boolean userAttending(String runID) throws IOException {

					URL url = new URL("https://runnerrunner.herokuapp.com/rest/run/attend?run_id="+ runID);

					JSONObject data = new JSONObject();

								try{

					            data.put("RunID", runID);


					            // URL and parameters for the connection, This particulary returns the information passed
					            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
					            httpConnection.setDoOutput(true);
					            httpConnection.setRequestMethod("GET");
					            httpConnection.setRequestProperty("Content-Type", "application/json");
					            httpConnection.setRequestProperty("Authorization", "Bearer " + API.TokenStorage.getInstance().getUserToken());


					            // Writes the JSON parsed as string to the connection
					            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
					            wr.write(data.toString().getBytes());
					            Integer responseCode = httpConnection.getResponseCode();
					            System.out.println("Response code is: " + responseCode);
					            BufferedReader bufferedReader;

					            // Creates a reader buffer
					            if (responseCode > 199 && responseCode < 300) {
					                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
					            } else {
					                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
					                return false;
					            }

					            // To receive the response
					            StringBuilder content = new StringBuilder();
					            String line;
					            while ((line = bufferedReader.readLine()) != null) {
					                content.append(line).append("\n");
					            }
					            bufferedReader.close();
								}
								catch (Exception e)
									{
										System.out.println("Error Message");
										System.out.println(e.getClass().getSimpleName());
										System.out.println(e.getMessage());
									}
								return true;
							}
						}

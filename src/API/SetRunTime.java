package API;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.simple.JSONObject;

public class SetRunTime{

	public SetRunTime() {

	}

	public String setUserFinishTime(String runID, String end_time) throws IOException {

					URL url = new URL("https://runnerrunner.herokuapp.com/rest/run/time?run_id=" + runID + "&end_time=" + end_time);

					JSONObject data = new JSONObject();

								try{



					            // URL and parameters for the connection, This particulary returns the information passed
					            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
					            httpConnection.setDoOutput(true);
					            httpConnection.setRequestMethod("PUT");
					            httpConnection.setRequestProperty("Content-Type", "application/json");
					            httpConnection.setRequestProperty("Authorization", "Bearer " + API.TokenStorage.getInstance().getUserToken());


					            // Writes the JSON parsed as string to the connection
					            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
					            wr.write(data.toString().getBytes());
					            Integer responseCode = httpConnection.getResponseCode();
					            System.out.println("Response code is: " + responseCode + " Set run time");
					            BufferedReader bufferedReader;

					            // Creates a reader buffer
					            if (responseCode > 199 && responseCode < 300) {
					                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()));
					            } else {
					                bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream()));
					                return responseCode.toString();
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
								return setUserFinishTime(runID, end_time);
							}
						}

package API;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import API.TokenStorage;
import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;

import org.json.simple.JSONObject;
import org.omg.CORBA.RepositoryIdHelper;

public class CreateUser{

	public CreateUser() {

	}

	public boolean CreateaUser(String username,String firstName, String middleName, String lastName, String email, String password) throws IOException {


		URL url = new URL("https://runnerrunner.herokuapp.com/rest/user");

		JSONObject data = new JSONObject();

					try{

		            	data.put("username", username);
		        		data.put("first_name", firstName);
		        		data.put("middle_name", middleName);
		        		data.put("last_name", lastName);
		        		data.put("mail", email);
		        		data.put("password", password);


		            // URL and parameters for the connection, This particulary returns the information passed
		            HttpURLConnection httpConnection  = (HttpURLConnection) url.openConnection();
		            httpConnection.setDoOutput(true);
		            httpConnection.setRequestMethod("POST");
		            httpConnection.setRequestProperty("Content-Type", "application/json");
		            httpConnection.setRequestProperty("Accept", "application/json");


		            // Writes the JSON parsed as string to the connection
		            DataOutputStream wr = new DataOutputStream(httpConnection.getOutputStream());
		            wr.write(data.toString().getBytes());
		            Integer responseCode = httpConnection.getResponseCode();
		            System.out.println("Response code is: " + responseCode + " bruger tilføjet");
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

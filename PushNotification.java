import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
public class Push {

	public static void main(String[] args) throws Exception {
		
		
		String url = "https://android.googleapis.com/gcm/send";
		String API_ACCESS_KEY="YOUR_API_KEY";
	
		String registrationIds="DEVICE_REGISTRATION_ID";

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");

		con.setRequestProperty("Authorization", "key="+API_ACCESS_KEY);
		
		con.setRequestProperty("Content-Type", "application/json");
		
		String urlParameters = "{\"data\":{\"message\":\"Sample Message\"},\"registration_ids\":[\""+registrationIds+"\"]}";

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println(response.toString());
		
	}
}

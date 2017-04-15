import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;

import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
public class Push {

	public static void main(String[] args) throws Exception {
		
		
		String url = "https://android.googleapis.com/gcm/send";
		String API_ACCESS_KEY="AIzaSyAavPj-wjgeAGBl6QTcJyremlCTeEtxG0c";
		String registrationIds[]=new String[1];
		registrationIds[0]="cV0Z7xnjG4g:APA91bEZhqZyPNjIK_xtb-3d169pHYfdIGgoTxAyC7F34pkWkoe4RSTZqY07PAMmJbL6ZhalFrFZOjSSQPV7-0o1iZsKA5mEio2ptEmomnmjUJ33mtseg2yYBOtNA-JsKeovwfHugLn6";

		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");

		con.setRequestProperty("Authorization", "key="+API_ACCESS_KEY);
		
		con.setRequestProperty("Content-Type", "application/json");
		
		String urlParameters = "{\"data\":{\"message\":\"Sample Message\"},\"registration_ids\":[\""+registrationIds[0]+"\"]}";

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

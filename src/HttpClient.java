import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class HttpClient
{
	private String host;
	
	public HttpClient(String host) 
	{
		this.host = host;
	}
	
	public JSONArray getJson() throws Exception
	{
		URL url = new URL(host);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		
		JSONParser parser = new JSONParser();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		Object obj = parser.parse(in); //Unsure if this works. Might need to do in.readLine() to get the string and use .parse(String s)
		JSONArray response = (JSONArray) obj;
		
		in.close();
		
		return response;
	}
	
	public void sendEvent(String JsonUrlParam) throws Exception
	{
		URL url = new URL(host);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("POST");
		
		con.setDoOutput(true);
		DataOutputStream sendData = new DataOutputStream(con.getOutputStream());
		sendData.writeBytes(JsonUrlParam);
		sendData.flush();
		sendData.close();
		
//		Bellow if we want response and return the response.
		
//		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//		JSONParser parser = new JSONParser();
//		
//		Object obj = parser.parse(in); //Unsure if this works. Might need to do in.readLine() to get the string and use .parse(String s)
//		JSONArray response = (JSONArray) obj;
//		
//		in.close();
//		
//		return response;
		
	}
}

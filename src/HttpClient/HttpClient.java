package HttpClient;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class HttpClient
{
	private String host;
	
	public HttpClient(String host) 
	{
		this.host = host;
	}
	
	public boolean testConnection()
	{
		URL url;
		try 
		{
			url = new URL(host + "/Check");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			boolean result = Integer.parseInt(in.readLine()) == 123;
			in.close();
			
			if(!result) throw new UnexpectedResponseException();
			
			return result;
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
			return false;
		}
		catch (UnexpectedResponseException e) 
		{
			e.printStackTrace();
			return false;
		}
	}
	
	private JSONArray returnResponse(HttpURLConnection con) throws IOException, ParseException 
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(in); //Unsure if this works. Might need to do in.readLine() to get the string and use .parse(String s)
		JSONArray response = (JSONArray) obj;
		
		in.close();
		return response;
	}
	
	/* Handles POST events, where a response from server is expected; Example: Start simulation */
	public String sendPOST(String UrlParam) throws Exception
	{
		URL url = new URL(host + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(false);
		con.connect();
		
		Exception NoSuchSimulationException = null;
		if (con.getResponseCode() == 404) throw NoSuchSimulationException;
		
//		DataOutputStream sendData = new DataOutputStream(con.getOutputStream());
//		sendData.writeBytes(JsonUrlParam);
//		sendData.flush();
//		sendData.close();
		
		return con.getHeaderField("Id");
	}
	
	/* Handles GET events, where response from server is expected; Example: getData */
	public JSONArray sendGET(String UrlParam) throws Exception
	{
		URL url = new URL(host + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(false);
		con.connect();
		
		Exception NoSuchSimulationException = null;
		if (con.getResponseCode() == 404) throw NoSuchSimulationException;
		
		return returnResponse(con);
	}
	
	/* Handles PUT events; */
	public void sendPUT(String UrlParam, String JsonData) throws Exception
	{
		URL url = new URL(host + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		con.setDoOutput(true);
		
		DataOutputStream sendData = new DataOutputStream(con.getOutputStream());
		sendData.writeBytes(JsonData);
		sendData.flush();
		sendData.close();
		
		con.connect();
	}
	
	/* Handles DELETE events; */
	public void sendDelete(String UrlParam) throws Exception
	{
		URL url = new URL(host + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("DELETE");
		con.setDoOutput(false);
		con.connect();
		
		Exception NoSuchSimulationException = null;
		if (con.getResponseCode() == 404) throw NoSuchSimulationException;
	}
	

}

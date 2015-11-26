package HttpClient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Exceptions.NoSuchSimulationException;
import Exceptions.UnexpectedResponseException;

public class HttpClient
{
	private String hostname;
	
	public HttpClient(String hostname) 
	{
//		if(!hostname.contains("http://")) hostname = "http://" + hostname;
		this.hostname = hostname;
	}
	
	public boolean testConnection()
	{
		URL url;
		try 
		{
			url = new URL(hostname + "/Check");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			boolean result = in.readLine().contains("123");
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
		System.out.println(con.getContentType());
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		JSONParser parser = new JSONParser();
		
		System.out.println(in.readLine());
		
		Object obj = parser.parse(in); //Unsure if this works. Might need to do in.readLine() to get the string and use .parse(String s)
		JSONArray response = (JSONArray) obj;
		
		in.close();
		return response;
	}
	
	private void sendEmptyDataStream(HttpURLConnection con) throws IOException {
		DataOutputStream sendData = new DataOutputStream(con.getOutputStream());
		sendData.writeBytes("");
		sendData.flush();
		sendData.close();
	}
	
	/* Handles POST events, where a response from server is expected; Example: Start simulation */
	public String sendPOST(String UrlParam) throws Exception
	{
		URL url = new URL(hostname + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		
		con.setDoOutput(true);
		sendEmptyDataStream(con);
		
		if (con.getResponseCode() == 404) throw new NoSuchSimulationException();
		
		return con.getHeaderField("Location");
	}


	
	/* Handles GET events, where response from server is expected; Example: getData */
	public JSONArray sendGET(String UrlParam) throws Exception
	{
		URL url = new URL(hostname + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setDoOutput(false);
		
		if (con.getResponseCode() == 404) throw new NoSuchSimulationException();
		
		return returnResponse(con);
	}
	
	/* Handles PUT events; 
	 * Require description of how JsonData should be structured.
	 * */
	public void sendPUT(String UrlParam, String JsonData) throws Exception
	{
		URL url = new URL(hostname + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("PUT");
		con.setDoOutput(true);
		
		
		
		DataOutputStream sendData = new DataOutputStream(con.getOutputStream());
		sendData.writeBytes(JsonData);
		sendData.flush();
		sendData.close();
			
		System.out.println(con.getResponseCode());
		
		con.connect();
	}
	
	/* Handles DELETE events; */
	public void sendDELETE(String UrlParam) throws Exception
	{
		URL url = new URL(hostname + "/" + UrlParam);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("DELETE");
		con.setDoOutput(false);
		
		if (con.getResponseCode() == 404) throw new NoSuchSimulationException();
	}
	

}

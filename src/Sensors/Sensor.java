package Sensors;
import HttpClient.HttpClient;

public abstract class Sensor 
{
	protected String urlPath;
	protected String sessionID;
	protected HttpClient connection;
	
	public Sensor(String hostname, String urlPath)
	{
		this.connection = new HttpClient(hostname);
		this.urlPath = urlPath;
	}
	
	public abstract void getData() throws Exception;

	public void startSimulation() throws Exception 
	{
		sessionID = connection.sendPOST(urlPath);
	}
	
	public void endSimulation() throws Exception 
	{
		connection.sendDELETE(urlPath + "/" + sessionID);
	}
}

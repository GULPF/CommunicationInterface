package Sensors;
import Exceptions.NoSessionInProgressException;
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
	
	public abstract void updatePosition(double longitude, double latitude) throws Exception;

	public void startSimulation() throws Exception 
	{
		sessionID = connection.sendPOST(urlPath);
	}
	
	public void endSimulation() throws Exception 
	{
		if(sessionID == null) throw new NoSessionInProgressException();
		
		connection.sendDELETE(urlPath + "/" + sessionID);
		sessionID = null;
	}
}

package Sensors;
import HttpClient.HttpClient;

public abstract class Sensor 
{
	protected int sessionID;
	protected HttpClient connection;
	
	public Sensor(String hostname)
	{
		connection = new HttpClient(hostname);
	}
	
	public abstract void getData() throws Exception;
	public abstract void startSimulation() throws Exception;
	public abstract void endSimulation() throws Exception;
}

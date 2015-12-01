package Sensors;
import Exceptions.ConnectionFailedException;
import Exceptions.NoSessionInProgressException;
import Exceptions.NoSuchSimulationException;
import HttpClient.HttpClient;

abstract class Sensor 
{
	protected String sensorPath;
	protected String sessionID;
	protected HttpClient connection;

	public Sensor(String uri, String sensorPath)
	{
		this.connection = new HttpClient(uri);
		this.sensorPath = sensorPath;
	}
	
	public abstract SensorData fetchData() throws ConnectionFailedException, NoSuchSimulationException;
	
	public abstract void updatePosition(double longitude, double latitude) throws ConnectionFailedException, NoSuchSimulationException;

	public void startSimulation() throws ConnectionFailedException 
	{
		sessionID = connection.sendPOST(sensorPath);
	}
	
	public void endSimulation() throws Exception 
	{
		if(sessionID == null) throw new NoSessionInProgressException();
		
		connection.sendDELETE(sensorPath + "/" + sessionID);
		sessionID = null;
	}
}

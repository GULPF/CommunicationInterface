package Sensors;

import java.util.HashMap;

import org.json.JSONObject;

import Exceptions.ConnectionFailedException;
import Exceptions.NoSuchSimulationException;

public class I27API extends Sensor 
{
	private JSONObject lastReceivedData;
	
	public I27API(String uri) 
	{
		super(uri, "sensors/i27");
	}

	@Override
	public SensorData fetchData() throws ConnectionFailedException, NoSuchSimulationException 
	{
		if(sessionID == null) throw new NoSuchSimulationException();
		lastReceivedData = super.connection.sendGET(sensorPath + "/" + sessionID);
		return new I27Data(lastReceivedData);
	}

	@Override
	public void updatePosition(double longitude, double latitude) throws ConnectionFailedException, NoSuchSimulationException 
	{
		HashMap<String, Double> pos = new HashMap<String, Double>();
		pos.put("Longitude", longitude);
		pos.put("Latitude", latitude);
		pos.put("Altitude", 0.0);
		lastReceivedData.put("Position", pos);
		connection.sendPUT(sensorPath + "/" + sessionID, lastReceivedData.toString());	
	}

}

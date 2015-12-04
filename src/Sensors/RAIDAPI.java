package Sensors;

import java.util.HashMap;

import org.json.JSONObject;

import Exceptions.ConnectionFailedException;
import Exceptions.NoSuchSimulationException;

public class RAIDAPI extends Sensor
{
	private JSONObject lastReceivedData;
	
	public RAIDAPI(String uri) 
	{
		super(uri, "sensors/raid");
	}

	@Override
	public SensorData fetchData() throws ConnectionFailedException, NoSuchSimulationException 
	{
		if(sessionID == null) throw new NoSuchSimulationException();
		lastReceivedData = super.connection.sendGET(sensorPath + "/" + sessionID);
		return new RAIDData(lastReceivedData);
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

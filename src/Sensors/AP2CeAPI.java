package Sensors;

import java.util.HashMap;

import org.json.JSONObject;

import Exceptions.ConnectionFailedException;
import Exceptions.NoSuchSimulationException;

public class AP2CeAPI extends Sensor 
{
	private JSONObject lastReceivedData;
	
	public AP2CeAPI(String uri) 
	{
		super(uri, "sensors/ap2ce");
	}
	
	@Override
	public AP2CeData fetchData() throws ConnectionFailedException, NoSuchSimulationException
	{	
		if(sessionID == null) throw new NoSuchSimulationException();
		lastReceivedData = super.connection.sendGET(sensorPath + "/" + sessionID);
		return new AP2CeData(lastReceivedData);
	}
}

package Sensors;

import java.util.HashMap;

import org.json.JSONObject;

import Exceptions.ConnectionFailedException;
import Exceptions.NoSuchSimulationException;

public class I27API extends Sensor 
{
	public I27API(String uri) 
	{
		super(uri, "sensors/i27");
	}

	@Override
	public I27Data fetchData() throws ConnectionFailedException, NoSuchSimulationException 
	{
		if(sessionID == null) throw new NoSuchSimulationException();
		return new I27Data(super.connection.sendGET(sensorPath + "/" + sessionID));
	}
}

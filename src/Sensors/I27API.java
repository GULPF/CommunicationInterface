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
	
	/** Sends a 'reset accumulated dose rate' event to the server
	 * @throws ConnectionFailedException if a connection to the server was not established
	 * @throws NoSuchSimulationException if this object is not associated with a sensor on the server
	 */
	public void resetAccumulatedDoseRate() throws ConnectionFailedException, NoSuchSimulationException
	{
		String jsonEvent = "{"
				+ " \"Command\": \"reset accumulated dose rate\","
				+ " \"Sensor\": \"i27\","
				+ " \"Id\": \"" + sessionID + "\""
				+ "}";
		connection.sendPOSTEvent("sensors/event", jsonEvent);
	}
}

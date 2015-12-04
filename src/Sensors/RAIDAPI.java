package Sensors;

import Exceptions.ConnectionFailedException;
import Exceptions.NoSuchSimulationException;

public class RAIDAPI extends Sensor
{
	
	public RAIDAPI(String uri) 
	{
		super(uri, "sensors/raid");
	}

	@Override
	public RAIDData fetchData() throws ConnectionFailedException, NoSuchSimulationException 
	{
		if(sessionID == null) throw new NoSuchSimulationException();
		return new RAIDData(super.connection.sendGET(sensorPath + "/" + sessionID));
	}
}

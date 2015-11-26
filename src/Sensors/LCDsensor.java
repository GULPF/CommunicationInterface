package Sensors;

import Exceptions.NoSessionInProgressException;

public class LCDsensor extends Sensor 
{
	public LCDdata data;
	public LCDsensor(String hostname) 
	{
		super(hostname, "sensors/lcd");
	}

	@Override
	public void getData() throws Exception 
	{
		if(sessionID == null) throw new NoSessionInProgressException();
		data = new LCDdata(super.connection.sendGET(urlPath + "/" + sessionID));
	}
	
	@Override
	public void endSimulation() throws Exception 
	{
		super.endSimulation();
		data = null;
	}
}

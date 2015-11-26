package Sensors;

import Exceptions.NoSessionInProgressException;

public class AP2Csensor extends Sensor 
{
	public AP2Cdata data;
	public AP2Csensor(String hostname) 
	{
		super(hostname, "sensors/ap2ce");
	}

	@Override
	public void getData() throws Exception 
	{	
		if(sessionID == null) throw new NoSessionInProgressException();
		data = new AP2Cdata(super.connection.sendGET(urlPath + "/" + sessionID));
	}
	
	@Override
	public void endSimulation() throws Exception 
	{
		super.endSimulation();
		data = null;
	}
}

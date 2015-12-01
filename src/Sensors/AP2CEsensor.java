package Sensors;

import Exceptions.NoSessionInProgressException;

public class AP2CEsensor extends Sensor 
{
	public AP2CEdata data;
	
	public AP2CEsensor(String hostname) 
	{
		super(hostname, "sensors/ap2ce");
	}
	
	@Override
	public void getData() throws Exception 
	{	
		if(sessionID == null) throw new NoSessionInProgressException();
		data = new AP2CEdata(super.connection.sendGET(urlPath + "/" + sessionID));
	}
	
	@Override
	public void endSimulation() throws Exception 
	{
		super.endSimulation();
		data = null;
	}

	@Override
	public void updatePosition(double longitude, double latitude) throws Exception 
	{
		data.setPosition(latitude, longitude);
		connection.sendPUT(urlPath + "/" + sessionID, data.toString());		
	}
}

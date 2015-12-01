package Sensors;

import Exceptions.NoSessionInProgressException;

public class LCDsensor extends Sensor 
{
	public LCDdata data;
	public static final int CWA = 0;
	public static final int TIC = 1;
	public static final int CWACont = 2;
	
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
	
	public void nvgToggle() throws Exception
	{
		String jsonEvent = "{"
				+ " \"command\": \"nvg toggle\","
				+ " \"sensor\": \"lcd\","
				+ " \"id\": \"" + sessionID + "\""
				+ "}";
		connection.sendPOSTEvent(urlPath, jsonEvent);
	}
	
	public void audibleAlarmToggle() throws Exception
	{
		String jsonEvent = "{"
				+ " \"command\": \"alarm toggle\","
				+ " \"sensor\": \"lcd\","
				+ " \"id\": \"" + sessionID + "\""
				+ "}";
		connection.sendPOSTEvent(urlPath, jsonEvent);
	}
	
	public void setDetectionMode(int mode) throws Exception
	{
		data.setDetectionMode(mode);
		connection.sendPUT(urlPath, data.toString());
	}
	
	public void updatePosition(double longitude, double latitude) throws Exception
	{
		data.setPosition(latitude, longitude);
		connection.sendPUT(urlPath + "/" + sessionID, data.toString());
	}
}

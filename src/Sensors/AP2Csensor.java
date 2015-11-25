package Sensors;

public class AP2Csensor extends Sensor 
{
	public AP2Cdata data;

	public AP2Csensor(String hostname) 
	{
		super(hostname);
	}

	@Override
	public void getData() throws Exception 
	{		
		data = new AP2Cdata(super.connection.sendGET("sensor/ap2ce" + "/" + super.sessionID));
	}

	@Override
	public void startSimulation() throws Exception 
	{
		super.sessionID = (int) super.connection.sendPOST("sensor/ap2ce").get(0);
	}

	@Override
	public void endSimulation() throws Exception 
	{
		super.connection.sendDelete("sensor/ap2ce/" + super.sessionID);
	}

}

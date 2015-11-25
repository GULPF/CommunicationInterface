package Sensors;

public class LCDsensor extends Sensor 
{
	public LCDdata data;
	
	public LCDsensor(int id, String hostname) {
		super(hostname);
	}

	@Override
	public void getData() throws Exception 
	{
		data = new LCDdata(super.connection.sendGET("sensor/lcd" + "/" + super.sessionID));
	}

	@Override
	public void startSimulation() throws Exception 
	{
		super.connection.sendPOST("sensor/lcd");
	}

	@Override
	public void endSimulation() throws Exception 
	{
		super.connection.sendDelete("sensor/lcd/" + super.sessionID);
	}
}

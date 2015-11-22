
public class AP2Csensor extends Sensor 
{
	public AP2Cdata data;

	public AP2Csensor(int id, String hostname) 
	{
		super(id, hostname);
	}

	@Override
	public void getData() throws Exception 
	{		
		data = new AP2Cdata(super.connection.getJson(super.sessionID));
	}

	@Override
	public void startSimulation() throws Exception 
	{
		super.connection.sendEvent("SEND RIGHT STUFF FOR THIS SENSOR HERE");
	}

	@Override
	public void endSimulation() throws Exception 
	{
		super.connection.sendEvent("SEND RIGHT STUFF FOR THIS SENSOR HERE");
	}

}

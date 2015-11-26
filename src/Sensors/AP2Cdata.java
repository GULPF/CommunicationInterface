package Sensors;

import org.json.simple.JSONArray;

public class AP2Cdata implements sensorData 
{ 
	private JSONArray dataList;
	
	public AP2Cdata(JSONArray JsonArray)
	{
		dataList = JsonArray;
	}
	
	public String getBarCount()
	{
		return ((String[])dataList.get(0))[0];
	}
	
	public String getVolumeConcentration()
	{
		return ((String[])dataList.get(0))[1];
	}
	
	public boolean isHydrogenTankEmpty()
	{
		return Integer.parseInt(((String[])dataList.get(4))[0]) == 1;
	}
	
	public boolean isDeviceFault()
	{
		return Integer.parseInt(((String[])dataList.get(4))[1]) == 1;
	}
	
	public boolean isDetectorReady()
	{
		return Integer.parseInt(((String[])dataList.get(4))[2]) == 1;
	}
	
	public boolean isPurge()
	{
		return Integer.parseInt(((String[])dataList.get(4))[3]) == 1;
	}
	
	public boolean isBatteryLow()
	{
		return Integer.parseInt(((String[])dataList.get(4))[4]) == 1;
	}

}

package Sensors;

import org.json.simple.JSONArray;

public class AP2Cdata implements sensorData 
{ 
	private String[] dataList;
	
	public AP2Cdata(JSONArray JsonArray)
	{
//		dataList = new String[JsonArray.size() - 1];
//		
//		for(int i = 0; i < JsonArray.size(); i++)
//		{
//			dataList[i] = (String) JsonArray.get(i);
//		}
		dataList = (String[]) JsonArray.toArray(); //Might not work, use above commented code.
	}
	
	public String getBarCount()
	{
		return dataList[0];
	}
	
	public String getVolumeConcentration()
	{
		return dataList[1];
	}
	
	public boolean isHydrogenTankEmpty()
	{
		return Integer.parseInt(dataList[2]) == 1;
	}
	
	public boolean isDeviceFault()
	{
		return Integer.parseInt(dataList[3]) == 1;
	}
	
	public boolean isDetectorReady()
	{
		return Integer.parseInt(dataList[4]) == 1;
	}
	
	public boolean isPurge()
	{
		return Integer.parseInt(dataList[5]) == 1;
	}
	
	public boolean isBatteryLow()
	{
		return Integer.parseInt(dataList[6]) == 1;
	}

}

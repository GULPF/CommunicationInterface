package Sensors;

import org.json.JSONObject;;

public class AP2Cdata implements sensorData 
{ 
	private JSONObject dataList;
	
	public AP2Cdata(JSONObject JSONObject)
	{
		dataList = JSONObject;
	}
	
	public int getBarCount()
	{
		return dataList.getJSONArray("Data").getJSONObject(0).getInt("BarCount");
	}
	
	public int getVolumeConcentration()
	{
		return  dataList.getJSONArray("Data").getJSONObject(0).getInt("VolumeConcentration");
	}
	
	public boolean isHydrogenTankEmpty()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("HydrogenTankEmpty");
	}
	
	public boolean isDeviceFault()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("DeviceFault");
	}
	
	public boolean isDetectorReady()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("DetectorReady");
	}
	
	public boolean isPurge()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("Purge");
	}
	
	public boolean isBatteryLow()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("BatteryLow");
	}

}

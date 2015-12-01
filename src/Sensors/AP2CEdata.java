package Sensors;

import org.json.JSONObject;

import Exceptions.NoSuchSubstanceCategoryException;

public class AP2CEdata implements sensorData 
{ 
	private JSONObject dataList;
	
	public AP2CEdata(JSONObject JSONObject)
	{
		dataList = JSONObject;
	}
	
	private int returnData(String dataName, String substanceCategory) throws NoSuchSubstanceCategoryException {
		if(dataList.getJSONArray("Data").getJSONObject(0).getString("SubstanceCategory").equals(substanceCategory))
		{
			return dataList.getJSONArray("Data").getJSONObject(0).getInt(dataName);
		}
		else if(dataList.getJSONArray("Data").length() == 2)
		{
			if(dataList.getJSONArray("Data").getJSONObject(1).getString("SubstanceCategory").equals(substanceCategory))
			{
				return dataList.getJSONArray("Data").getJSONObject(1).getInt(dataName);
			}
		}
		throw new NoSuchSubstanceCategoryException();
	}
	
	public int get_gBarCount() throws NoSuchSubstanceCategoryException
	{
		return returnData("BarCount", "G");
	}

	
	
	public int get_gVolumeConcentration() throws NoSuchSubstanceCategoryException
	{
		return returnData("VolumeConcentration", "G");
	}
	
	public int get_hBarCount() throws NoSuchSubstanceCategoryException
	{
		return returnData("BarCount", "H");
	}
	
	public int get_hVolumeConcentration() throws NoSuchSubstanceCategoryException
	{
		return returnData("VolumeConcentration", "H");
	}
	
	public boolean is_HydrogenTankEmpty()
	{
		return dataList.getJSONObject("State").getBoolean("HydrogenTankEmpty");
	}
	
	public boolean is_DeviceFault()
	{
		return dataList.getJSONObject("State").getBoolean("DeviceFault");
	}
	
	public boolean is_DetectorReady()
	{
		return dataList.getJSONObject("State").getBoolean("DetectorReady");
	}
	
	public boolean is_Purge()
	{
		return dataList.getJSONObject("State").getBoolean("Purge");
	}
	
	public boolean is_BatteryLow()
	{
		return dataList.getJSONObject("State").getBoolean("BatteryLow");
	}

	@Override
	public void setPosition(double latitude, double longitude) 
	{
		dataList.remove("Position");
		JSONObject obj = new JSONObject("{"
				+ "		\"Altitude\": 0,"
				+ "		\"Latitude\": " + latitude + ","
				+ "		\"Longitude\": " + longitude
				+ "}");
		dataList.put("Position", obj);
	}
	
	@Override
	public String toString()
	{
		return dataList.toString();
	}
}

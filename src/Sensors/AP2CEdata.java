package Sensors;

import org.json.JSONArray;
import org.json.JSONObject;

public class AP2CeData implements SensorData 
{ 
	public final int gBarCount;
	public final int hBarCount;
	public final boolean hydrogenTankEmpty;
	public final boolean deviceFault;
	public final boolean detectorReady;
	public final boolean purge;
	public final boolean batteryLow;
	
	public AP2CeData(JSONObject json)
	{
		hBarCount = returnData("BarCount", "G", json);
		gBarCount = returnData("BarCount", "H", json);
		
		JSONObject state = json.getJSONObject("State");
		hydrogenTankEmpty = state.getBoolean("HydrogenTankEmpty");
		deviceFault = state.getBoolean("DeviceFault");
		detectorReady = state.getBoolean("DetectorReady");
		purge = state.getBoolean("Purge");
		batteryLow = state.getBoolean("BatteryLow");
	}
	
	private int returnData(String dataName, String substanceCategory, JSONObject json) 
	{
		JSONArray data = json.getJSONArray("Data");
		if(data.getJSONObject(0).getString("SubstanceCategory").equals(substanceCategory))
		{
			return data.getJSONObject(0).getInt(dataName);
		}
		else if(data.length() == 2)
		{
			if(data.getJSONObject(1).getString("SubstanceCategory").equals(substanceCategory))
			{
				return data.getJSONObject(1).getInt(dataName);
			}
		}
		return 0;
	}
}

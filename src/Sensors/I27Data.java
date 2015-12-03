package Sensors;

import org.json.JSONObject;

public class I27Data implements SensorData 
{
	public final int LeftProbeDoseRate;
	public final int InternalDoseRate;
	public final int RightProbeDoseRate;
	public final int AccumulatedDose;
	public final String TimeOfLastReset;
	public final boolean BatteryLow;
	public final boolean TemperatureError;
	
	public I27Data(JSONObject lastReceivedData)
	{
		JSONObject data = lastReceivedData.getJSONObject("Data");
		LeftProbeDoseRate = data.getInt("LeftProbeDoseRate");
		InternalDoseRate = data.getInt("InternalDoseRate");
		RightProbeDoseRate = data.getInt("RightProbeDoseRate");
		AccumulatedDose = data.getInt("AccumulatedDose");
		TimeOfLastReset = data.getString("TimeOfLastReset");
		
		JSONObject state = lastReceivedData.getJSONObject("State");
		BatteryLow = state.getBoolean("BatteryLow");
		TemperatureError = state.getBoolean("TemperatureError");
	}
}

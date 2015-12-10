package Sensors;

import org.json.JSONObject;

public class I28Data implements SensorData 
{
	public final int currentDoseRate;
	public final int peakDoseRate;
	public final int accumulatedDoseRate;
	public final int errorCode;
	
	public I28Data(JSONObject lastReceivedData)
	{
		JSONObject data = lastReceivedData.getJSONObject("Data");
		currentDoseRate = data.getInt("CurrentDoseRate");
		peakDoseRate = data.getInt("PeakDoseRate");
		accumulatedDoseRate = data.getInt("AccumulatedDoseRate");
		
		JSONObject state = lastReceivedData.getJSONObject("State");
		errorCode = state.getInt("ErrorCode");
	}
}

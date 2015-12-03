package Sensors;

import org.json.JSONArray;
import org.json.JSONObject;

public class RAIDData implements SensorData 
{
	public final int BarCount;
	public final int SubstanceClass;
	public final int ConcentrationUnit;
	public final int Concentration;
	public final String Substance;
	public final byte SubstanceLibrary;
	public final int DeviceState;
	public final int DeviceError;	
	
	public RAIDData(JSONObject lastReceivedData) 
	{
		JSONObject data = lastReceivedData.getJSONObject("Data");
		BarCount = data.getInt("BarCount");
		SubstanceClass = data.getInt("SubstanceClass");
		ConcentrationUnit = data.getInt("ConcentrationUnit");
		Concentration = data.getInt("Concentration");
		Substance = data.getString("Substance");
		
		JSONObject state = lastReceivedData.getJSONObject("State");
		SubstanceLibrary = (byte) state.getInt("SubstanceLibrary");
		DeviceState = state.getInt("DeviceState");
		DeviceError = state.getInt("DeviceError");
		
	}
}

package Sensors;

import org.json.JSONObject;;

public class LCDdata implements sensorData 
{
	private JSONObject dataList;
	
	public LCDdata(JSONObject JSONObject)
	{
		dataList = JSONObject;
	}
	
	public int getBarCount()
	{
		return dataList.getJSONArray("Data").getJSONObject(0).getInt("BarCount");
	}
	
	public int getSubstanceIndex()
	{
		return dataList.getJSONArray("Data").getJSONObject(0).getInt("SubstanceIndex");
	}
	
	public int getVolumeConcentration()
	{
		return dataList.getJSONArray("Data").getJSONObject(0).getInt("VolumeConcentration");
	}
	
	public String getDetectionMode()
	{
		return "?";
	}
	
	public boolean is_gAlert()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("gAlert");
	}

	public boolean is_hAlert()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("hAlert");
	}
	
	public boolean is_tICAlert()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("tICAlert");
	}
	
	public boolean is_tICMode()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("tICMode");
	} 
	
	public boolean is_lowSieve()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("lowSieve");
	}
	
	public boolean is_changeSievePack()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("changeSievePack");
	}

	public boolean is_lowBattery()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("lowBattery");
	}

	public boolean is_changeBattery()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("changeBattery");
	}

	public boolean is_gHighDoseAlert()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("gHighDoseAlert");
	}
	
	public boolean is_gMediumDoseAlert()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("gMediumDoseAlert");
	}

	public boolean is_hHighDoseAlert()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("hHighDoseAlert");
	}

	public boolean is_initialSelfTest()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("initialSelfTest");
	}
	public boolean is_coronaBurnOff()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("coronaBurnOff");
	}

	public boolean is_pTOutOfRange()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("pTOutOfRange");
	}

	public boolean is_audioFault()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("audioFault");
	}

	public boolean is_fatalError()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("fatalError");
	}

	public boolean is_cRAboveLimit()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("cRAboveLimit");
	}

	public boolean is_fanCAboveLimit()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("fanCAboveLimit");
	}

	public boolean is_initialSelfTestFailure()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("initialSelfTestFailure");
	}

	public boolean is_healthCheckFailure()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("healthCheckFailure");
	}

	public boolean is_codeChecksumError()
	{
		return dataList.getJSONArray("State").getJSONObject(0).getBoolean("codeChecksumError");
	}
	
	public boolean is_eEPROMChecksumError()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("eEPROMChecksumError");
	}

	public boolean is_hTOutSideLimits()
	{
		return  dataList.getJSONArray("State").getJSONObject(0).getBoolean("hTOutSideLimits");
	}
}

package Sensors;

import org.json.JSONObject;

import Exceptions.ModeOutOfBoundsException;
import Exceptions.NoSuchSubstanceCategoryException;

public class LCDdata implements sensorData 
{
	private JSONObject dataList;
	
	public LCDdata(JSONObject JSONObject)
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
	
	public int get_gSubstanceIndex() throws NoSuchSubstanceCategoryException
	{
		return returnData("SubstanceIndex", "G");
	}
	
	public int get_gVolumeConcentration() throws NoSuchSubstanceCategoryException
	{
		return returnData("VolumeConcentration", "G");
	}
	
	public int get_hBarCount() throws NoSuchSubstanceCategoryException
	{
		return returnData("BarCount", "H");
	}
	
	public int get_hSubstanceIndex() throws NoSuchSubstanceCategoryException
	{
		return returnData("SubstanceIndex", "H");
	}
	
	public int get_hVolumeConcentration() throws NoSuchSubstanceCategoryException
	{
		return returnData("VolumeConcentration", "H");
	}
	
	public int get_DetectionMode()
	{
		return dataList.getInt("DetectionMode");
	}
	
	public boolean is_gAlert()
	{
		return dataList.getJSONObject("State").getBoolean("GAlert");
	}

	public boolean is_hAlert()
	{
		return  dataList.getJSONObject("State").getBoolean("HAlert");
	}
	
	public boolean is_tICAlert()
	{
		return  dataList.getJSONObject("State").getBoolean("TICAlert");
	}
	
	public boolean is_tICMode()
	{
		return  dataList.getJSONObject("State").getBoolean("TICMode");
	} 
	
	public boolean is_lowSieve()
	{
		return  dataList.getJSONObject("State").getBoolean("LowSieve");
	}
	
	public boolean is_changeSievePack()
	{
		return  dataList.getJSONObject("State").getBoolean("ChangeSievePack");
	}

	public boolean is_lowBattery()
	{
		return  dataList.getJSONObject("State").getBoolean("LowBattery");
	}

	public boolean is_changeBattery()
	{
		return  dataList.getJSONObject("State").getBoolean("ChangeBattery");
	}

	public boolean is_gHighDoseAlert()
	{
		return  dataList.getJSONObject("State").getBoolean("GHighDoseAlert");
	}
	
	public boolean is_gMediumDoseAlert()
	{
		return  dataList.getJSONObject("State").getBoolean("GMediumDoseAlert");
	}

	public boolean is_hHighDoseAlert()
	{
		return  dataList.getJSONObject("State").getBoolean("HHighDoseAlert");
	}

	public boolean is_initialSelfTest()
	{
		return  dataList.getJSONObject("State").getBoolean("InitialSelfTest");
	}
	public boolean is_coronaBurnOff()
	{
		return  dataList.getJSONObject("State").getBoolean("CoronaBurnOff");
	}

	public boolean is_pTOutOfRange()
	{
		return dataList.getJSONObject("State").getBoolean("PTOutOfRange");
	}

	public boolean is_audioFault()
	{
		return  dataList.getJSONObject("State").getBoolean("AudioFault");
	}

	public boolean is_fatalError()
	{
		return  dataList.getJSONObject("State").getBoolean("FatalError");
	}

	public boolean is_cRAboveLimit()
	{
		return dataList.getJSONObject("State").getBoolean("CRAboveLimit");
	}

	public boolean is_fanCAboveLimit()
	{
		return dataList.getJSONObject("State").getBoolean("FanCAboveLimit");
	}

	public boolean is_initialSelfTestFailure()
	{
		return  dataList.getJSONObject("State").getBoolean("InitialSelfTestFailure");
	}

	public boolean is_healthCheckFailure()
	{
		return  dataList.getJSONObject("State").getBoolean("HealthCheckFailure");
	}

	public boolean is_codeChecksumError()
	{
		return dataList.getJSONObject("State").getBoolean("CodeChecksumError");
	}
	
	public boolean is_eEPROMChecksumError()
	{
		return  dataList.getJSONObject("State").getBoolean("EEPROMChecksumError");
	}

	public boolean is_hTOutSideLimits()
	{
		return  dataList.getJSONObject("State").getBoolean("HTOutSideLimits");
	}
	
	public void setDetectionMode(int value) throws ModeOutOfBoundsException
	{
		if(value > LCDsensor.CWACont) throw new ModeOutOfBoundsException();
		dataList.remove("DetectionMode");
		dataList.put("DetectionMode", value);
	}
	
	@Override
	public void setPosition(double latitude, double longitude) {
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

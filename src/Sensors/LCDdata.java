package Sensors;

import org.json.simple.JSONArray;

public class LCDdata implements sensorData 
{
	private JSONArray dataList;
	
	public LCDdata(JSONArray JsonArray)
	{
		dataList = JsonArray;
	}
	
	public String getBarCount()
	{
		return ((String[]) dataList.get(0))[0];
	}
	
	public String getSubstanceIndex()
	{
		return ((String[]) dataList.get(0))[1];
	}
	
	public String getVolumeConcentration()
	{
		return ((String[]) dataList.get(0))[2];
	}
	
	public String getDetectionMode()
	{
		return ((String[]) dataList.get(0))[3];
	}
	
	public boolean is_gAlert()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[0]) == 1;
	}

	public boolean is_hAlert()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[1]) == 1;
	}
	
	public boolean is_tICAlert()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[2]) == 1;
	}
	
	public boolean is_tICMode()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[3]) == 1;
	} 
	
	public boolean is_lowSieve()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[4]) == 1;
	}
	
	public boolean is_changeSievePack()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[5]) == 1;
	}

	public boolean is_lowBattery()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[6]) == 1;
	}

	public boolean is_changeBattery()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[7]) == 1;
	}

	public boolean is_gHighDoseAlert()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[8]) == 1;
	}
	
	public boolean is_gMediumDoseAlert()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[9]) == 1;
	}

	public boolean is_hHighDoseAlert()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[10]) == 1;
	}

	public boolean is_initialSelfTest()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[11]) == 1;
	}
	public boolean is_coronaBurnOff()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[12]) == 1;
	}

	public boolean is_pTOutOfRange()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[13]) == 1;
	}

	public boolean is_audioFault()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[14]) == 1;
	}

	public boolean is_fatalError()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[15]) == 1;
	}

	public boolean is_cRAboveLimit()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[16]) == 1;
	}

	public boolean is_fanCAboveLimit()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[17]) == 1;
	}

	public boolean is_initialSelfTestFailure()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[18]) == 1;
	}

	public boolean is_healthCheckFailure()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[19]) == 1;
	}

	public boolean is_codeChecksumError()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[20]) == 1;
	}
	
	public boolean is_eEPROMChecksumError()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[21]) == 1;
	}

	public boolean is_hTOutSideLimits()
	{
		return Integer.parseInt(((String[]) dataList.get(4))[22]) == 1;
	}
}

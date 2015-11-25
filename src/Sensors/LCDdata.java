package Sensors;

import org.json.simple.JSONArray;

public class LCDdata implements sensorData 
{
	private String[] dataList;
	
	public LCDdata(JSONArray JsonArray)
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
	
	public String getSubstanceIndex()
	{
		return dataList[1];
	}
	
	public String getVolumeConcentration()
	{
		return dataList[2];
	}
	
	public String getDetectionMode()
	{
		return dataList[3];
	}
	
	public boolean is_gAlert()
	{
		return Integer.parseInt(dataList[4]) == 1;
	}

	public boolean is_hAlert()
	{
		return Integer.parseInt(dataList[5]) == 1;
	}
	
	public boolean is_tICAlert()
	{
		return Integer.parseInt(dataList[6]) == 1;
	}
	
	public boolean is_tICMode()
	{
		return Integer.parseInt(dataList[7]) == 1;
	} 
	
	public boolean is_lowSieve()
	{
		return Integer.parseInt(dataList[8]) == 1;
	}
	
	public boolean is_changeSievePack()
	{
		return Integer.parseInt(dataList[9]) == 1;
	}

	public boolean is_lowBattery()
	{
		return Integer.parseInt(dataList[10]) == 1;
	}

	public boolean is_changeBattery()
	{
		return Integer.parseInt(dataList[11]) == 1;
	}

	public boolean _gHighDoseAlert()
	{
		return Integer.parseInt(dataList[12]) == 1;
	}
	
	public boolean _gMediumDoseAlert()
	{
		return Integer.parseInt(dataList[13]) == 1;
	}

	public boolean _hHighDoseAlert()
	{
		return Integer.parseInt(dataList[14]) == 1;
	}

	public boolean _initialSelfTest()
	{
		return Integer.parseInt(dataList[15]) == 1;
	}
	public boolean _coronaBurnOff()
	{
		return Integer.parseInt(dataList[16]) == 1;
	}

	public boolean _pTOutOfRange()
	{
		return Integer.parseInt(dataList[17]) == 1;
	}

	public boolean _audioFault()
	{
		return Integer.parseInt(dataList[18]) == 1;
	}

	public boolean _fatalError()
	{
		return Integer.parseInt(dataList[19]) == 1;
	}

	public boolean _cRAboveLimit()
	{
		return Integer.parseInt(dataList[20]) == 1;
	}

	public boolean _fanCAboveLimit()
	{
		return Integer.parseInt(dataList[21]) == 1;
	}

	public boolean _initialSelfTestFailure()
	{
		return Integer.parseInt(dataList[22]) == 1;
	}

	public boolean _healthCheckFailure()
	{
		return Integer.parseInt(dataList[23]) == 1;
	}

	public boolean _codeChecksumError()
	{
		return Integer.parseInt(dataList[24]) == 1;
	}
	
	public boolean _eEPROMChecksumError()
	{
		return Integer.parseInt(dataList[25]) == 1;
	}

	public boolean _hTOutSideLimits()
	{
		return Integer.parseInt(dataList[26]) == 1;
	}
}

import org.json.JSONObject;

import HttpClient.HttpClient;
import Sensors.AP2CEsensor;
import Sensors.LCDsensor;

// Simple test to see if HttpClient works. More extensive tests to fulfill SRS will need to be made.
public class mainTest { 

	public static void main(String[] args) {
		String hostname = "http://localhost:8732";
		HttpClient client = new HttpClient(hostname); // Make sure host / url is correct.	
		
		try {
//Raw tests of HttpClient
//			System.out.println("http://localhost:2000/sensor/ap2ce");
//			String Id = client.sendPOST("sensors/ap2ce");
//			System.out.println(Id);
//			System.out.println(client.sendGET("sensors/ap2ce/" + Id));
//			JSONObject testJSON = new JSONObject("{"
//			+ " \"Data\": [{"
//			+ "		\"BarCount\": 5,"
//			+ "		\"VolumeConcentration\": 20,"
//			+ "		\"SubstanceIndex\": 3"
//			+ "	},"
//			+ " {"
//			+ "		\"BarCount\": 5,"
//			+ "		\"VolumeConcentration\": 20,"
//			+ "		\"SubstanceIndex\": 3"
//			+ "	}],
//			+ "	\"Id\": \"abc\","
//			+ "	\"Position\": {"
//			+ "		\"Altitude\": 0,"
//			+ "		\"Latitude\": 1,"
//			+ "		\"Longitude\": 2"
//			+ " },"
//			+ "	\"State\": {"
//			+ " 	\"AudioFault\": true,"
//			+ " 	\"CRAboveLimit\": false,"
//			+ " 	\"ChangeBattery\": false,"
//			+ " 	\"ChangeSievePack\": false,"
//			+ " 	\"CodeChecksumError\": false,"
//			+ " 	\"CoronaBurnOff\": false,"
//			+ " 	\"EEPROMChecksumError\": false,"
//			+ " 	\"FanCAboveLimit\": false,"
//			+ " 	\"FatalError\": false,"
//			+ " 	\"GAlert\": false,"
//			+ " 	\"GHighDoseAlert\": false,"
//			+ " 	\"GMediumDoseAlert\": false,"
//			+ " 	\"HAlert\": false,"
//			+ " 	\"HHighDoseAlert\": false,"
//			+ " 	\"HTOutSideLimits\": false,"
//			+ " 	\"HealthCheckFailure\": false,"
//			+ " 	\"InitialSelfTest\": false,"
//			+ " 	\"InitialSelfTestFailure\": false,"
//			+ " 	\"LowBattery\": false,"
//			+ " 	\"LowSieve\": false,"
//			+ " 	\"PTOutOfRange\": false,"
//			+ " 	\"TICAlert\": false,"
//			+ " 	\"TICMode\": false"
//			+ "}"
//			+ "}");
//			System.out.println(testJSON.getJSONArray("Data").getJSONObject(0).getInt("SubstanceIndex"));
			
//			JSONObject obj = new JSONObject("{"
//			+ "		\"Longitude\": 5,"
//			+ "		\"Latitude\": 20,"
//			+ "		\"Altitude\": 3"
//			+ "	}");
//			System.out.println(obj.toString());
//			client.sendPUT("sensors/ap2ce/" + Id, obj.toString());
//			ADD PUT VARIANT HERE!
//			client.sendDELETE("sensors/ap2ce/" + Id);
			
//Sensor function tests
			System.out.println("START TESTS");
			System.out.println("START TEST AP2C");
			AP2CEsensor AP2CTest = new AP2CEsensor(hostname);
			AP2CTest.startSimulation();
			AP2CTest.getData();
			AP2CTest.updatePosition(15, 5);
			AP2CTest.data.get_gBarCount();
			AP2CTest.data.get_gVolumeConcentration();
			AP2CTest.data.is_BatteryLow();
			AP2CTest.data.is_DetectorReady();
			AP2CTest.data.is_DeviceFault();
			AP2CTest.data.is_HydrogenTankEmpty();
			AP2CTest.data.is_Purge();
			AP2CTest.endSimulation();
			System.out.println("END TEST AP2C");
			
			System.out.println("START TEST LCD");
			LCDsensor LCDTest = new LCDsensor(hostname);
			LCDTest.startSimulation();
			LCDTest.nvgToggle();
			LCDTest.getData();
			LCDTest.updatePosition(15, 5);
			LCDTest.data.get_gBarCount();
			LCDTest.data.get_gSubstanceIndex();
			LCDTest.data.get_gVolumeConcentration();
			LCDTest.data.get_DetectionMode();
			LCDTest.data.is_audioFault();
			LCDTest.data.is_changeBattery();
			LCDTest.data.is_changeSievePack();
			LCDTest.data.is_codeChecksumError();
			LCDTest.data.is_coronaBurnOff();
			LCDTest.data.is_cRAboveLimit();
			LCDTest.data.is_eEPROMChecksumError();
			LCDTest.data.is_fanCAboveLimit();
			LCDTest.data.is_fatalError();
			LCDTest.data.is_gAlert();
			LCDTest.data.is_gHighDoseAlert();
			LCDTest.data.is_gMediumDoseAlert();
			LCDTest.data.is_hAlert();
			LCDTest.data.is_healthCheckFailure();
			LCDTest.data.is_hHighDoseAlert();
			LCDTest.data.is_hTOutSideLimits();
			LCDTest.data.is_initialSelfTest();
			LCDTest.data.is_initialSelfTestFailure();
			LCDTest.data.is_lowBattery();
			LCDTest.data.is_lowSieve();
			LCDTest.data.is_pTOutOfRange();
			LCDTest.data.is_tICAlert();
			LCDTest.data.is_tICMode();
			LCDTest.setDetectionMode(0);
			LCDTest.data.get_DetectionMode();
			LCDTest.endSimulation();
			System.out.println("END TEST LCD");
			
			System.out.println("END TESTS");
			
			/*
			 * If these tests pass then all normal calls to WISE from java succeed.
			 * Events are not handled. AP2C has none, LCD has a few. TODO: Fix events.
			 */
			
			
/* Notes that might be relevant: 
 * In WISE we create a groundVehicle when we start simulations. 
 * These are never removed when endsimulation is called. Fix?
 * 
 * */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try {
//			System.out.println(client.getJson(1)); // Test get Json
//			
//			JSONObject obj = new JSONObject();
//			obj.put(1, 1); // Change values to test when we know exactly what needs to be in here!
//			
//			StringWriter out = new StringWriter();
//		    obj.writeJSONString(out);
//			client.sendEvent(out.toString()); //Test sending event
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
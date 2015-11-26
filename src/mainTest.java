import org.json.simple.JSONObject;

import HttpClient.HttpClient;
import Sensors.AP2Csensor;
import Sensors.LCDsensor;

// Simple test to see if HttpClient works. More extensive tests to fulfill SRS will need to be made.
public class mainTest { 

	public static void main(String[] args) {
		String hostname = "http://localhost:8732";
		HttpClient client = new HttpClient(hostname); // Make sure host / url is correct.	
		
		try {
			//Raw tests of HttpClient
			System.out.println("http://localhost:2000/sensor/ap2ce");
			String Id = client.sendPOST("sensors/ap2ce");
			System.out.println(Id);
			System.out.println(client.sendGET("sensors/ap2ce/" + Id)); //DOES NOT WORK
//			JSONObject obj = new JSONObject();
//			obj.put("Description", "Potato");
//			System.out.println(obj.toJSONString());
//			client.sendPUT("sensors/ap2ce/" + Id, obj.toJSONString());
//			ADD PUT VARIANT HERE!
//			client.sendDELETE("sensors/ap2ce/" + Id);
			
			//Sensor function tests
//			AP2Csensor AP2CTest = new AP2Csensor(hostname);
//			AP2CTest.startSimulation();
//			AP2CTest.getData(); // Does Not Work! Following will will work when fixed.
//			System.out.println(AP2CTest.data.getBarCount());
//			System.out.println(AP2CTest.data.getVolumeConcentration());
//			System.out.println(AP2CTest.data.isBatteryLow());
//			System.out.println(AP2CTest.data.isDetectorReady());
//			System.out.println(AP2CTest.data.isDeviceFault());
//			System.out.println(AP2CTest.data.isHydrogenTankEmpty());
//			System.out.println(AP2CTest.data.isPurge());
//			AP2CTest.endSimulation();
			
//			LCDsensor LCDTest = new LCDsensor(hostname);
//			LCDTest.startSimulation();
//			LCDTest.getData(); // Does Not Work! Following will will work when fixed.
//			System.out.println(LCDTest.data.getBarCount());
//			System.out.println(LCDTest.data.getDetectionMode());
//			System.out.println(LCDTest.data.getSubstanceIndex());
//			System.out.println(LCDTest.data.getVolumeConcentration());
//			System.out.println(LCDTest.data.is_audioFault());
//			System.out.println(LCDTest.data.is_changeBattery());
//			System.out.println(LCDTest.data.is_changeSievePack());
//			System.out.println(LCDTest.data.is_codeChecksumError());
//			System.out.println(LCDTest.data.is_coronaBurnOff());
//			System.out.println(LCDTest.data.is_cRAboveLimit());
//			System.out.println(LCDTest.data.is_eEPROMChecksumError());
//			System.out.println(LCDTest.data.is_fanCAboveLimit());
//			System.out.println(LCDTest.data.is_fatalError());
//			System.out.println(LCDTest.data.is_gAlert());
//			System.out.println(LCDTest.data.is_gHighDoseAlert());
//			System.out.println(LCDTest.data.is_gMediumDoseAlert());
//			System.out.println(LCDTest.data.is_hAlert());
//			System.out.println(LCDTest.data.is_healthCheckFailure());
//			System.out.println(LCDTest.data.is_hHighDoseAlert());
//			System.out.println(LCDTest.data.is_hTOutSideLimits());
//			System.out.println(LCDTest.data.is_initialSelfTest());
//			System.out.println(LCDTest.data.is_initialSelfTestFailure());
//			System.out.println(LCDTest.data.is_lowBattery());
//			System.out.println(LCDTest.data.is_lowSieve());
//			System.out.println(LCDTest.data.is_pTOutOfRange());
//			System.out.println(LCDTest.data.is_tICAlert());
//			System.out.println(LCDTest.data.is_tICMode());
//			LCDTest.endSimulation();
			
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
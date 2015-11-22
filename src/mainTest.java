import java.io.StringWriter;

import org.json.simple.JSONObject;

// Simple test to see if HttpClient works. More extensive tests to fulfill SRS will need to be made.
public class mainTest { 

	public static void main(String[] args) {
		HttpClient client = new HttpClient("localhost:11000"); // Make sure host / url is correct.
		
		try {
			System.out.println(client.getJson(1)); // Test get Json
			
			JSONObject obj = new JSONObject();
			obj.put(1, 1); // Change values to test when we know exactly what needs to be in here!
			
			StringWriter out = new StringWriter();
		    obj.writeJSONString(out);
			client.sendEvent(out.toString()); //Test sending event
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
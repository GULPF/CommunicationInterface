import org.json.simple.JSONArray;

public class AP2Cdata implements sensorData 
{ 
	private String[] dataList;
	
	public AP2Cdata(JSONArray JsonArray)
	{
//		dataList = new String[JsonArray.size() - 1];
//		
//		for(int i = 0; i < JsonArray.size(); i++)
//		{
//			dataList[i] = (String) JsonArray.get(i);
//		}
		dataList = (String[]) JsonArray.toArray(); //Might not work, use above commented code.
	}
	
	/* Create methods for each attribute.
	 * Might want to think up a better solution instead of using an array
	 * of strings containing the data for each parameter in db */
	public String getSomething()
	{
		return dataList[0];
	}

}

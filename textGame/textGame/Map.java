/**
 * 
 */
package textGame;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONObject;


/**
 * @author bourk
 *
 */
public class Map {
	
	private int length;
	private JSONObject[] areas = new JSONObject[length];
	private String[] values = new String[length];
	private String[] directionList = {"north", "east", "south", "west", "above", "below"};
	
	
	
	
	public Map(int length, JSONObject[] areas, String[] values) {
		this.length = length;
		this.values = values;
		this.areas = areas;
	};
		
	
	/*public void populateMap() {
		for(int i = 0; i<directionList.length; i++) {
			areas[i].put(values[i], directionList[i]);
			
			for(int j = directionList.length-1; j>0; j--) {
				areas[j].put(values[j], directionList[j]);
				}
			}
			StringWriter out = new StringWriter();
			for (int i = 0; i<directionList.length; i++) {
				try {
					areas[i].writeJSONString(out);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String mapText = out.toString();
				System.out.println(mapText);
				}
			
	} */


	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}


	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}


	/**
	 * @return the areas
	 */
	public JSONObject[] getAreas() {
		return areas;
	}


	/**
	 * @param areas the areas to set
	 */
	public void setAreas(JSONObject[] areas) {
		this.areas = areas;
	}


	/**
	 * @return the values
	 */
	public String[] getValues() {
		return values;
	}


	/**
	 * @param values the values to set
	 */
	public void setValues(String[] values) {
		this.values = values;
	}


	/**
	 * @return the directionList
	 */
	public String[] getDirectionList() {
		return directionList;
	}


	/**
	 * @param directionList the directionList to set
	 */
	public void setDirectionList(String[] directionList) {
		this.directionList = directionList;
	};

}

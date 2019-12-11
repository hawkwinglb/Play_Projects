package textGame;

//import org.json.simple.JSONObject;
//import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	HashMap<String, String> areas = new HashMap<String, String>();
		
		
		
		HashMap<String, String> kitchen = new HashMap<String, String>();
		HashMap<String, String> diningRoom = new HashMap<String, String>();
		HashMap<String, String> hall = new HashMap<String, String>();
		HashMap<String, String> ballroom = new HashMap<String, String>();
		HashMap<String, String> garden = new HashMap<String, String>();
		HashMap<String, String> cellar = new HashMap<String, String>();
		HashMap<String, String> yourRoom = new HashMap<String, String>();
		
		
		
		kitchen.put("here", "kitchen");
		kitchen.put("north", "dining room");
		kitchen.put("east", "hall");
		kitchen.put("west", "garden");
		kitchen.put("south", "cellar");
		diningRoom.put("here", "dining room");
		diningRoom.put( "south", "kitchen");
		diningRoom.put("east", "hall");
		diningRoom.put( "west", "ballroom");
		ballroom.put("south", "garden");
		ballroom.put( "east", "dining room");
		ballroom.put("here", "ballroom");
		cellar.put( "north", "kitchen");
		cellar.put("here", "cellar");
		garden.put( "east", "kitchen");
		garden.put( "north", "ballroom");
		garden.put( "here", "garden");
		hall.put( "west", "kitchen");
		hall.put( "here", "hall");
		hall.put( "west", "dining room");
		
		/*So now we have populated the HashMap objects with values, we want to be able to navigate between them. So that means figuring out how to navigate the key-value pairs.
		 * 
		 *  HALL :: DININGROOM :: BALLROOM
		 *  HALL :: KITCHEN ::    GARDEN
		 *  	 ::	CELLAR  ::
		 *  
		 *  So if it contains the value return the key, print key and value.
		 *  But how to move between objects?
		 *  
		 *  if key is kitchen object is object-kitchen?
		 *  
		 *  yourRoom = kitchen
		 *  
		 *  yourRoom print contents, ask for user input
		 *  if user input == value, get key
		 *  
		 *  yourRoom = key
		 *  
		 *  */
		
		
	
	yourRoom = kitchen;
	
	Scanner input = new Scanner(System.in);
	
	String direction = input.nextLine();
	
	if(yourRoom.containsKey(direction)) {
		String room = yourRoom.get(direction);
		
		if(room == "dining room") {
			yourRoom = diningRoom;
		}
		else if (room == "ballroom") {
			yourRoom = ballroom;
		}
		else if (room == "kitchen") {
			yourRoom = kitchen;
		}
		else if (room == "garden") {
			yourRoom = garden;
		}
		else if (room == "cellar") {
			yourRoom = cellar;
		}
		else if (room == "hall") {
			yourRoom = hall;
		}
	}
	
	
		
		
	
		
	input.close();	
	}

}

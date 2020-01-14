package textGame;

//import org.json.simple.JSONObject;
//import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.*;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	//	HashMap<String, String> areas = new HashMap<String, String>();
		
		String room;
		String[] beastSpeech = {"*scream*", "*howl*", "*growl*", "*groan*", "..."};
		String[] hauntedSpeech = {"You will die now.", "Your bones will feed our children!", "So sweet the meat.", "We bring your doom!"};
		Monster pickedMonster = new Monster();
		Random random = new Random();
		int random5 = random.nextInt(5)+1;
		
		
		
		//create hashmap areas
		HashMap<String, String> kitchen = new HashMap<String, String>();
		HashMap<String, String> diningRoom = new HashMap<String, String>();
		HashMap<String, String> hall = new HashMap<String, String>();
		HashMap<String, String> ballroom = new HashMap<String, String>();
		HashMap<String, String> garden = new HashMap<String, String>();
		HashMap<String, String> cellar = new HashMap<String, String>();
		HashMap<String, String> passageway = new HashMap<String, String>();
		HashMap<String, String> cave = new HashMap<String, String>();
		HashMap<String, String> cavern = new HashMap<String, String>();
		
		ArrayList<HashMap> roomlist = new ArrayList<HashMap>();
		
		roomlist.add(kitchen);
		roomlist.add(diningRoom);
		roomlist.add(hall);
		roomlist.add(ballroom);
		roomlist.add(garden);
		roomlist.add(cellar);
		
		//create empty hashmap for current area
		HashMap<String, String> yourRoom = new HashMap<String, String>();		

		
		//kitchen directions
		kitchen.put("here", "kitchen");
		kitchen.put("north", "dining room");
		kitchen.put("east", "hall");
		kitchen.put("west", "garden");
		kitchen.put("south", "cellar");
		
		//dining room directions
		diningRoom.put("here", "dining room");
		diningRoom.put( "south", "kitchen");
		diningRoom.put("east", "hall");
		diningRoom.put( "west", "ballroom");
		
		//ballroom directions
		ballroom.put("south", "garden");
		ballroom.put( "east", "dining room");
		ballroom.put("here", "ballroom");
		
		//cellar directions
		cellar.put( "north", "kitchen");
		cellar.put("here", "cellar");
		
		
		//garden directions
		garden.put( "east", "kitchen");
		garden.put( "north", "ballroom");
		garden.put( "here", "garden");
		
		//hall directions
		hall.put( "west", "kitchen");
		hall.put( "here", "hall");
		hall.put( "east", "dining room");
		
		//passageway
		passageway.put("here", "passageway");
		
		//cave
		cave.put("here", "cave");
		
		//cavern
		cavern.put("here", "cavern");
		
		
		//create Items

		Item book = new Item("Distant Whispers", "a book. From its pages you think you hear the murmur of far-off voices", 0, false);
		Item doll = new Item("bloody doll", "a child's doll, with staring glass eyes, covered in blood", 0, false);
		Item knife = new Item("sharp knife", "a boning knife, sharpened to a keen edge", 5, true);
		Item hockeystick = new Item("hockey stick", "a field hockey stick, with gravel embedded in its head and its handle peeling", 5, true);
		Item deadflower = new Item("dead rose", "a dead rose in a plant pot", 2, true);
		Item key = new Item("key", "small iron key", 0, false);
		
		//create Beast monsters
		
		Monster badDog = new Monster("slavering dog", "The dog has bared teeth and a foam-specked muzzle.", 1, 7, 5, beastSpeech);
		Monster angryBird = new Monster("evil bird", "The bird has mad eyes and a wickedly hooked beak.", 1, 5, 3, beastSpeech);
		
		//create Haunted monsters
		
		Monster ghost = new Monster("wisp", "The wisp has a translucent, human-like shape. You can see the wall through it.", 1, 5, 2, hauntedSpeech);
		Monster creepyChild = new Monster("revenant child", "The blood dripping from its eyes and pointed teeth gives you the first clue that this isn't a normal human child...", 1, 7, 7, hauntedSpeech);
		
		//populate monster list
		
		Monster[] monsterList = {badDog, angryBird, ghost, creepyChild};
		
		//create lists of Items for each room
		
		ArrayList<Item> kitchenItems = new ArrayList<Item>();
		ArrayList<Item> diningItems = new ArrayList<Item>();
		ArrayList<Item> cellarItems = new ArrayList<Item>();
		ArrayList<Item> gardenItems = new ArrayList<Item>();
		ArrayList<Item> hallItems = new ArrayList<Item>();
		ArrayList<Item> ballroomItems = new ArrayList<Item>();
		ArrayList<Item> passagewayItems = new ArrayList<Item>();
		ArrayList<Item> caveItems = new ArrayList<Item>();
		ArrayList<Item> cavernItems = new ArrayList<Item>();
		
		//create empty item list to be current room item list
		ArrayList<Item> yourRoomItems = new ArrayList<Item>();
		
		//put some items in the lists
		
		kitchenItems.add(knife);
		hallItems.add(hockeystick);
		diningItems.add(book);
		gardenItems.add(deadflower);
		cellarItems.add(doll);
		
		
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
		 * Second stage: items and inventory. Can add items to inventory and equip "equippable" items.
		 * 
		 *   
		 * Third stage:
		 * random encounter system for character objects (monsters)
		 * 
		 * need a list of monster objects at the top of the file
		 * then use a random number generator to choose if monster appears
		 * 
		 * then use a random number generator to choose from the list which monster appears
		 * 
		 *  */
		
		
		
		
	
		
	Character player = new Character();
	
	player.setDescription("stranger");
	player.setHealth(10);
	player.setDamage(random5);
	
	ArrayList<Item> inventory = new ArrayList<Item>();
	
	Item equipped = new Item();
	
	player.setInventory(inventory);
	player.setEquipped(equipped);
	
	
	System.out.println("It is 1900. You have come to the small village of Shadeham, Gloucester, in answer to a telegraph from the curate, an old friend of yours. He believes the long-abandoned Shadeham Hall is haunted, and wants your help to exorcise its ghosts.\nStrange, though. You expected he'd meet you at the train station. Instead, the only person you can see in the cold autumn sunshine is an elderly lady seated on a bench. She's reading a penny dreadful with a garish cover: THE CURSE OF THE BLOODY CHILD.");
	
	try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("What do you want to do?");
	System.out.println("1. Talk to the old lady.\n2.Go look for Shadeham Hall: maybe you misremembered, and you were supposed to meet Father Brown there.");
	Scanner noun = new Scanner(System.in);
	String noun1 = noun.next();
	noun1 = noun1.strip();
	int noun2 = Integer.parseInt(noun1);
	
	if(noun2 == 1) {
		System.out.println("\"Excuse me,\" you say.\nThe old lady glances up at you suspiciously. Her eyes are a peculiar shade of yellow.");
		System.out.println("YELLOW-EYED OLD LADY: \"Who are you, then?\"");
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Well, who *are* you? Enter your name.");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		name = name.strip();
		player.setName(name);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("YELLOW-EYED OLD LADY:" + "\"" + player.getName() + ". You're the one he's waiting for up at the Hall. He asked me to give you this. Now go away. I want to finish my book. Oh, and mind the dog. It's been living in the cellar for years.\"");
		
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("She hands you a " + key.getName() + ".It is a " + key.getDescription() + ". Maybe it opens a door at the Hall? But the old lady is definitely not paying you any more attention.");
		inventory.add(key);
		
	}
	else {
		System.out.println("You decide to go look for the Hall. Oh, by the way. Who are you?");
		System.out.println("Enter your name:");
		Scanner input = new Scanner(System.in);
		String name = input.nextLine();
		name = name.strip();
		player.setName(name);
	}
	
	try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("Hello, " + player.getName() + "!\n Your health is: " + player.getHealth() + "\nYour damage is: " + player.getDamage());
	
	try {
		TimeUnit.SECONDS.sleep(2);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	System.out.println("You wander up through the village. Eventually, you reach Shadeham Hall. The door stands open, but there's no sign of the curate. Maybe he's inside. You go in.");
	
	try {
		TimeUnit.SECONDS.sleep(1);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//set starting room and roomItems
	yourRoom = kitchen;
	yourRoomItems = kitchenItems;
		
	
	
	int controller = 0;
	while(controller==0) {

		//find key-value pairs for directions
		Set<String> theSet = yourRoom.keySet();
		ArrayList<String> directions = new ArrayList<String>(theSet);
		

		//tell player where they are
		System.out.println("You are in a " + yourRoom.get("here") + ".");
		
		int placeholder;
		if(inventory.contains(key) && player.getHealth()<10) {
			player.setHealth(10);
			System.out.println("You touch the " + key.getName() + " in your pocket. It makes you feel better.");
		}
		else if(inventory.contains(book)) {
			placeholder = 1;
			player.setHealth(player.getHealth()-placeholder);
		}
		else if(inventory.contains(doll)) {
			placeholder = 2;
			player.setHealth(player.getHealth() - placeholder);
		}
		
		//tell player their health
		System.out.println("Your health is: " + player.getHealth());
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//inventory management
		inventory = player.getInventory();
		equipped = player.getEquipped();
		
		if(inventory.size() == 0) {
			System.out.println("Your inventory is empty.");
			}
		else {
			System.out.println("Your inventory contains: ");
			for(int i = 0; i<inventory.size(); i++) {
				System.out.println("- " + inventory.get(i).getName());
				}
			}
		if(inventory.size()>0 && equipped.getName()!= null) {
			System.out.println("You have " + equipped.getName() + " equipped.");
			}
		
		if(inventory.size()>0) {
			ArrayList<Item> equippableItems = new ArrayList<Item>();
			for(int i = 0; i<inventory.size(); i++) {
				if(inventory.get(i).isEquipable()) {
					equippableItems.add(inventory.get(i));
					}
				}
			if(equippableItems.size()>0) {
				System.out.println("You have equippable items:");
				for(int i = 0; i<equippableItems.size(); i++) {
					System.out.println((i+1) + ": " + equippableItems.get(i).getName());
					}
				System.out.println("Press 1 to equip a new item. Press 2 to continue.");
				Scanner equip = new Scanner(System.in);
				String changeItem = equip.next();
				changeItem = changeItem.strip();
				int changedItem = Integer.parseInt(changeItem);
				if(changedItem == 1) {
					System.out.println("Press the appropriate number to equip item: ");
						for(int i = 0; i<equippableItems.size(); i++) {
							System.out.println((i+1) + ": " + equippableItems.get(i).getName());
							}	
					
						Scanner g = new Scanner(System.in);
						String equipItem = g.next();
						equipItem = equipItem.strip();
						int newEquip = Integer.parseInt(equipItem);
						equipped = equippableItems.get(newEquip-1);
						player.setEquipped(equipped);
				}
				
				}
			}
		//end of inventory management
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		//put monster in current room
		Random ran = new Random();
		int monster = ran.nextInt(2);
		
		if(monster == 1) {
			Random nextRan = new Random();
			int whichMonster = nextRan.nextInt((monsterList.length));
				for(int i = 0; i<monsterList.length; i++) {
					if(i == whichMonster) {
						pickedMonster = monsterList[i];
					}
				}
			}
		
		if(pickedMonster.getName() != null) {	
			
			System.out.println("You're not alone in the " + yourRoom.get("here") + ".\n");
			
			String enemyName = pickedMonster.getName();
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("You see something. It's a " + enemyName + ".");
			System.out.println(pickedMonster.getDescription());
			
			if(pickedMonster.isHostile() == true) {
				System.out.print(pickedMonster.getName() + ":");
				pickedMonster.speak();
				System.out.println("\nThe " + pickedMonster.getName() + " attacks!");
				
				int enemyHealth = pickedMonster.getHealth();
				int enemyDamage = pickedMonster.getDamage();
				int playerDamage = player.getDamage() + equipped.getDamage();
				int playerHealth = player.getHealth();	
				
				
				
				while(pickedMonster.isHostile() == true) {
					System.out.println("The " + enemyName + " is angry. It deals you: \n" + enemyDamage + " damage.");
					playerHealth = playerHealth - enemyDamage;
					System.out.println("Your health is: " + playerHealth);
					player.setHealth(playerHealth);

					if(playerHealth > 0) {
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println("\nPress 1 to fight back. Press 2 to run away.");

						Scanner fightScan = new Scanner(System.in);
						String f = fightScan.next();
						f = f.strip();
						int fight = Integer.parseInt(f);

						if(fight==1) {
							System.out.println("\nYou deal: " + playerDamage + " damage.");
							enemyHealth = enemyHealth - playerDamage;
							pickedMonster.setHealth(enemyHealth);
							if(enemyHealth < 1) {
								pickedMonster.setHostile(false);
								System.out.println("The " + enemyName + " runs away!");
								}
							}
						else if(fight == 2) {
							if(yourRoom == passageway || yourRoom == cave || yourRoom == cavern) {
								System.out.println("You can't run away fast enough. You have to fight back.");
								fight=1;
							}
							else {
								System.out.println("You run away, prudently and very fast.");
							}
							int randomRoom = random.nextInt(roomlist.size());
							yourRoom = roomlist.get(randomRoom);
							}
					}
						
					else if(playerHealth == 0 || playerHealth < 0) {
						System.out.println("You are dead: game over.");
						controller = 1;
					}
				}
			}
			else if(pickedMonster.isHostile()==false) {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("You see " + enemyName + ".");
				System.out.println("It cowers away from your approach. You might feel bad about that, eventually.");
				}
			}
	
		
		//when there is nothing in the roomItems list
		if(yourRoomItems.size() == 0) {
			System.out.println("You can't see anything useful here.");
			}
		//when there is something in the roomItems list
		else {
			Item[] itemlist = new Item[yourRoomItems.size()];
			System.out.println("You are in " + yourRoom.get("here"));
			System.out.println("You can see: " );
			for(int i = 0; i < yourRoomItems.size(); i++) {
				Item item = yourRoomItems.get(i);
				System.out.println("-- a " + item.getName());
				}
			
			//interact with items in the list
			//get description of items
			
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println("To examine these items more closely, press 1. To move on, press 2.");
			Scanner exam = new Scanner(System.in);
			String str = exam.next();
			int examine = Integer.parseInt(str);
			
			if(examine == 1) {
				for(int i = 0; i<yourRoomItems.size(); i++) {
					System.out.println("You look more closely at the " + yourRoomItems.get(i).getName() + ". It is " + yourRoomItems.get(i).getDescription() + ".");
					}
				}
			
			System.out.println("Item : ");
			for(int i = 0; i<yourRoomItems.size(); i++) {
				Item item = yourRoomItems.get(i);
				System.out.println((i+1) + ": " + item.getName());
				System.out.println("Add to inventory? Press 1 to add, 2 to move on.");
				
				Scanner l = new Scanner(System.in);
				String choice = l.next();
				choice = choice.strip();
				int f = Integer.parseInt(choice);
				if(f == 1) {
					player.addToInventory(item);
					yourRoomItems.remove(i);
					}
				System.out.println("Your inventory contains " + player.getInventory().size() + " items.");
				}
			
			
			}
			
		//display directions to user
		System.out.println("\nYou can go in the following directions: ");
		for(int i = 0; i<directions.size(); i++) {
			if(directions.get(i) != "here") {
			System.out.println(" -> " + directions.get(i));
				}
			}
		
		Scanner input = new Scanner(System.in);
		
		String direction = input.nextLine();
		
		if(yourRoom.containsKey(direction)) {
			room = yourRoom.get(direction);		
			if(room == "dining room") {
				yourRoom = diningRoom;
				yourRoomItems = diningItems;
				System.out.println("The " + room + " is dusty and shows no sign of human life.");
				}
			else if (room == "ballroom") {
				yourRoom = ballroom;
				yourRoomItems = ballroomItems;
				}
			else if (room == "kitchen") {
				yourRoom = kitchen;
				yourRoomItems = kitchenItems;
				System.out.println("Once, long ago, this was a lively place.");
				}
			else if (room == "garden") {
				yourRoom = garden;
				yourRoomItems = gardenItems;
				}
			else if (room == "cellar") {
				yourRoom = cellar;
				yourRoomItems = cellarItems;
				System.out.println("There are footprints in the dust, but you can't see where they lead.");
				}
			else if (room == "hall") {
				yourRoom = hall;
				yourRoomItems = hallItems;
				}
			else if(room == "passageway") {
				yourRoom = passageway;
				yourRoomItems = passagewayItems;
				System.out.println("It is dark here.");
				}
			else if(room == "cave") {
				yourRoom = cave;
				yourRoomItems = caveItems;
				System.out.println("It is dark here, and also cold.");
				}
			else if(room == "cavern") {
				yourRoom = cavern;
				yourRoomItems = cavernItems;
				System.out.println("You are not happy. Possibly you are lost.");
			}
			}
		else {
			System.out.println("You can't go that way.");
		}
		
		
		
		if(yourRoom == cellar && inventory.contains(book)) {
			System.out.println("The cellar looks different than before.");
			System.out.println("You see a faint outline in the dust behind some piled-up crates.");
			System.out.println("You hear a distant buzzing noise.");
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Are you going to look more closely?");
			System.out.println("Press 1 to investigate. Press 2 to move away.");
			
			Scanner inv = new Scanner(System.in);
			String investigate = inv.next();
			investigate = investigate.strip();
			int investigated = Integer.parseInt(investigate);
			if(investigated == 1) {
				cellar.put("down", "passageway");
				passageway.put("up", "cellar");
				passageway.put("north", "cave");
				cave.put("south", "passageway");
				cave.put("north", "cavern");
				cavern.put("south", "cave");
				
				System.out.println("You fall through a gap in the floor.");
				yourRoom = passageway;
				inventory.remove(book);
				System.out.println("The book cushions your landing, but it doesn't look very much like a book anymore.\nWhere are you?");
			}
			
		}
		
		if(yourRoom == cavern && inventory.contains(doll)) {
			creepyChild.setHostile(true);
			pickedMonster = creepyChild;
			
			System.out.println("Father Brown is here, but he seems to be in some trouble.");
			System.out.println("FATHER BROWN: Good news, " + player.getName() + "! The Hall is haunted but I think I know how to stop it. Did you find a " + doll.getName() + ", by any chance?");
			System.out.println("You give Father Brown the doll.");
			inventory.remove(doll);
			System.out.println("Father Brown sets the doll on fire. It screams like a living thing. Afterwards, there is silence.");
			controller = 2;
			
		}
		
		
		}
		
	if(controller == 1) {
		System.out.println("Ooops. You died. Bad show, old thing.");
	}
	else if(controller == 2) {
		System.out.println("You and Father Brown stagger back out into the sunlight. Congratulations! You have finished the game.");
	}
	
		
		
	
		
	
	
}
}

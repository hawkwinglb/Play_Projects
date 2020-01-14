package textGame;

import java.util.ArrayList;

public class Character {
	
	protected String name;
	protected String description;
	protected int health;
	protected int damage;
	protected Item equipped;
	protected ArrayList<Item> inventory;
	protected ArrayList<Item> equippableItems;
	

	
	
	public Character() {
		
	}


	public Character(String name, String description, int health, int damage) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.description = description;
		this.health = health;
		this.damage = damage;
		
		inventory = new ArrayList<Item>();
		equippableItems = new ArrayList<Item>();
		equipped = new Item();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/**
	 * @return the health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @param health the health to set
	 */
	public void setHealth(int health) {
		this.health = health;
	}
	

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void setInventory(ArrayList<Item>inventory) {
		this.inventory = inventory;
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	public void setEquipped(Item equipped) {
		this.equipped = equipped;
	}
	
	public Item getEquipped() {
		return equipped;
	}
	
	public ArrayList<Item> getEquippableItems(){
		return equippableItems;
	}
	
	
	
	public void addToInventory(Item item) {
		inventory.add(item);
	}
	
}

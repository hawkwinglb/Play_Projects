package textGame;

import java.util.ArrayList;

public class Character {
	
	private String name;
	private String description;
	private String alignment;
	private int strength;
	private int wisdom;
	private int dexterity;
	private int constitution;
	private int intelligence;
	private int charisma;
	private ArrayList<String> flavourSpeech;
	private ArrayList<Item> inventory;
	
	
	public Character() {
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getStrength() {
		return strength;
	}


	public void setStrength(int strength) {
		this.strength = strength;
	}


	public int getWisdom() {
		return wisdom;
	}


	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}


	public int getDexterity() {
		return dexterity;
	}


	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}


	public int getConstitution() {
		return constitution;
	}


	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}


	public int getIntelligence() {
		return intelligence;
	}


	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}


	public int getCharisma() {
		return charisma;
	}


	public void setCharisma(int charisma) {
		this.charisma = charisma;
	}


	public ArrayList<String> getFlavourSpeech() {
		return flavourSpeech;
	}


	public void setFlavourSpeech(ArrayList<String> flavourSpeech) {
		this.flavourSpeech = flavourSpeech;
	}


	public String getAlignment() {
		return alignment;
	}


	public void setAlignment(String alignment) {
		this.alignment = alignment;
	}


	public ArrayList<Item> getInventory() {
		return inventory;
	}


	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

}

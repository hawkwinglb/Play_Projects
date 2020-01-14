package textGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Monster extends Character {
	
	private String name, description;
	private String[] flavourSpeech;
	private int damage;
	private int health;
	private boolean hostile = true;
	
	private Random ran = new Random();
	
	
	public Monster() {
		
	}
	
	public Monster(String name, String description, int level, int health, int damage, String[] list) {
		this.name = name;
		this.description = description;
		this.health = health;
		this.damage = damage;
		hostile = true;
		flavourSpeech = list;
		
		}

	

	public boolean isHostile() {
		return hostile;
	}

	public void setHostile(boolean hostile) {
		this.hostile = hostile;
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

	
	public String[] getFlavourSpeech() {
		return flavourSpeech;
	}

	public void setFlavourSpeech(String[] flavourSpeech) {
		this.flavourSpeech = flavourSpeech;
	}

	
	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

		
	public void speak() {
		Random ran = new Random();
		int rand = ran.nextInt(flavourSpeech.length);
		String speech = flavourSpeech[rand];
		System.out.println(speech);
	}
	
	
	

}

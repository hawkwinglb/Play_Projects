package textGame;

public class Item {

	private String description, name;
	private int damage;
	private boolean equipable;
	
	/**
	 * @param description
	 * @param name
	 * @param damageVs
	 * @param equipable
	 */
	public Item(String name, String description, int damage, boolean equipable) {
		super();
		this.description = description;
		this.name = name;
		this.damage = damage;
		this.equipable = equipable;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public boolean isEquipable() {
		return equipable;
	}

	public void setEquipable(boolean equipable) {
		this.equipable = equipable;
	}

}

package game.Enemies;

public class EnemyRat extends Enemy {

	private String name;
	private String desc;
	private double health;
	private double damage;
	private double defense;
	
	public EnemyRat(){
		name = "Rat";
		desc = "A large, and rather smelly rat.";
		health = 5;
		damage = 2;
		defense = 2;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDesc() {
		return desc;
	}

	@Override
	public double getHealth() {
		return health;
	}

	@Override
	public double getDamage() {
		return damage;
	}

	@Override
	public double getDefense() {
		return defense;
	}

	@Override
	public void setHealth(double dmg) {
		health -= dmg;
	}

}

package game.Enemies;

@SuppressWarnings("unused")
public abstract class Enemy {
	

	private String name;
	private String desc;
	private double health;
	private double damage;
	private double defense;

	/**
	 * @return Enemy's name
	 */
	abstract public String getName();
	/**
	 * @return Enemy's desc
	 */
	abstract public String getDesc();
	/**
	 * @return Enemy's health
	 */
	abstract public double getHealth();
	/**
	 * @return Enemy's damage
	 */
	abstract public double getDamage();
	/**
	 * @return Enemy's defense
	 */
	abstract public double getDefense();
	/**
	 * Subtracts dmg from the enemy's health
	 * @param dmg
	 */
	abstract public void setHealth(double dmg);

}

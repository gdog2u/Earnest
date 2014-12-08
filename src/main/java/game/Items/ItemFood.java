package game.Items;

import java.util.Random;

public abstract class ItemFood extends Item{
	
	/*private int canHeal;
	private String name;
	private String desc;
	private int cost;*/
	/**
	 * Returns a randomly generated adjective to be prefixed to the food's name.
	 */
	public static String getAdjective(){
		Random r = new Random();
		int chance = r.nextInt(10);
		if(chance <= 3){
			return "Moldy ";
		}else if(chance <= 5){
			return "Buggy ";
		}else if(chance <= 7){
			return "Dirty ";
		}else{
			return "Fresh ";
		}
	}
	
	/**
	 * Adds canHeal to the player's health.
	 */
	public abstract void eat();
}

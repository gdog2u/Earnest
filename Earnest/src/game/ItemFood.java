package game;

import java.util.Random;

public class ItemFood extends Item{
	
	private int canHeal;
	private String name;
	private String desc;
	private int cost;
	/**
	 * Returns a randomly generated adjective to be prefixed to the food's name.
	 */
	public String getAdjective(){
		Random r = new Random();
		int chance = r.nextInt(10);
		if(chance <= 3){
			return "Moldy ";
		}else if(chance <= 5){
			return "Buggy ";
		}else if(chance <= 7){
			return "Clean looking ";
		}else{
			return "Fresh ";
		}
	}
	/**
	 * Takes the parameter from the Enum foodType in the Item class.
	 * @param type
	 */
	public ItemFood(Item.foodType type){
		switch(type){
			case BREAD:
				canHeal = 5;
				name = getAdjective() + type.toString().toLowerCase();
				desc = "It is simply a loaf of bread.";
				cost = 2;
				break;
			case MEAT:
				canHeal = 12;
				name = getAdjective() + type.toString().toLowerCase();
				desc = "Who know's how long this has been sitting around.";
				cost = 7;
				break;
			case PORIDGE:
				canHeal = 7;
				name = getAdjective() + type.toString().toLowerCase();
				desc = "You can't tell if it's this thick because age, or poor cooking.";
				cost = 3;
				break;
			case STEW:
				canHeal = 18;
				name = getAdjective() + type.toString().toLowerCase();
				desc = "It seems to still have steam coming from it.";
				cost = 8;
				break;
			default:
				canHeal = 1;
				name = getAdjective() + "???";
				desc = "ERROR";
				cost = 0;
				break;
		}
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getDesc(){
		return desc;
	}
	
	public void eat(){
		FrameMainGame.getHero().setCurHealth(canHeal);
	}

	@Override
	public int getCost(){
		return cost;
	}
	@Override
	public void setCost(int set) {
		cost = set;
	}
}

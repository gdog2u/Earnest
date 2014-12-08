package game.Items;

import game.Frames.FrameMainGame;
import game.Interfaces.Equipable;

import java.util.Random;

/**
 * Abstract class for assigning necessary methods for items, and returning items for chests.
 * @author Geoffrey
 */

public abstract class Item{

	
	private static Random r = new Random();
	
	public enum armorType{
		LEATHER,CHAIN,IRON,STEEL;
	}
	public enum toolType{
		WOOD,STONE,IRON,STEEL;
	}
	
	public enum foodType{
		BREAD, STEW, PORIDGE, MEAT;
	}
	
	public enum poolType{
		COMMON, FOOD, MID, HIGH,
		SHOP_LOW, SHOP_MID, SHOP_HIGH, 
	}
	
	/**
	 * generates item pools for chests based on the type of 
	 * @param poolType (low level, military, chef's, etc.)
	 * @return ArrayList of items
	 */
	public static Item itemPool(poolType poolType){
		int chance;
		switch(poolType){
		case COMMON: //pool type dungeon. low level items
			chance = r.nextInt(100);
			if(chance <= 30){
				return new ItemFood(foodType.BREAD);
			}else if(chance <= 45){
				return new ItemSword(toolType.WOOD);
			}else if(chance <= 60){
				return new ItemSword(toolType.STONE);
			}else if(chance <= 80){
				return new ItemGold();
			}else if(chance <= 95){
				return new ItemFood(foodType.MEAT);
			}else{
				return new ItemFood(foodType.STEW);
			}
		case SHOP_LOW: //pool type shop. Lesser goods.
			chance = r.nextInt(100);
			if(chance <= 5){
				return new ItemSword(toolType.STEEL);
			}else if(chance <= 30){
				return new ItemFood(foodType.BREAD);
			}else if(chance <= 60){
				return new ItemSword(toolType.WOOD);
			}else if(chance <= 80){
				return new ItemSword(toolType.STONE);
			}else{
				return new ItemFood(foodType.PORIDGE);
			}
		default:
			return null;
		}
	}
	
	/**
	 * Returns a random chest pool type.
	 * @return poolType
	 */
	public static poolType randomPool(){
		int chance = r.nextInt(100) + (FrameMainGame.getHero().getLuck()/2);
//		System.out.println(chance + " : " + (FrameMainGame.getHero().getLuck()/2));
		if(chance <= 40)
			return poolType.COMMON;
		else if(chance <= 70)
			return poolType.FOOD;
		else if(chance <= 90)
			return poolType.MID;
		else
			return poolType.HIGH;
		
	}

	/**
	 * To be overridden by the child classes.
	 * used to change the name of items for special cases.
	 * @param name
	 */
	public abstract void setName(String name);
	
	/**
	 *To be overridden by the child classes.
	 *Returns the name of the item.
	 */
	public abstract String getName();
	
	/**
	 *To be overridden by the child classes.
	 *Returns a description of the item.
	 */
	public abstract String getDesc();
	
	/**
	 * To be overridden by child classes
	 * Returns the cost the shop can buy it for.
	 */
	public abstract int getCost();

	public abstract void setCost(int set);
}

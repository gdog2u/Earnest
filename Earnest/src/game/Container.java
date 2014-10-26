package game;

import game.Frames.FrameContainer;
import game.Items.Item;

import java.util.ArrayList;
import java.util.Random;

/**
 * Object for loot chests found throughout the dungeon.
 * @author Geoffrey
 *
 */
public class Container {

	private ArrayList<Item> inventory = new ArrayList<Item>();
	
	public Container(){
		inventory = new ArrayList<Item>(); 
	}
	
	/**
	 * @param Player's level
	 * @param Player's luck
	 * @param Player's type
	 */
	public void genInv(int level, int luck, Item.poolType type){
		Random r = new Random();
		int items = r.nextInt(level + 3);
		for(int i = 0; i < items; i++){
			inventory.add(Item.itemPool(type));
		}
	}
	
	/**
	 * @deprecated
	 * Old version. Used to return chest contents as a string.
	 * Replaced with {@link open()} Method
	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < inventory.size(); i++){
			sb.append(inventory.get(i).getName() + "\n");
		}
		return sb.toString();
		
	}
	
	public String getContainerTitle(){
		Random r = new Random();
		int chance = r.nextInt(10);
		if(chance <= 3){
			return "Chest";
		}else if(chance <= 5){
			return "Crate";
		}else if(chance <= 7){
			return "Barrel";
		}else{
			return "Large Sack";
		}
	}
	
	public void open(){
		FrameContainer chest = new FrameContainer(getContainerTitle(), inventory);
		chest.setVisible(true);
	}

	public ArrayList<Item> getContents() {
		return inventory;
	}
}

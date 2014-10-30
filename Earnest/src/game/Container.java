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
		System.out.println("made it here");
		Random r = new Random();
		int items = r.nextInt(level + 3);
		for(int i = 0; i < items; i++){
			inventory.add(Item.itemPool(type));
		}
		System.out.println("done. Items created: " + inventory.size());
	}
	
	/**
	 * Randomly creates a title for the container.
	 * @return title
	 */
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
	
	/**
	 * Opens the {@link FrameContainer} gui for the container.
	 */
	public void open(){
		FrameContainer chest = new FrameContainer(getContainerTitle(), inventory);
		chest.setVisible(true);
	}

	/**
	 * 
	 * @return the contents of the container.
	 */
	public ArrayList<Item> getContents() {
		return inventory;
	}
}

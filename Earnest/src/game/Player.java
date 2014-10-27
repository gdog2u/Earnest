package game;

import game.Frames.FrameEquipment;
import game.Frames.FrameInventory;
import game.Frames.FrameLevelUp;
import game.Frames.FrameMainGame;
import game.Items.Item;
import game.Items.ItemFood;
import game.Items.ItemHelmet;
import game.Items.ItemKey;
import game.Items.ItemSword;

import java.util.*;

/**
 * Object for the player
 * @author Geoffrey
 *
 */
public class Player {
	private String name;
	private int level = 1;
	private int strength;
	private int constitution;
	private int dexterity;
	private int curHealth;
	private int luck;
	private int experience = 0;
	private int gold = 0;
	private int damage = 0;
	private int defense = 0;
	
	private ArrayList<Item> inventory = new ArrayList<Item>();
	private ArrayList<Item> equipment = new ArrayList<Item>();
	
	
	public Player(){
		level = 1;
		strength = rollStats();
		constitution = rollStats();
		curHealth = constitution;
		luck = rollStats();
		gold = 0;
	}
	
	/**
	 * generates stats in the style of D&D. 4D6 minus the lowest number.
	 */
	public static int rollStats(){
		Random r = new Random();
		int[] temp = new int[4];
		int tempFinal = 0;
		for(int i = 0;i < temp.length; i++){
			temp[i] = r.nextInt(6)+1;
		}
		Arrays.sort(temp);
		for(int i = 0; i < 3; i++){
			tempFinal += temp[i+1];
		}
		return tempFinal;
	}
	
	public void setName(String n){
		if(n.toLowerCase().equals("hydra")){
			name = n;
			new Hydra();
		}else{
			name = n;
		}
	}
	
	/**
	 * @return the player's name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @param exp Adds exp to the player's experience.
	 */
	public void setExperience(int exp){
		experience += exp;
	}

	/**
	 * @return the player's level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 *@return the player's strength level
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * @return the player's constitution level
	 */
	public int getConstitution() {
		return constitution;
	}

	/**
	 * @return the player's current health
	 */
	public int getCurHealth() {
		return curHealth;
	}

	/**
	 * @return the player's luck level
	 */
	public int getLuck() {
		return luck;
	}

	/**
	 * @return the player's amount experience
	 */
	public int getExperience() {
		return experience;
	}

	/**
	 * @return the player's inventory
	 */
	public ArrayList<Item> getInventory() {
		return inventory;
	}
	
	/**
	 * @return The player's equipment
	 */
	public ArrayList<Item> getEquipment(){
		return equipment;
	}

	/**
	 * @return the dexterity
	 */
	public int getDexterity() {
		return dexterity;
	}

	/**
	 * @return the damage
	 */
	public int getDamage() {
		return damage;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param dexterity the dexterity to set
	 */
	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	/**
	 * @param damage the damage to set
	 */
	public void setDamage(int damage) {
		this.damage = damage;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * @param strength the strength to set
	 */
	public void setStrength(int strength) {
		this.strength = strength;
	}

	/**
	 * @param constitution the constitution to set
	 */
	public void setConstitution(int constitution) {
		this.constitution = constitution;
	}

	
	/**
	 * This method is used to 
	 * add to the player's health.
	 * @param newHealth
	 */
	public void setCurHealth(int newHealth) {
		if((curHealth + newHealth) > constitution){
			curHealth = constitution;
		}else if(curHealth + newHealth == 0){
			FrameMainGame.gameOver();
		}else{
			this.curHealth += newHealth;
		}
	}
	
	/**
	 * @return gold
	 */
	public int getGold() {
		return gold;
	}
	
	/**
	 * Adds the gold parameter to the player's goldW
	 * @param gold
	 */
	public void setGold(int gold) {
		this.gold += gold;
	}
	
	/**
	 * @return a few items to test how the inventory works.
	 */
	public void testInventory(){
		inventory.add(new ItemHelmet(Item.armorType.LEATHER));
		inventory.add(new ItemSword(Item.toolType.STONE));
		inventory.add(new ItemFood(Item.foodType.BREAD));
		inventory.add(new ItemFood(Item.foodType.PORIDGE));
		inventory.add(new ItemKey());
	}
	
	/**
	 * Opens a {@link FrameInventory} to show the player's inventory.
	 */
	public void showInventory(){
		FrameInventory invFrame = new FrameInventory(inventory);
		invFrame.setVisible(true);
	}
	
	/**
	 * Opens a {@link FrameEquipment} to show the player's currently equipped items.
	 */
	public void showEquipment(){
		FrameEquipment equFrame = new FrameEquipment(equipment);
		equFrame.setVisible(true);
	}
	
	/**
	 * Opens the {@link FrameLevelUp} gui to level the player up. Under construction.
	 */
	public void levelUp(){
		FrameLevelUp levelFrame = new FrameLevelUp();
		levelFrame.setVisible(true);
	}
}

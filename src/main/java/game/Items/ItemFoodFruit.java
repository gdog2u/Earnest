package game.Items;

import game.Frames.FrameMainGame;

import java.util.ArrayList;
import java.util.Random;

public class ItemFoodFruit extends ItemFood {
	
	private int canHeal;
	private String name;
	private String desc;
	private int cost;
	
	public ItemFoodFruit(){
		name = ItemFood.getAdjective() + getFruit();
		canHeal = 5;
		cost = 3;
		desc = "How could fresh fruit possible be in a here?";
	}

	@Override
	public void eat() {
		FrameMainGame.getHero().setCurHealth(canHeal);
		
	}

	@Override
	public void setName(String name) {
		this.name = ItemFood.getAdjective() + name;
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
	public int getCost() {
		return cost;
	}

	@Override
	public void setCost(int set) {
		this.cost = set;
	}
	
	private String getFruit(){
		Random r = new Random();
		ArrayList<String> fruits = new ArrayList<>();
		fruits.add("apple");
		fruits.add("pear");
		fruits.add("beat");
		fruits.add("carrot");
		fruits.add("potato");
		fruits.add("onion");
		fruits.add("banana");
		fruits.add("celery");
		return fruits.get(r.nextInt(fruits.size()));
	}

}

package game.Items;

import game.Frames.FrameMainGame;

public class ItemFoodStew extends ItemFood {
	
	private int canHeal;
	private String name;
	private String desc;
	private int cost;
	
	public ItemFoodStew(){
		name = ItemFood.getAdjective() + "stew";
		cost = 8;
		desc = "It still seems to be warm.";
		canHeal = 18;
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

}

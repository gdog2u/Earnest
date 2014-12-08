package game.Items;

import game.Frames.FrameMainGame;

public class ItemFoodBread extends ItemFood {
	
	private int canHeal;
	private String name;
	private String desc;
	private int cost;

	public ItemFoodBread(){
		name = ItemFood.getAdjective() + "bread";
		canHeal = 7;
		cost = 5;
		desc = "It is Simply a loaf of bread.";
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
	
	public void eat(){
		FrameMainGame.getHero().setCurHealth(canHeal);
	}

	@Override
	public void setCost(int set) {
		this.cost = set;
	}

}

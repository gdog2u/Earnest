package game.Items;

import game.Frames.FrameMainGame;

public class ItemFoodMeat extends ItemFood {
	
	private int canHeal;
	private String name;
	private String desc;
	private int cost;
	
	public ItemFoodMeat(){
		name = ItemFood.getAdjective() + "meat";
		cost = 7;
		canHeal = 12;
		desc = "Who knows howlong this has been sitting around";
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

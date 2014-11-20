package game.Items;

import game.Frames.FrameMainGame;

import java.util.Random;

public class ItemGold extends Item {
	
	private int cost;
	
	public ItemGold(){
		cost = getAmount();
	}
	
	@Override
	public String getName() {
		return cost + " gold";
	}

	@Override
	public String getDesc() {
		return "It's money!";
	}

	@Override
	public int getCost() {
		return cost;
	}

	private int getAmount() {
		Random r = new Random();
		cost = FrameMainGame.getHero().getLevel() * (r.nextInt(FrameMainGame.getHero().getLuck())/2) * 5;
		if(cost > 0){
			return cost;
		}else{
			cost = getAmount();
		}
		return 100;
	}

	@Override
	public void setCost(int set) {
		cost = set;
	}

}

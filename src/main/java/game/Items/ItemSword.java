package game.Items;

import game.Frames.FrameMainGame;

public class ItemSword extends Item{

	private double dmg;
	private String name;
	private String desc;
	private int cost;
	
	public ItemSword(Item.toolType type){
		switch(type){
		case WOOD:
			dmg =((double)(FrameMainGame.getHero().getStrength())/10) * 1;
			name = "Wood sword";
			desc = "A sword made of wood. It isn't very sharp.";
			cost = 5;
			break;
		case STONE:
			dmg =((double)(FrameMainGame.getHero().getStrength())/10) * 5;
			name = "Stone sword";
			desc = "A sword made of stone. The sword isn't as sharp as it use to be.";
			cost = 15;
			break;
		case IRON:
			dmg =((double)(FrameMainGame.getHero().getStrength())/10) * 7;
			name = "Iron sword";
			desc = "A sword made of iron. The sword has some rust on it, but it still has an edge.";
			cost = 45;
			break;
		case STEEL:
			dmg =((double)(FrameMainGame.getHero().getStrength())/10) * 10;
			name = "Steel sword";
			desc = "A sword made of steel. Despite the conditions it's been kept in, it can still cut well.";
			cost = 100;
			break;
		default:
			dmg =((double)(FrameMainGame.getHero().getStrength())/10) * 10;
			name = "Wood sword";
			desc = "A sword made of wood. It isn't very sharp.";
			cost = 5;
			break;
		}
	}
	
	public double getDmg(){
		return dmg;
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getDesc(){
		return desc;
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

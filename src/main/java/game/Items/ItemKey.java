package game.Items;

public class ItemKey extends Item{
	
	private String name = "Key";
	private String desc = "It unlocks things.";
	private int cost = 0;
	
	public ItemKey(){
	}
	
	@Override
	public String getName(){
		return name;
	}
	
	@Override
	public String getDesc(){
		return desc;
	}
	
	public int getCost(){
		return cost;
	}
	
	@Override
	public void setCost(int set){
		cost = set;
	}
}

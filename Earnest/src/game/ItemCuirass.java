package game;

public class ItemCuirass extends ItemArmor {
	
	private String name;
	private String desc;
	private int cost;
	private int dfn;
	
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
		cost = set;
	}
	
	@Override
	public int getDfn(){
		return dfn;
	}

	@Override
	public void setDfn(int set) {
		dfn = set;
	}

}

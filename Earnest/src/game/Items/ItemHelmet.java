package game.Items;

public class ItemHelmet extends ItemArmor {

	private String name;
	private String desc;
	private int cost;
	private int dfn;
	
	public ItemHelmet(armorType type) {
		switch(type){
			case LEATHER:
				name = "Leather helmet";
				desc = "A thin hide helmet.";
				cost = 5;
				dfn = 1;
				break;
		default:
			name = "ERROR";
			desc = "You shouldn't be seeing this.";
			cost = 9999;
			dfn = 9999;
			break;
		}
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
		cost = set;
	}

	@Override
	public int getDfn() {
		return dfn;
	}

	@Override
	public void setDfn(int set) {
		dfn = set;
	}

}

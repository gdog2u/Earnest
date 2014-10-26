package game.Items;

/**
 * Abstract class that assigns armor type items necessary getters and setters.
 * @author Geoffrey
 *
 */
public abstract class ItemArmor extends Item {

	@Override
	public abstract String getName();

	@Override
	public abstract String getDesc();

	@Override
	public abstract int getCost();

	@Override
	public abstract void setCost(int set);
	
	public abstract int getDfn();
	
	public abstract void setDfn(int set);

}

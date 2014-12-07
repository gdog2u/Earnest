package game.Frames;

import game.Container;
import game.Items.Item;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * A frame designed for future use for the player to sell their un-used items.
 * @author Geoffrey
 *
 */

public class FrameShop extends JFrame{

	private static final long serialVersionUID = 5257172290552340028L;
	private Container toBuy = new Container();
	
	public FrameShop(ArrayList<Item> toSell){
		setTitle("Shop");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		toSell = FrameUpdater.removeNulls(toSell);
		
		toBuy.genInv(FrameMainGame.getHero().getLevel(), FrameMainGame.getHero().getLuck(), Item.poolType.SHOP_LOW);
		int panelHeight = getPanelHeight(toSell, toBuy.getContents());
		
		add(FrameUpdater.shopUpdate(toSell, toBuy.getContents(), panelHeight), BorderLayout.CENTER);
		
		setSize(toSell, toBuy.getContents());
	}
	
	/**
	 * Sets the size of the windows based on inventory size.
	 * @param comp1
	 * @param comp2
	 */
	private void setSize(ArrayList<Item> comp1, ArrayList<Item> comp2){
		int size1 = comp1.size();
		int size2 = comp2.size();
		
		if(size1 > size2){
			setSize(600, size1*100);
		}else if(size2 > size1){
			setSize(600, size2*100);
		}else{
			setSize(400,150);
		}
	}
	
	/**
	 * Sets how tall the panels returned from {@link FrameUpdater.shopUpdate}
	 * @param comp1
	 * @param comp2
	 * @return amount of rows
	 */
	private int getPanelHeight(ArrayList<Item> comp1, ArrayList<Item> comp2){
		int size1 = comp1.size();
		int size2 = comp2.size();
		if(size1 > size2){
			return size1;
		}else if(size2 > size1){
			return size2;
		}else{
			return 1;
		}
	}

}

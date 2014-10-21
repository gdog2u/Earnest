package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.*;

/**
 * A frame designed for future use for the player to sell their un-used items.
 * @author Geoffrey
 *
 */

public class FrameShop extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5257172290552340028L;
	private Container toSell = new Container();
	
	public FrameShop(ArrayList<Item> toBuy){
		setTitle("Shop");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout());
		
		JPanel playerGrid = new JPanel(new GridLayout(toBuy.size(), 3));
		
		if(toBuy.isEmpty()){
			playerGrid.setLayout(new GridLayout());
			playerGrid.add(new JLabel("Nothing to sell."));
		}else{
			for(int i = 0; i < toBuy.size(); i++){
				playerGrid.add(new WrappingLabel(toBuy.get(i).getName()));
				playerGrid.add(new WrappingLabel(toBuy.get(i).getCost() + " gold"));
				playerGrid.add(new ButtonSell(toBuy, i));
			}
		}
		
		add(playerGrid, BorderLayout.WEST);
		
		toSell.genInv(FrameMainGame.getHero().getLevel(), FrameMainGame.getHero().getLuck(), Item.poolType.SHOP_LOW);
		
		JPanel shopGrid = new JPanel(new GridLayout(toSell.getContents().size(), 6));
		
		if(toSell.getContents().isEmpty()){
			shopGrid.setLayout(new GridLayout());
			shopGrid.add(new JLabel("Nothing to buy."));
		}else{
			for(int i = 0;i < toSell.getContents().size(); i++){
				toSell.getContents().get(i).setCost((int) (toSell.getContents().get(i).getCost() * 1.3));
			}
			for(int i = 0; i < toSell.getContents().size(); i++){
				shopGrid.add(new WrappingLabel(toSell.getContents().get(i).getName()));
				shopGrid.add(new WrappingLabel(toSell.getContents().get(i).getCost() + " gold"));
				shopGrid.add(new ButtonBuy(toSell.getContents(), i));
			}
		}
		
		add(shopGrid, BorderLayout.EAST);	
		testSize(toBuy, toSell.getContents());
	}
	
	private void testSize(ArrayList<Item> comp1, ArrayList<Item> comp2){
		int size1 = comp1.size();
		int size2 = comp2.size();
		
		if(size1 > size2){
			setSize(500, size1*100);
		}else if(size2 > size1){
			setSize(500, size2*100);
		}else{
			setSize(400,150);
		}
	}

}

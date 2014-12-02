package game.Frames;

import game.Items.Item;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A frame used to show the player's inventory
 * @author Geoffrey
 */
public class FrameInventory extends JFrame{

	private static final long serialVersionUID = -8249200798924730479L;

	public FrameInventory(ArrayList<Item> inventory) {
		
		inventory = FrameUpdater.removeNulls(inventory);
		
		this.setTitle("Inventory");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(400, inventory.size()*100);
		this.setLocationRelativeTo(null);
		
		JPanel goldGrid = new JPanel(new GridLayout(1,4));
		
		JLabel goldLbl = new JLabel("Gold: ");
		JLabel goldCountLbl = new JLabel(Integer.toString(FrameMainGame.getHero().getGold()));
		
		goldGrid.add(goldLbl);
		goldGrid.add(goldCountLbl);
		
		if(inventory.isEmpty() == true){
			this.setSize(200, 100);
			add(new JLabel("No items."), BorderLayout.CENTER);
		}else{
			add(FrameUpdater.inventoryUpdate(inventory), BorderLayout.CENTER);
		}
		add(goldGrid, BorderLayout.NORTH);
		
	}
	
	/*public static void frameUpdate(JPanel invPanel){
		add(invPanel);
	}*/

}

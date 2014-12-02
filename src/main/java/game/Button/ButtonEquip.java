package game.Button;

import game.Frames.FrameMainGame;
import game.Items.Item;
import game.Items.ItemSword;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * A custom JButton for use in moving items from the player's inventory into their equipment.
 * @author Geoffrey
 */
public class ButtonEquip extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1798114659038175150L;
	
	public ButtonEquip(final ArrayList<Item> inv, final int index){
		setText("Equip");
		addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(inv.get(index) == null){
					JOptionPane.showMessageDialog(null, "This item is no longer in your inventory.\nPlease reopen to update.");
				}else if(FrameMainGame.getHero().getEquipment().isEmpty() == false){
					for (Item i : FrameMainGame.getHero().getEquipment()) {
						if(i instanceof ItemSword){
							JOptionPane.showMessageDialog(null, "You already have a sword equipped.");
						}else{
							FrameMainGame.getHero().getEquipment().add(inv.get(index));
							inv.set(index, null);
						}
					}
				}else{
					FrameMainGame.getHero().getEquipment().add(inv.get(index));
					inv.set(index, null);
				}
				
			}
			
		});
	}

}

package game.Button;

import game.Frames.FrameEquipment;
import game.Frames.FrameMainGame;
import game.Items.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Custom button for un-equipping items in the {@link FrameEquipment} gui.
 * @author Geoffrey
 *
 */
public class ButtonUnequip extends JButton {

	private static final long serialVersionUID = 8161257156664073348L;

	public ButtonUnequip(final ArrayList<Item> equipment, final int index){
		setText("Unequip");
		addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(equipment.get(index) == null){
					JOptionPane.showMessageDialog(null, "This item is no longer equipped.\nPlease reopen to update.");
				}else{
					FrameMainGame.getHero().getInventory().add(equipment.get(index));
					equipment.set(index, null);
				}
			}
			
		});
	}
	
}

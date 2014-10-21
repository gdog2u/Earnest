package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonUnequip extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8161257156664073348L;

	public ButtonUnequip(final ArrayList<Item> equipment, final int index){
		setText("Unequip");
		addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				FrameMainGame.getHero().getInventory().add(equipment.get(index));
				equipment.remove(index);
			}
			
		});
	}
	
}

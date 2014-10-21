package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonEat extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3486590310364245845L;

	public ButtonEat(final ArrayList<Item> inv, final int index) {
		setText("Eat");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				((ItemFood) inv.get(index)).eat();
				inv.remove(index);
				
			}
		});
	}
	
}

package game.Button;

import game.Items.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * A custom JButton for use in removing items from the player's inventory
 * @author Geoffrey
 */
public class ButtonDrop extends JButton {

	private static final long serialVersionUID = 1L;
	
	public ButtonDrop(final ArrayList<Item> al, final int index){
		setText("Drop");
		addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if(al.get(index) == null){
					JOptionPane.showMessageDialog(null, "This item is no longer in your inventory.\nPlease reopen to update.");
				}else{
					al.set(index, null);
				}
				
			}
			
		});
	}

}

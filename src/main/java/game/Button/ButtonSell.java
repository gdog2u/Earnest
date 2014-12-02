package game.Button;

import game.Frames.FrameMainGame;
import game.Frames.FrameShop;
import game.Items.Item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Custom button for selling items in the {@link FrameShop} gui.
 * @author Geoffrey
 *
 */
public class ButtonSell extends JButton {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5471899319031409979L;

	public ButtonSell(final ArrayList<Item> contents, final int index){
		setText("Sell");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(contents.get(index) == null){
					JOptionPane.showMessageDialog(null, "This item is no longer in your inventory.\nPlease reopen to update.");
				}
				else{
					FrameMainGame.getHero().setGold(contents.get(index).getCost());
					contents.set(index, null);
				}
				
			}
		});
	}
	
}

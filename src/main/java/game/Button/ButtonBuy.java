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
 * Custom button for use in {@link FrameShop} gui for buying.
 * @author Geoffrey
 *
 */
public class ButtonBuy extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5046454595411429L;

	public ButtonBuy(final ArrayList<Item> contents, final int index) {
		setText("Buy");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(contents.get(index) == null){
					JOptionPane.showMessageDialog(null, "This item is no longer here.\nPlease reopen to update.");
				}else if(FrameMainGame.getHero().getGold() >= contents.get(index).getCost()){
					FrameMainGame.getHero().setGold(-contents.get(index).getCost());
					FrameMainGame.getHero().getInventory().add(contents.get(index));
					contents.set(index, null);
				}else{
					JOptionPane.showMessageDialog(null, "You do not have enough money for that!");
				}
			}
		});
	}

}

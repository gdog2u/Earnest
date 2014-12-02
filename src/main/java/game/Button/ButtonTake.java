package game.Button;

import game.Frames.FrameContainer;
import game.Frames.FrameMainGame;
import game.Items.Item;
import game.Items.ItemGold;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Custom button for the {@link FrameContainer} gui.
 * @author Geoffrey
 *
 */
public class ButtonTake extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7935359007060296754L;

	public ButtonTake(final ArrayList<Item> inv, final int index) {
		setText("Take");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(inv.get(index) == null){
					JOptionPane.showMessageDialog(null, "This item has already been taken.");
				}else if(inv.get(index) instanceof ItemGold){
					FrameMainGame.getHero().setGold(inv.get(index).getCost());;
					inv.set(index, null);
				}else{
					FrameMainGame.getHero().getInventory().add(inv.get(index));
					inv.set(index, null);
				}
				
			}
		});
	}

}

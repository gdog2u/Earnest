package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

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
				
				if(inv.get(index) instanceof ItemGold){
					FrameMainGame.getHero().setGold(inv.get(index).getCost());;
					inv.remove(index);
				}else{
					FrameMainGame.getHero().getInventory().add(inv.get(index));
					inv.remove(index);
				}
				
			}
		});
	}

}

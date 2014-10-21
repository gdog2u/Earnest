package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

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
				
				FrameMainGame.getHero().setGold(contents.get(index).getCost());
				contents.remove(index);
				
			}
		});
	}
	
}

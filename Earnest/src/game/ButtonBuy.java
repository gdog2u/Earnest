package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonBuy extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5046454595411429L;

	public ButtonBuy(final ArrayList<Item> contents, final int i) {
		setText("Buy");
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(FrameMainGame.getHero().getGold() >= contents.get(i).getCost()){
					FrameMainGame.getHero().setGold(-contents.get(i).getCost());
					FrameMainGame.getHero().getInventory().add(contents.get(i));
					contents.remove(i);
				}else{
					JOptionPane.showMessageDialog(null, "You do not have enough money for that!");
				}
			}
		});
	}

}

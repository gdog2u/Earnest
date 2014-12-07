package game.Frames;

import game.Items.Item;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A frame used to display the players stats and equipped items.
 * @author Geoffrey
 *
 */
public class FrameEquipment extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8005285387203215403L;
	
	public FrameEquipment(ArrayList<Item> equipment){
		
		equipment = FrameUpdater.removeNulls(equipment);
		
		this.setTitle("Equipment");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, equipment.size()*200);
		this.setLocationRelativeTo(null);
		
		JPanel statsGrid = new JPanel(new GridLayout(4,1));
		
		double dmg = 0;
		int dfn = 0;
		
		if(equipment.size() == 0){
			this.setSize(200, 100);
			add(new JLabel("No items."), BorderLayout.CENTER);
		}else{
			add(FrameUpdater.chestUpdate(equipment), BorderLayout.CENTER);
		}

		
		JLabel dmgLbl = new JLabel("Damage: " + dmg);
		JLabel dfnLbl = new JLabel("Defense: " + dfn);

		statsGrid.add(dmgLbl);
		statsGrid.add(dfnLbl);
		
		add(statsGrid, BorderLayout.WEST);
		
	}
	
	
}

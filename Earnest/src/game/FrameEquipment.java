package game;

import java.awt.BorderLayout;
import java.awt.Component;
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
		this.setTitle("Equipment");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(450, equipment.size()*200);
		this.setLocationRelativeTo(null);
		
		JPanel contentGrid = new JPanel(new GridLayout(equipment.size(), 4));
		JPanel statsGrid = new JPanel(new GridLayout(4,1));
		JPanel master = new JPanel(new BorderLayout());
		
		double dmg = 0;
		int dfn = 0;
		
		if(equipment.size() == 0){
			this.setSize(200, 100);
			master.add(new JLabel("No items."), BorderLayout.CENTER);
		}else{
			
			ArrayList<Component> items = new ArrayList<>();
			
			for(int i = 0;i < equipment.size();i++){
				items.add(new WrappingLabel(equipment.get(i).getName()));
				items.add(new WrappingLabel(equipment.get(i).getDesc()));
				if(equipment.get(i) instanceof ItemSword){
					items.add(new ButtonUnequip(equipment, i));
					dmg = ((ItemSword) equipment.get(i)).getDmg();
				}
				items.add(new ButtonDrop(equipment, i));
			}
			for(Component c : items){
				contentGrid.add(c);
			}
			
			master.add(contentGrid, BorderLayout.CENTER);
		}

		
		JLabel dmgLbl = new JLabel("Damage: " + dmg);
		JLabel dfnLbl = new JLabel("Defense: " + dfn);

		statsGrid.add(dmgLbl);
		statsGrid.add(dfnLbl);
		
		master.add(statsGrid, BorderLayout.WEST);
		add(master);
	}
	
	
}

package game.Frames;

import game.WrappingLabel;
import game.Button.ButtonLevel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameLevelUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6973827085664640238L;

	public FrameLevelUp(){
		setTitle("Level up!");
		setSize(500,400);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		
		JPanel statsGrid = new JPanel(new GridLayout(3,5));
		
		int strInt = 0;
		int dexInt = 0;
		int conInt = 0;
		
		JTextField strFld = new JTextField(strInt);
			strFld.setEditable(false);
		JTextField dexFld = new JTextField(dexInt);
			dexFld.setEditable(false);
		JTextField conFld = new JTextField(conInt);
			conFld.setEditable(false);
		
		
		ArrayList<Component> components = new ArrayList<>();
		components.add(new JLabel("Strength"));
		components.add(new WrappingLabel("This stat will increase your damage."));
		components.add(new ButtonLevel(strFld, strInt, '<'));
		components.add(strFld);
		components.add(new ButtonLevel(strFld, strInt, '>'));

		components.add(new JLabel("Dexterity"));
		components.add(new WrappingLabel("This stat will increase your accuracy, and avoidence."));
		components.add(new ButtonLevel(dexFld, dexInt, '<'));
		components.add(dexFld);
		components.add(new ButtonLevel(dexFld, dexInt, '>'));

		components.add(new JLabel("Constitution"));
		components.add(new WrappingLabel("This stat will increase your health."));
		components.add(new ButtonLevel(conFld, conInt, '<'));
		components.add(conFld);
		components.add(new ButtonLevel(conFld, conInt, '>'));
		
		for(Component c : components){
			statsGrid.add(c);
		}
		
		add(statsGrid, BorderLayout.CENTER);
		
	}
}

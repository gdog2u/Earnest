package game.Frames;

import game.Items.Item;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The GUI for chests.
 * @author Geoffrey
 *
 */
public class FrameContainer extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2547598984218432993L;
	
	public FrameContainer(String title, ArrayList<Item> contents){
		
		contents = FrameUpdater.removeNulls(contents);
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, contents.size()*100);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());

		
		if(contents.isEmpty() == true){
			setSize(200, 100);
			add(new JLabel("No items."), BorderLayout.CENTER);
		}else{
			add(FrameUpdater.chestUpdate(contents), BorderLayout.CENTER);
		}
		
	}
	
}


package game;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		
		setTitle(title);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300, contents.size()*100);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		JPanel contentGrid = new JPanel(new GridLayout(contents.size(), 3));

		
		if(contents.isEmpty() == true){
			setSize(200, 100);
			add(new JLabel("No items."), BorderLayout.CENTER);
		}else{

			ArrayList<Component> items = new ArrayList<>();
			
			for(int i = 0;i < contents.size();i++){
				items.add(new WrappingLabel(contents.get(i).getName()));
				items.add(new WrappingLabel(contents.get(i).getDesc()));
				items.add(new ButtonTake(contents, i));
			}
			for(Component c : items){
				contentGrid.add(c);
			}
			add(contentGrid, BorderLayout.CENTER);
		}
		
	}
	
	/**
	 * Attempts to update the list of item shown in the frame
	 * @param contents
	 */
	public static void update(ArrayList<Item> contents){
		
	}
	
/*	public void update(){
		this.update(null);
	}*/
}


package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 * A custom button for use in the {@link FrameLevelUp} frame.
 * @author Geoffrey
 *
 */
public class ButtonLevel extends JButton {

	private static final long serialVersionUID = -7839330904449427198L;

	/**
	 * @param label The label to be modified.
	 * @param dir The direction the number in the label will be moved.</br>'>' = +1</br>'<' = -1
	 */
	public ButtonLevel(final JTextField field, final int amount, final char dir) {
		setText(dir+"");
		setSize(50, 50);
		addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(dir == '>'){
					field.setText(Integer.toString(amount+1));
				}else{
					field.setText(Integer.toString(amount-1));
				}				
			}
		});
	}
}

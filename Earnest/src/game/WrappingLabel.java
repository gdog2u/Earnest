package game;

import javax.swing.JLabel;

/**
 * A custom JLabel that wraps the text.
 * @author Geoffrey
 *
 */
public class WrappingLabel extends JLabel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5876653286734873774L;

	public WrappingLabel(String text) {
		super("<html>" + text + "</br></html>");
		// TODO Auto-generated constructor stub
	}

}

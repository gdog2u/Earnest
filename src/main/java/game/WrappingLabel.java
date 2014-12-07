package game;

import java.util.HashMap;

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
	
	/**
	 * @param name
	 * @param hexvalue
	 */
	private HashMap<String, String> colors = new HashMap<>();

	public WrappingLabel(String text) {
		super("<html>" + text + "</br></html>");
		// TODO Auto-generated constructor stub
	}
	
	public WrappingLabel(String text, String color) {
		init();
		setText("<html><font color=\"" + colors.get(color.toLowerCase()) + "\">" + text + "</br></font></html>");
	}
	
	public void init(){
		colors.put("red", "#FF0000");
		colors.put("blue", "#0000FF");
		colors.put("green", "#00FF00");
		
	}

}

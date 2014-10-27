package game;

import game.Frames.FrameMainGame;

/**
 * The main class for the program.
 * @author Geoffrey
 *
 */
public class GameEarnest {
	
	public static void main(String[] args){
		mainMenu();
	}
	
	/**
	 * Begins the program.
	 */
	public static void mainMenu(){
		FrameMainGame game = new FrameMainGame();
		game.updateStats();
	}
}

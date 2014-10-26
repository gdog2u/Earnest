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
	
	public static void mainMenu(){
		
		/*hero.setName("What is the hero's name?");
		System.out.println(hero.getStats());
		Room r = new Room();
		r.startRoom();*/
		
		FrameMainGame game = new FrameMainGame();
		game.updateStats();
	}
}

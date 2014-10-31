package game;

import game.Frames.FrameMainGame;
import game.Items.Item;

import java.util.ArrayList;
import java.util.Random;

/**
 * Object for rooms for the dungeon.
 * @author Geoffrey
 *
 */
public class Room {
	
	Random r = new Random();
	
	private ArrayList<Container> containersList = new ArrayList<>();
	private boolean hasEnemies = false;
	
	public Room(){
		genChests();
		System.out.println("done");
	}
	
	public void genChests(){
		for(int i = 0; i < 1; i++){
			int chance = r.nextInt(25);
			if(chance <= FrameMainGame.getHero().getLuck()){
				containersList.add(new Container());
					containersList.get(containersList.size()-1).genInv(FrameMainGame.getHero().getLevel(), FrameMainGame.getHero().getLuck(), Item.randomPool());
					containersList.get(containersList.size()-1).getContents();
			}else{
				System.out.println("failed");
			}
		}
	}

	public boolean getHasEnemies() {
		return hasEnemies;
	}

	public void setHasEnemies(boolean hasEnemies) {
		this.hasEnemies = hasEnemies;
	}
	
}

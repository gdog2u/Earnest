package game;

import game.Frames.FrameMainGame;

import java.util.ArrayList;
import java.util.Random;

/**
 * Object for rooms for the dungeon.
 * @author Geoffrey
 *
 */
public class Room {
	
	Random r = new Random();
	
	ArrayList<Container> containersList = new ArrayList<>();
	ArrayList<Enemy> enemyList = new ArrayList<>();
	
	public Room(){
		genChests();
	}
	
	public void genChests(){
		for(int i = 0; i < 3; i++){
			int chance = r.nextInt(25);
			if(chance >= FrameMainGame.getHero().getLuck()+9){
				containersList.add(new Container());
			}
		}
	}
	
	public boolean hasEnemies(){
		return !enemyList.isEmpty();
	}
	
	public boolean hasChest(){
		return !containersList.isEmpty();
	}
	
}

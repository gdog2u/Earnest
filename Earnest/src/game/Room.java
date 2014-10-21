package game;

import game.Item.*;
import java.util.ArrayList;

public class Room {
	public Room(){
		
	}
	
	public void startRoom(){ //only used for the first room
		ArrayList<Item> start = new ArrayList<Item>();
		start.add(new ItemKey());
		start.add(new ItemSword(toolType.WOOD));
		start.add(new ItemFood(foodType.BREAD));
		
//		Container c = new Container(start);
		//before the GUI
/*		System.out.println("-------------\nYou are currently in your cell. The door is locked, but the hero always finds their way out\nThere's a stool, a small bucket, and small crate in the room.\nWhat will you do?\n1.) Sit on the stool. Maybe someone will come.\n2.) Check the crate for anything.\n3.) Bang on the doors until a guard comes.");
		Scanner in = new Scanner(System.in);
		int opt = in.nextInt();
		switch(opt){
		case 1:
			System.out.println("No one comes. You are forgotten in time along with any greatness you could've accomplished.");
			System.exit(0);
		case 2:
			c.open();
		}*/
	}
	
}

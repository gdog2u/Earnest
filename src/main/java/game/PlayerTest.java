package game;

import game.Items.Item;

public class PlayerTest {

	public static void main(String[] args) {
		Player tester = new Player();
		//tester.levelUp();
//		tester.testInventory();
//		tester.showInventory();
		Container testCont = new Container();
		testCont.genInv(1, 12, Item.poolType.COMMON);
		testCont.open();
	}

}

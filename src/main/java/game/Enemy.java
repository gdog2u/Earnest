package game;

import game.Items.Item;

import java.util.ArrayList;

public abstract class Enemy {

	private double health;
	private double dmg;
	private ArrayList<Item> loot = new ArrayList<>();
	
	public double getHealth(){
		return health;
	}
	
	public double getDamage(){
		return dmg;
	}
}

package game.Frames;

import game.WrappingLabel;
import game.Button.ButtonBuy;
import game.Button.ButtonDrop;
import game.Button.ButtonEat;
import game.Button.ButtonEquip;
import game.Button.ButtonSell;
import game.Button.ButtonTake;
import game.Button.ButtonUnequip;
import game.Items.Item;
import game.Items.ItemArmor;
import game.Items.ItemFood;
import game.Items.ItemSword;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A class to later be used to push updates to the frames.
 * @author Geoffrey
 *
 */
public class FrameUpdater{
	
	/**
	 * Returns the bulk of the {@link FrameInventory} gui
	 * @param inv
	 * @return inventory grid
	 */
	public static JPanel inventoryUpdate(ArrayList<Item> inv){
		
		JPanel contentGrid = new JPanel(new GridLayout(inv.size(),4));
		ArrayList<Component> items = new ArrayList<>();
		
		for(int i = 0;i < inv.size();i++){
			items.add(new WrappingLabel(inv.get(i).getName()));
			items.add(new WrappingLabel(inv.get(i).getDesc()));
			if(inv.get(i) instanceof ItemSword || inv.get(i) instanceof ItemArmor){
				items.add(new ButtonEquip(inv, i));
			}else if(inv.get(i) instanceof ItemFood){
				items.add(new ButtonEat(inv, i));
			}
			items.add(new ButtonDrop(inv, i));
		}
		for(Component c : items){
			contentGrid.add(c);
		}
		return contentGrid;
	}
	
	/**
	 * Returns the bulk of the {@link FrameContainer} qui
	 * @param contents
	 * @return content grid
	 */
	public static JPanel chestUpdate(ArrayList<Item> contents){
		
		JPanel contentGrid =new JPanel(new GridLayout(contents.size(), 3));

		ArrayList<Component> items = new ArrayList<>();
		
		for(int i = 0;i < contents.size();i++){
			items.add(new WrappingLabel(contents.get(i).getName()));
			items.add(new WrappingLabel(contents.get(i).getDesc()));
			items.add(new ButtonTake(contents, i));
		}
		for(Component c : items){
			contentGrid.add(c);
		}
		
		return contentGrid;
	}
	
	/**
	 * Returns the bulk of the {@link FrameEquipment} gui
	 * @param equip
	 * @return equipment grid
	 */
	public static JPanel equipmentUpdate(ArrayList<Item> equip){
		
		JPanel contentGrid = new JPanel(new GridLayout(equip.size(), 4));
		ArrayList<Component> items = new ArrayList<>();
		@SuppressWarnings("unused")
		double dmg = 0;
		
		for(int i = 0;i < equip.size();i++){
			items.add(new WrappingLabel(equip.get(i).getName()));
			items.add(new WrappingLabel(equip.get(i).getDesc()));
			if(equip.get(i) instanceof ItemSword){
				items.add(new ButtonUnequip(equip, i));
				dmg = ((ItemSword) equip.get(i)).getDmg();
			}
			items.add(new ButtonDrop(equip, i));
		}
		for(Component c : items){
			contentGrid.add(c);
		}
		return contentGrid;
	}
	
	/**
	 * Returns the bulk of the {@link FrameShop} gui
	 * @param toBuy
	 * @param panelHeight
	 * @return the Shop grid.
	 */
	public static JPanel shopUpdate(ArrayList<Item> toSell, ArrayList<Item> toBuy, int panelHeight){

		JPanel master = new JPanel(new BorderLayout());
		JPanel shopGrid = new JPanel(new GridLayout(panelHeight, 3));
		JPanel playerGrid = new JPanel(new GridLayout(panelHeight, 3));
		
		if(toSell.isEmpty()){
			playerGrid.setLayout(new GridLayout());
			playerGrid.add(new JLabel("Nothing to sell."));
			master.add(playerGrid, BorderLayout.WEST);
		}else{
			for(int i = 0; i < toSell.size(); i++){
				playerGrid.add(new WrappingLabel(toSell.get(i).getName()));
				playerGrid.add(new WrappingLabel(toSell.get(i).getCost() + " gold"));
				playerGrid.add(new ButtonSell(toSell, i));
			}
			for(int i = 0; i < (panelHeight - toSell.size()); i++){
				playerGrid.add(new JLabel());
			}
		}
		
		if(toBuy.isEmpty()){
			shopGrid.setLayout(new GridLayout());
			shopGrid.add(new JLabel("Nothing to buy."));
			master.add(shopGrid, BorderLayout.EAST);
		}else{
			for(int i = 0;i < toBuy.size(); i++){
				toBuy.get(i).setCost((int) (toBuy.get(i).getCost() * 1.3));
			}
			for(int i = 0; i < toBuy.size(); i++){
				shopGrid.add(new WrappingLabel(toBuy.get(i).getName()));
				shopGrid.add(new WrappingLabel(toBuy.get(i).getCost() + " gold"));
				shopGrid.add(new ButtonBuy(toBuy, i));
			}
			for(int i = 0; i < (panelHeight - toBuy.size()); i++){
				shopGrid.add(new JLabel());
			}
		}
		
		master.add(playerGrid, BorderLayout.WEST);
		master.add(shopGrid, BorderLayout.EAST);
		
		return master;
	}
	
	/**
	 * Removes nulls from ArrayLists in order to clean things up.
	 * @param withNulls
	 * @return clean ArrayList
	 */
	public static ArrayList<Item> removeNulls(ArrayList<Item> withNulls){
		for(int i = 0; i < withNulls.size(); i++){
			if(withNulls.get(i) == null){
				withNulls.remove(i);
			}
		}
		return withNulls;
	}
	
}

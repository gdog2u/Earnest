package game.Frames;

import game.WrappingLabel;
import game.Button.ButtonDrop;
import game.Button.ButtonEat;
import game.Button.ButtonEquip;
import game.Button.ButtonTake;
import game.Items.Item;
import game.Items.ItemArmor;
import game.Items.ItemFood;
import game.Items.ItemSword;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * A class to later be used to push updates to the frames.
 * @author Geoffrey
 *
 */
public class FrameUpdater{
	
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
	
	public static JPanel chestUpdate(ArrayList<Item> contents){
		contents = removeNulls(contents);
		
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
	
	public static ArrayList<Item> removeNulls(ArrayList<Item> withNulls){
		for(int i = 0; i < withNulls.size(); i++){
			if(withNulls.get(i) == null){
				withNulls.remove(i);
			}
		}
		return withNulls;
	}
	
}

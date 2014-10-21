package game;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameMainGame{

	private static Player hero = new Player();
	private String breaker = "\n-----------------------------------------------------------------------------------------------------\n";

	private static JFrame window = new JFrame();
	private static JPanel master = new JPanel(new BorderLayout());
	private static JPanel stats= new JPanel();
	private static JPanel buttonPnl = new JPanel();

	private static JTextArea main = new JTextArea(30,50);
	
	private JLabel nameLbl = new JLabel("Name");
	private JLabel name = new JLabel();
	private JLabel healthLbl = new JLabel("Current Health");
	private JLabel health = new JLabel();
	private JLabel strenLbl = new JLabel("Strength");
	private JLabel strength = new JLabel();
	private JLabel constLbl = new JLabel("Constitution");
	private JLabel constitution =  new JLabel();
	private JLabel luckLbl = new JLabel("Luck");
	private JLabel luck = new JLabel();
	private JLabel lvlLbl = new JLabel("Level");
	private JLabel level = new JLabel();
	private JLabel expLbl = new JLabel("Experience");
	private JLabel experience = new JLabel();
	private JButton inventBtn = new JButton("Inventory");
	private JButton equipmBtn = new JButton("Equipment");
	
	
	FrameMainGame (){

//		hero.testInventory();
		
		window.setTitle("Earnest");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800, 640);
		window.setVisible(true);
		window.setLocationRelativeTo(null);
		
		stats.setLayout(new GridLayout(9,2));
			stats.add(nameLbl);
			stats.add(name);
			stats.add(healthLbl);
			stats.add(health);
			stats.add(strenLbl);
			stats.add(strength);
			stats.add(constLbl);
			stats.add(constitution);
			stats.add(luckLbl);
			stats.add(luck);
			stats.add(lvlLbl);
			stats.add(level);
			stats.add(expLbl);
			stats.add(experience);
			stats.add(inventBtn);
				inventBtn.addActionListener(new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent arg0){
						hero.showInventory();
					}
					
				});
			stats.add(equipmBtn);
				equipmBtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						hero.showEquipment();
					}
				});
				
		buttonPnl.setLayout(new GridLayout(1,2));
			/*JButton beginBtn = new JButton("Begin");
			buttonPnl.add(beginBtn);*/
		
			JButton openShop = new JButton("Go into shop.");
				openShop.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						FrameShop fs = new FrameShop(hero.getInventory());
						fs.setVisible(true);
						
					}
				});
			JButton openChest = new JButton("Open Chest.");
				openChest.addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Container c = new Container();
						c.genInv(hero.getLevel(), hero.getLuck(), Item.poolType.COMMON);
						c.open();
					}
				
				});
			buttonPnl.add(openChest);
			buttonPnl.add(openShop);
		
		master.add(stats, BorderLayout.WEST);
		master.add(buttonPnl, BorderLayout.SOUTH);	
		master.add(new JScrollPane(main), BorderLayout.CENTER);
		
		window.add(master);
		
		hero.setName(JOptionPane.showInputDialog("What is the hero's name?"));	
		
		main.setEditable(false);
		main.append("Welcome to Earnest. You, "+ hero.getName() + ", are the hero.\nThrough reasons unimportant you have landed yourself in jail.\nYour goal is to escape this prison, and save the world.");
		main.append(breaker);
	}
	
	public void updateStats(){
		name.setText(hero.getName());
		health.setText(Integer.toString(hero.getCurHealth()));
		strength.setText(Integer.toString(hero.getStrength()));
		constitution.setText(Integer.toString(hero.getConstitution()));
		luck.setText(Integer.toString(hero.getLuck()));
		level.setText(Integer.toString(hero.getLevel()));
		experience.setText(Integer.toString(hero.getExperience()));
	}

	
	/**
	 * @return the player.
	 */
	public static Player getHero(){
		return hero;
	}

	/**
	 * Is called when the player's heath reaches 0
	 */
	public static void gameOver(){
		JButton replayBtn = new JButton("Exit");
		main.append("You have perished. Along with you goes all the great things you could've accomplished.\nThe women you could've swooned. All the dragon's you could've slayed. None of that will happen now.\nIf you wish to try again, feel free. No one likes a quitter.");
		buttonPnl.removeAll();
		buttonPnl.setLayout(new GridLayout(1,1));
		buttonPnl.add(replayBtn);
			replayBtn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					window.dispose();
				}
				
			});
		stats.setVisible(false);
	}
}

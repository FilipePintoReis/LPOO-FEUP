package dkeep.gui;

import dkeep.cli.*;
import dkeep.logic.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;

public class Main_Window {

	private JFrame main_window;
	private JTextField fieldOgres;
	private JLabel labelGuardPersonality;
	private JButton btnExitGame;
	
	Game game = new Game();
	Input userInput = new Input();
	boolean gameInitialized = false;
	String guardPersonalityInput, ogreNumberInput;
	
	String getGameStatusMessage(){
		String gameMessage = "Produto trazido até si por Estrugido & Afilhiados™";
		if(game.checkGameOver()){
			if(game.getCurrentLevel().getHero().isCaptured())
				gameMessage = "Você padeceu perante as circunstâncias adversas.";
			else gameMessage = "Você é o ganhador, o seu espírito foi enaltecido.";
		} 
		return gameMessage;
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Window window = new Main_Window();
					window.main_window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		main_window = new JFrame();
		main_window.setBounds(100, 100, 520, 440);
		main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_window.getContentPane().setLayout(null);
		
		fieldOgres = new JTextField();
		fieldOgres.setBounds(135, 11, 149, 23);
		main_window.getContentPane().add(fieldOgres);
		fieldOgres.setColumns(10);
		
		JLabel labelNrOgres = new JLabel("Number of Ogres:");
		labelNrOgres.setBounds(10, 11, 115, 23);
		main_window.getContentPane().add(labelNrOgres);
		
		labelGuardPersonality = new JLabel("Guard personality: ");
		labelGuardPersonality.setBounds(10, 45, 115, 23);
		main_window.getContentPane().add(labelGuardPersonality);
		
		JComboBox comboBoxPersonalities = new JComboBox();
		comboBoxPersonalities.addItem("Rookie");
		comboBoxPersonalities.addItem("Zealous");
		comboBoxPersonalities.addItem("Drunk");
		comboBoxPersonalities.setBounds(135, 45, 149, 22);
		main_window.getContentPane().add(comboBoxPersonalities);
		
		JTextArea textAreaConsole = new JTextArea();
		textAreaConsole.setEditable(false);
		if(gameInitialized)
			textAreaConsole.setText(game.getCurrentMapString());
		textAreaConsole.setFont(new Font("Courier New", Font.PLAIN, 24));
		textAreaConsole.setBounds(10, 79, 289, 277);
		main_window.getContentPane().add(textAreaConsole);
		
		JLabel labelStatus = new JLabel("New label");
		labelStatus.setText("Produto trazida até si por Estrugido & Afilhiados™");
		labelStatus.setBounds(10, 367, 289, 23);
		main_window.getContentPane().add(labelStatus);
		
		JButton btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.play("w");
				textAreaConsole.setText(game.getCurrentMapString());
				labelStatus.setText(getGameStatusMessage());
			}
		});
		btnUp.setBounds(324, 162, 157, 23);
		main_window.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				game.play("s");
				textAreaConsole.setText(game.getCurrentMapString());
				labelStatus.setText(getGameStatusMessage());
			}
		});
		btnDown.setBounds(324, 212, 157, 23);
		main_window.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setEnabled(false);
		btnLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				game.play("a");
				textAreaConsole.setText(game.getCurrentMapString());
				labelStatus.setText(getGameStatusMessage());
			}
		});
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setBounds(324, 186, 73, 23);
		main_window.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.setEnabled(false);
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				game.play("d");
				textAreaConsole.setText(game.getCurrentMapString());
				labelStatus.setText(getGameStatusMessage());
			}
		});
		btnRight.setBounds(407, 186, 74, 23);
		main_window.getContentPane().add(btnRight);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Game newGame = new Game();
				
				int nrOgres, nrGuards, nrKeys, nrLevers, nrClubs;
				nrKeys = 1;
				nrLevers = 1;
				nrClubs = 1;
				
				ogreNumberInput = fieldOgres.getText();
				
				if(!ogreNumberInput.matches("[0-9]*") | ogreNumberInput.equals(null)) //dude why
					nrOgres = 1;
				else nrOgres = Integer.parseInt(ogreNumberInput);
				
				System.out.println(ogreNumberInput.matches("[0-9]*"));
				
				guardPersonalityInput = labelGuardPersonality.getText();
				
				//level 0
				ArrayList<Ogre> ogres0 = new ArrayList();
				ArrayList<Guard> guards0 = new ArrayList();
				ArrayList<Key> keys0 = new ArrayList();
				ArrayList<Lever> levers0 = new ArrayList();
				ArrayList<Club> clubs0 = new ArrayList();
				
				char empty_map0[][] = { { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
									   { 'X', ' ', ' ', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
									   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
									   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
									   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', 'X' },
									   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
									   { 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
									   { 'X', 'X', 'X', ' ', 'X', 'X', 'X', 'X', ' ', 'X' },
									   { 'X', ' ', 'I', ' ', 'I', ' ', 'X', ' ', ' ', 'X' },
									   { 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
				char[] guard_pattern = { 'a', 's', 's', 's', 's', 'a', 'a', 'a', 'a', 'a', 'a', 's', 'd', 'd', 'd', 'd', 'd',
				'd', 'd', 'w', 'w', 'w', 'w', 'w' };
				Hero hero0 = new Hero(1,1);
				Map map0 = new Map(empty_map0);
				guards0.add(new Guard(1, 8, guard_pattern, guardPersonalityInput));
				levers0.add(new Lever(8,7));
				Level level0 = new Level(hero0, map0, guards0, ogres0, levers0, keys0, clubs0);
				newGame.getLevels().add(level0);
				//end of level0
				
				//level1
				ArrayList<Guard> guards1 = new ArrayList<Guard>();
				ArrayList<Ogre> ogres1 = new ArrayList<Ogre>();
				ArrayList<Key> keys1 = new ArrayList<Key>();
				ArrayList<Lever> levers1 = new ArrayList<Lever>();
				ArrayList<Club> clubs1 = new ArrayList<Club>();
				
				char empty_map1[][] = {
						{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' },
						{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'I', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'X' },
						{ 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X' } };
				Map map1 = new Map(empty_map1);
				Hero hero1 = new Hero(1,1);
				
				for(int i=0; i < nrOgres; i++){
					ogres1.add(new Ogre(5, 5));
				}
				keys1.add(new Key(8,7));
				clubs1.add(new Club(1,2));
				
				Level level1 = new Level(hero1, map1, guards1, ogres1, levers1, keys1, clubs1);
				newGame.getLevels().add(level1); 
				//end of level1
				
				game = newGame;
				gameInitialized = true;
				
				textAreaConsole.setText(game.getCurrentMapString());
				
				btnUp.setEnabled(true);
				btnDown.setEnabled(true);
				btnLeft.setEnabled(true);
				btnRight.setEnabled(true);
				fieldOgres.setEditable(false);
				comboBoxPersonalities.setEnabled(false);
			}
		});
		btnNewGame.setBounds(324, 11, 157, 23);
		main_window.getContentPane().add(btnNewGame);
		
		btnExitGame = new JButton("Exit");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		btnExitGame.setBounds(324, 45, 158, 23);
		main_window.getContentPane().add(btnExitGame);		
	}
}

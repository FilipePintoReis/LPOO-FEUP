package dkeep.gui;

import dkeep.cli.*;
import dkeep.logic.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JPanel;

public class Main_Window {
	
	private JFrame main_window;
	private JLabel labelGuardPersonality;
	private JComboBox comboBoxPersonalities = new JComboBox();
	private JTextField fieldOgres = new JTextField();

	private JButton btnExitGame;
	private JButton btnUp = new JButton("Up");
	private JButton btnDown = new JButton("Down");
	private JButton btnLeft = new JButton("Left");
	private JButton btnRight = new JButton("Right");;
	
	Game game = new Game();	
	private SpritePanel panelGraphics = new SpritePanel(32);
	
	Input userInput = new Input();
	boolean gameInitialized = false;
	String guardPersonalityInput, ogreNumberInput;
	boolean gotKey = true, gotWeapon = true, unactivatedLever = true, changedLevel = true;

	String getGameStatusMessage(){
		String gameMessage = "Produto trazido até si por Goldmans and Sach & Afilhiados™";
		if(game.getCurrentLevel().getHero().hasWeapon() & gotWeapon){
			gameMessage = "Você tem em sua posse um avantajado maçarico.";
			gotWeapon = false;
			return gameMessage;
		}
		if(game.getCurrentLevel().getHero().hasKey() & gotKey){
			gameMessage = "Você tem em sua posse uma pacata chave.";
			gotKey = false;
			return gameMessage;
		}
		for(int i=0; i < game.getCurrentLevel().getLevers().size(); i++){
			if(game.getCurrentLevel().getLevers().get(i).getState()){
				gameMessage = "Você accionou uma alavanca. Prossiga.";
				unactivatedLever = false;
				return gameMessage;
			}
		}
		if(game.checkGameOver())
			gameMessage = "Você padeceu perante as circunstâncias adversas.";
		if(game.checkLevelsFinished())
			gameMessage = "Você é o ganhador, o seu espírito foi enaltecido.";
		return gameMessage;
	}
	
	void resetGame(){
		if(game.checkGameOver() | game.checkLevelsFinished())
			 game.resetGame();
	}
	
	void enableControls(){
		btnUp.setEnabled(true);
		btnDown.setEnabled(true);
		btnLeft.setEnabled(true);
		btnRight.setEnabled(true);
		fieldOgres.setEnabled(false);
		comboBoxPersonalities.setEnabled(false);
	}
	
	void disableControls(){
		btnUp.setEnabled(false);
		btnDown.setEnabled(false);
		btnLeft.setEnabled(false);
		btnRight.setEnabled(false);
		fieldOgres.setEnabled(true);
		comboBoxPersonalities.setEnabled(true);
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
		main_window.setBounds(100, 100, 520, 527);
		main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_window.getContentPane().setLayout(null);
		
		fieldOgres.setBounds(135, 11, 149, 23);
		main_window.getContentPane().add(fieldOgres);
		fieldOgres.setColumns(10);
		
		JLabel labelNrOgres = new JLabel("Number of Ogres:");
		labelNrOgres.setBounds(10, 11, 115, 23);
		main_window.getContentPane().add(labelNrOgres);
		
		labelGuardPersonality = new JLabel("Guard personality: ");
		labelGuardPersonality.setBounds(10, 45, 115, 23);
		main_window.getContentPane().add(labelGuardPersonality);
		
		comboBoxPersonalities.addItem("rookie");
		comboBoxPersonalities.addItem("zealous");
		comboBoxPersonalities.addItem("drunk");
		comboBoxPersonalities.setBounds(135, 45, 149, 22);
		main_window.getContentPane().add(comboBoxPersonalities);
		
		JTextArea textAreaConsole = new JTextArea();
		textAreaConsole.setEnabled(false);
		textAreaConsole.setEditable(false);
		//textAreaConsole.setText(game.getCurrentMapString());
		textAreaConsole.setFont(new Font("Courier New", Font.PLAIN, 24));
		textAreaConsole.setBounds(10, 79, 346, 364);
		main_window.getContentPane().add(textAreaConsole);
		
		panelGraphics.setBounds(10, 79, 346, 364);
		main_window.getContentPane().add(panelGraphics);
		
		JLabel labelStatus = new JLabel("New label");
		labelStatus.setText("Produto trazido até si por Goldmans and Sach & Afilhiados™");
		labelStatus.setBounds(10, 454, 471, 23);
		main_window.getContentPane().add(labelStatus);
		
		//btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.play("w");
				//textAreaConsole.setText(game.getCurrentMapString());
				panelGraphics.repaint();
				panelGraphics.requestFocusInWindow();
				labelStatus.setText(getGameStatusMessage());
				if(game.checkGameOver()){
					labelStatus.setText("Você padeceu perante as circunstâncias adversas.");
					disableControls();
					game.resetGame();
					//textAreaConsole.setText(game.getPreviousMapString());
				}
				if(game.checkLevelsFinished()){
					labelStatus.setText("Você é o ganhador, o seu espírito foi enaltecido por esta experiência.");
					disableControls();
					game.resetGame();
				}
			}
			
		});
		btnUp.setBounds(366, 305, 128, 23);
		main_window.getContentPane().add(btnUp);
		
		//JButton btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				game.play("s");
				//textAreaConsole.setText(game.getCurrentMapString());
				panelGraphics.repaint();
				panelGraphics.requestFocusInWindow();
				labelStatus.setText(getGameStatusMessage());
				if(game.checkGameOver()){
					labelStatus.setText("Você padeceu perante as circunstâncias adversas.");
					disableControls();
					game.resetGame();
					//textAreaConsole.setText(game.getPreviousMapString());
				}
				if(game.checkLevelsFinished()){
					labelStatus.setText("Você é o ganhador, o seu espírito foi enaltecido por esta experiência.");
					game.resetGame();
					disableControls();
				}
			}
		});
		btnDown.setBounds(366, 345, 128, 23);
		main_window.getContentPane().add(btnDown);
		
		//JButton btnLeft = new JButton("Left");
		btnLeft.setEnabled(false);
		btnLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				game.play("a");
				//textAreaConsole.setText(game.getCurrentMapString());
				panelGraphics.repaint();
				panelGraphics.requestFocusInWindow();
				labelStatus.setText(getGameStatusMessage());
				if(game.checkGameOver()){
					labelStatus.setText("Você padeceu perante as circunstâncias adversas.");
					disableControls();
					game.resetGame();
					//textAreaConsole.setText(game.getPreviousMapString());
				}
				if(game.checkLevelsFinished()){
					labelStatus.setText("Você é o ganhador, o seu espírito foi enaltecido por esta experiência.");
					game.resetGame();
					disableControls();
				}
			}
		});
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setBounds(366, 325, 64, 23);
		main_window.getContentPane().add(btnLeft);
		
		//JButton btnRight = new JButton("Right");
		btnRight.setEnabled(false);
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				game.play("d");
				//textAreaConsole.setText(game.getCurrentMapString());
				panelGraphics.repaint();
				panelGraphics.requestFocusInWindow();
				labelStatus.setText(getGameStatusMessage());
				if(game.checkGameOver()){
					labelStatus.setText("Você padeceu perante as circunstâncias adversas.");
					disableControls();
					game.resetGame();
					//textAreaConsole.setText(game.getPreviousMapString());
				}
				if(game.checkLevelsFinished()){
					labelStatus.setText("Você é o ganhador, o seu espírito foi enaltecido por esta experiência.");
					game.resetGame();
					disableControls();
				}
			}
		});
		btnRight.setBounds(430, 325, 64, 23);
		main_window.getContentPane().add(btnRight);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int nrOgres = 0, nrGuards, nrKeys, nrLevers, nrClubs;
				nrKeys = 1;
				nrLevers = 1;
				nrClubs = 1;
				
				try{
				Scanner sc = new Scanner(fieldOgres.getText());
				nrOgres = sc.nextInt();
				
				if(nrOgres <= 0){
					throw new NoSuchElementException();
					}
				if(nrOgres > 5){
					throw new NoSuchElementException();
				}
				}
				catch(NoSuchElementException ex){
					fieldOgres.setText("1");
					nrOgres = 1;
					
				}
						
				
				guardPersonalityInput = (String) comboBoxPersonalities.getSelectedItem();
								
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
				game.getLevels().add(level0);
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
				game.getLevels().add(level1); 
				//end of level1
				
				gameInitialized = true;
				
				//textAreaConsole.setText(game.getCurrentMapString());
				panelGraphics.requestFocusInWindow();
				panelGraphics.setGame(game);
				panelGraphics.repaint();
				
				enableControls();
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

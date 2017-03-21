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
	
	Game game;
	Input userInput;
	boolean gameInitialized = false;
	String guardPersonalityInput, ogreNumberInput;

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
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Ogre> ogres = new ArrayList();
				ArrayList<Guard> guards = new ArrayList();
				ArrayList<Key> keys = new ArrayList();
				ArrayList<Lever> levers = new ArrayList();
				ArrayList<Club> clubs = new ArrayList();
				
				int nrOgres, nrGuards, nrKeys, nrLevers, nrClubs;
				nrKeys = 1;
				nrLevers = 1;
				nrClubs = 1;
				
				ogreNumberInput = fieldOgres.getText();
				if(!ogreNumberInput.matches("[0-9]*"))
					nrOgres = 1;
				else nrOgres = Integer.parseInt(ogreNumberInput);
				
				guardPersonalityInput = labelGuardPersonality.getText();
				
				gameInitialized = true;
				fieldOgres.setEditable(false);
				labelGuardPersonality.setEnabled(false);
				//get ogre number and create them
				//get guard personality and create it
				//create both levels
				//initialize game
			}
		});
		btnNewGame.setBounds(405, 11, 89, 23);
		main_window.getContentPane().add(btnNewGame);
		
		btnExitGame = new JButton("Exit");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		btnExitGame.setBounds(405, 45, 89, 23);
		main_window.getContentPane().add(btnExitGame);
		
		JTextArea textAreaConsole = new JTextArea();
		if(gameInitialized)
			textAreaConsole.setText(game.getCurrentMapString());
		textAreaConsole.setFont(new Font("Courier New", Font.PLAIN, 13));
		textAreaConsole.setBounds(10, 79, 289, 277);
		main_window.getContentPane().add(textAreaConsole);
		  
		JButton btnUp = new JButton("Up");
		btnUp.setEnabled(false);
		btnUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(gameInitialized){
					btnUp.setEnabled(true);
					game.getCurrentLevel().getHero().moveEntity("w");
				}
			}
		});
		btnUp.setBounds(369, 163, 59, 23);
		main_window.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.setEnabled(false);
		btnDown.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				if(gameInitialized){
					btnDown.setEnabled(true);
					game.getCurrentLevel().getHero().moveEntity("s");
				}
			}
		});
		btnDown.setBounds(369, 210, 59, 23);
		main_window.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.setEnabled(false);
		btnLeft.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(gameInitialized){
					btnLeft.setEnabled(true);
					game.getCurrentLevel().getHero().moveEntity("a");
				}
			}
		});
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setBounds(309, 186, 59, 23);
		main_window.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.setEnabled(false);
		btnRight.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(gameInitialized){
					btnRight.setEnabled(true);
					game.getCurrentLevel().getHero().moveEntity("d");
				}
			}
		});
		btnRight.setBounds(428, 186, 66, 23);
		main_window.getContentPane().add(btnRight);
		
		JLabel labelStatus = new JLabel("New label");
		labelStatus.setBounds(10, 367, 175, 23);
		main_window.getContentPane().add(labelStatus);
	}
}

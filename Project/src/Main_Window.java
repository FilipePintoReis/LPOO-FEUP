package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
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
		main_window.setBounds(100, 100, 450, 300);
		main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main_window.getContentPane().setLayout(null);
		
		fieldOgres = new JTextField();
		fieldOgres.setBounds(116, 11, 149, 23);
		main_window.getContentPane().add(fieldOgres);
		fieldOgres.setColumns(10);
		
		JLabel labelNrOgres = new JLabel("Number of Ogres:");
		labelNrOgres.setBounds(10, 11, 96, 23);
		main_window.getContentPane().add(labelNrOgres);
		
		labelGuardPersonality = new JLabel("Guard personality: ");
		labelGuardPersonality.setBounds(10, 45, 96, 23);
		main_window.getContentPane().add(labelGuardPersonality);
		
		JComboBox comboBoxPersonalities = new JComboBox();
		comboBoxPersonalities.setBounds(116, 45, 149, 22);
		main_window.getContentPane().add(comboBoxPersonalities);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewGame.setBounds(321, 11, 89, 23);
		main_window.getContentPane().add(btnNewGame);
		
		btnExitGame = new JButton("Exit");
		btnExitGame.setBounds(321, 45, 89, 23);
		main_window.getContentPane().add(btnExitGame);
		
		JTextArea textAreaConsole = new JTextArea();
		textAreaConsole.setFont(new Font("Courier New", Font.PLAIN, 13));
		textAreaConsole.setBounds(10, 79, 220, 171);
		main_window.getContentPane().add(textAreaConsole);
		
		JButton btnUp = new JButton("Up");
		btnUp.setBounds(305, 111, 59, 23);
		main_window.getContentPane().add(btnUp);
		
		JButton btnDown = new JButton("Down");
		btnDown.setBounds(305, 152, 59, 23);
		main_window.getContentPane().add(btnDown);
		
		JButton btnLeft = new JButton("Left");
		btnLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeft.setBounds(365, 132, 59, 23);
		main_window.getContentPane().add(btnLeft);
		
		JButton btnRight = new JButton("Right");
		btnRight.setBounds(240, 132, 66, 23);
		main_window.getContentPane().add(btnRight);
		
		JLabel labelStatus = new JLabel("New label");
		labelStatus.setBounds(240, 186, 184, 56);
		main_window.getContentPane().add(labelStatus);
	}
}

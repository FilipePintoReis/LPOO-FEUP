package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
//import net.miginfocom.swing.MigLayout;

public class Menu_Window {

	private JFrame Menu_Window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Window window = new Menu_Window();
					window.Menu_Window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Menu_Window = new JFrame();
		Menu_Window.getContentPane().setFont(new Font("Leelawadee", Font.BOLD, 19));
		Menu_Window.setBackground(Color.CYAN);
		Menu_Window.setTitle("The legend of the half-prince racoon, Leya");
		Menu_Window.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 25));
		Menu_Window.getContentPane().setBackground(Color.YELLOW);
		//Menu_Window.getContentPane().setLayout(new MigLayout("", "[117px][][][][][][][][][][][][][][][]", "[33px][33px][23px][][][][][][][][]"));
		
		JButton btnNewButton_1 = new JButton("New game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Window main = new Main_Window();
			}
		});
		
		JButton btnNewButton = new JButton("Create a level");
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Agency FB", Font.PLAIN, 19));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.CYAN);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Menu_Window.getContentPane().add(btnNewButton, "cell 7 0,alignx center,aligny bottom");
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setFont(new Font("Agency FB", Font.PLAIN, 19));
		Menu_Window.getContentPane().add(btnNewButton_1, "cell 15 0,alignx center,aligny bottom");
		
		JButton btnNewButton_2 = new JButton("Exit this virtual demonstration");
		btnNewButton_2.setFont(new Font("Agency FB", Font.PLAIN, 19));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		Menu_Window.getContentPane().add(btnNewButton_2, "cell 11 10,alignx center,aligny center");
		Menu_Window.setBounds(100, 100, 653, 330);
		Menu_Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Menu_Window {

	private JFrame menu_window;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_Window window = new Menu_Window();
					window.menu_window.setVisible(true);
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
		menu_window = new JFrame();
		menu_window.getContentPane().setFont(new Font("Leelawadee", Font.BOLD, 19));
		menu_window.setBackground(Color.CYAN);
		menu_window.setTitle("The legend of the half-prince racoon, Leya");
		menu_window.setFont(new Font("Elephant", Font.BOLD | Font.ITALIC, 25));
		menu_window.getContentPane().setBackground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("New game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main_Window main = new Main_Window();
				main.main(null);
				menu_window.dispose();
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
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.setFont(new Font("Agency FB", Font.PLAIN, 19));
		
		JButton btnNewButton_2 = new JButton("Exit this virtual demonstration");
		btnNewButton_2.setFont(new Font("Agency FB", Font.PLAIN, 19));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		GroupLayout groupLayout = new GroupLayout(menu_window.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(467, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(77))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(373)
					.addComponent(btnNewButton_2)
					.addContainerGap(59, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(284, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(242))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(21)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(49)
					.addComponent(btnNewButton_1)
					.addGap(61))
		);
		menu_window.getContentPane().setLayout(groupLayout);
		menu_window.setBounds(100, 100, 653, 330);
		menu_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
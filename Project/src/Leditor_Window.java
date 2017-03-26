package dkeep.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;


public class Leditor_Window {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leditor_Window window = new Leditor_Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Leditor_Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 797, 432);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 432, 371);
		frame.getContentPane().add(panel);
		
		textField = new JTextField();
		textField.setBounds(452, 23, 48, 28);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(510, 23, 53, 28);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Hero");
		comboBox.addItem("Lever");
		comboBox.addItem("Wall");
		comboBox.addItem("Key");
		comboBox.addItem("Exit");
		comboBox.setBounds(645, 88, 65, 28);
		frame.getContentPane().add(comboBox);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(452, 88, 48, 28);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(510, 88, 53, 28);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
	}
}

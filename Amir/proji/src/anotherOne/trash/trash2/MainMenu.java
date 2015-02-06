// from https://www.daniweb.com/software-development/java/threads/76144/removing-and-adding-items-to-jpanel
package anotherOne.main.trash;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Vector;
import java.awt.event.*;
class MainMenu extends JFrame implements ActionListener{
	JPanel westPanel = new JPanel();
	JPanel menuPanel = new JPanel();
	JLabel defaultLabel = new JLabel("Please select an option from the menu on the left to continue", JLabel.CENTER);
	JButton addButton = new JButton("Add New CD Details");
	
	public static void main (String[] args) {
		MainMenu start = new MainMenu();
	}

	public MainMenu() {
		super("CD System ver 2.0");
		setSize(520,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuPanel.setLayout(new BorderLayout());
		westPanel.setLayout(new GridLayout(5,0));
		menuPanel.add("West", westPanel);
		defaultLabel.setFont(new Font("Serif", Font.BOLD, 14));
		menuPanel.add("Center", defaultLabel);
		addButton.addActionListener(this);
		westPanel.add(addButton);
		setContentPane(menuPanel);
		setVisible(true); }
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == addButton) {
			defaultLabel.setVisible(false);
//			menuPanel.remove(defaultLabel); }
		this.repaint();
	}
}
}
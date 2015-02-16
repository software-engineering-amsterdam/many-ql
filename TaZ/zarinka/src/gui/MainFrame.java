/*
 * @Zarina
 */
package gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainFrame {

	private JPanel contentPane, leftPanel, rightPanel;
	private JFrame mainFrame;
	

	public MainFrame() {
		mainUi();
	}	
	
	public final void mainUi() {
		mainFrame = new JFrame("Questionnaire");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 450, 300);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		mainFrame.setContentPane(contentPane);	
	}
	
	// maybe for later
		public final void panelManagment() {
			leftPanel = new JPanel();
			leftPanel.setBackground(Color.GRAY);
			leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
			leftPanel.setVisible(true);
			
			rightPanel = new JPanel();
			rightPanel.setBackground(Color.BLUE);
			rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
			rightPanel.setVisible(true);
			
			
			contentPane.add(leftPanel);
			contentPane.add(rightPanel);
		}
		
	
	public void getLabel(String text, boolean visibility) {
		contentPane.add(new JLabel(text)).setVisible(visibility);
		contentPane.add(new JTextField());
		mainFrame.setVisible(true);
	}
}
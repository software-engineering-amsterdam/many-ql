/*
 * @Zarina
 */
package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ast.form.Form;

public class MainFrame {

	private final JPanel contentPane;
	private final JFrame mainFrame;
	
	public MainFrame() {
		mainFrame = new JFrame("Questionnaire");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setPreferredSize( new Dimension( 600, 400 ) );
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		mainFrame.setContentPane(contentPane);	
	}
	
	public void magic(Form form) {
		JPanel mainpanel = GUIRenderer.make(form); 
		contentPane.add(mainpanel);
		mainFrame.setTitle(form.getFormId().toString());
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}	
}
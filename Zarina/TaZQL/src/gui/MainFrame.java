/*
 * @Zarina
 */
package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import main.manager.GUIManager;
import ast.form.Form;

public class MainFrame {

	private final JPanel contentPane;
	private final JFrame mainFrame;
	private JMenuBar menubar;
	private JMenu menuItemSave, menuItemClose;
	
	public MainFrame() {
		mainFrame = new JFrame("Questionnaire");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setPreferredSize( new Dimension( 600, 400 ) );
		
		mainFrame.setJMenuBar(addMenu());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		mainFrame.setContentPane(contentPane);	
	}
	
	public void addFormToFrame(Form form) {
		JPanel mainpanel = GUIRenderer.make(form); 
		contentPane.add(mainpanel);
		mainFrame.setTitle(form.getFormId().toString());
		
		showGUI();
	}
	
	
	public void showGUI() {
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	
	public JMenuBar addMenu() {
		menubar = new JMenuBar();
		
		menuItemSave = new JMenu("Load");
		menuItemClose = new JMenu("Close");
		
		menubar.add(menuItemSave);
		menubar.add(menuItemClose);
		
		addMenuAction();
		
		return menubar;
	}
	
	public void addMenuAction() {
		menuItemSave.addMenuListener(new MenuListener() {

			@Override
			public void menuCanceled(MenuEvent arg0) {}
		
			@Override
			public void menuDeselected(MenuEvent arg0) {}

			@Override
			public void menuSelected(MenuEvent arg0) {
				GUIManager manager = new GUIManager();
				mainFrame.dispose();
				manager.runGUI();
			}	
		});
		
		
		menuItemClose.addMenuListener(new MenuListener() {

			@Override
			public void menuCanceled(MenuEvent arg0) {}
		
			@Override
			public void menuDeselected(MenuEvent arg0) {}

			@Override
			public void menuSelected(MenuEvent arg0) {
				closeFrame();
			}	
		});
	}
	
	public void closeFrame() {
		int selectedOption = 
				JOptionPane.showConfirmDialog(null, 
				"Do you want to close this programm?", 
				"Close form",
				JOptionPane.YES_NO_OPTION); 
		
		if (selectedOption == JOptionPane.YES_OPTION) {
			mainFrame.dispose();
		}	
	}
}
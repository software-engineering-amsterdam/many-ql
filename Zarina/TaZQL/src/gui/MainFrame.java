/*
 * @Zarina
 */
package gui;

import java.awt.Dimension;
import java.awt.event.WindowEvent;

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

	private JPanel contentPane;
	private JPanel mainpanel = new JPanel();
	private JFrame mainFrame;
	private JMenuBar menubar;
	private JMenu menuItemLoad, menuItemClose;
	
	public MainFrame() {
		
	}
	
	public void showInitialFrame() {
		mainFrame = new JFrame("Questionnaire");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setBounds(100, 100, 450, 300);
		mainFrame.setPreferredSize( new Dimension( 600, 400 ) );
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
		
		contentPane.add(mainpanel);
		
		mainFrame.setContentPane(contentPane);
		
		mainFrame.setJMenuBar(addMenu());
		
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
	
	public JPanel addFormToFrame(Form form) {
		mainpanel = GUIRenderer.make(form); 
		
		return mainpanel;
	}
	
	
	public JMenuBar addMenu() {
		menubar = new JMenuBar();
		
		menuItemLoad = new JMenu("Load");
		menuItemClose = new JMenu("Close");
		
		menubar.add(menuItemLoad);
		menubar.add(menuItemClose);
		
		addMenuAction();
		
		return menubar;
	}
	
	public void addMenuAction() {
		menuItemLoad.addMenuListener(new MenuListener() {

			@Override
			public void menuCanceled(MenuEvent arg0) {}
		
			@Override
			public void menuDeselected(MenuEvent arg0) {}

			@Override
			public void menuSelected(MenuEvent arg0) {
				final GUIManager manager = new GUIManager();
				manager.runGUI(mainFrame);
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
			mainFrame.dispatchEvent(new WindowEvent(mainFrame, WindowEvent.WINDOW_CLOSING));
		}	
	}
}
package uva.sc.ql.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

@SuppressWarnings("serial")
public class FileChooser extends JPanel implements ActionListener {
    
    JButton chooseFileButton;

    JFileChooser fileChooser;

    public FileChooser() {
	
	JPanel panel = new JPanel();
	panel.setPreferredSize(new Dimension(200, 100));
	
	fileChooser = new JFileChooser();
	chooseFileButton = new JButton("Choose a file");
	chooseFileButton.addActionListener(this);

	panel.add(chooseFileButton);

	add(panel, BorderLayout.PAGE_START);
    }

    public void actionPerformed(ActionEvent e) {

	if (e.getSource() == chooseFileButton) {
	    int returnVal = fileChooser.showOpenDialog(FileChooser.this);

	    if (returnVal == JFileChooser.APPROVE_OPTION) {
		File file = fileChooser.getSelectedFile();
		try {
		    QuestionnaireForm qf = new QuestionnaireForm(file);
		    this.setVisible(false);
		    qf.setVisible(true);
		} catch (IOException e1) {
		    // TODO Auto-generated catch block
		    e1.printStackTrace();
		}
	    }
	}
    }

    private static void createAndShowGUI() {
	JFrame frame = new JFrame("QL File Chooser");
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(new FileChooser());
	frame.pack();
	frame.setVisible(true);
    }

    public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {
	    public void run() {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		createAndShowGUI();
	    }
	});
    }

}
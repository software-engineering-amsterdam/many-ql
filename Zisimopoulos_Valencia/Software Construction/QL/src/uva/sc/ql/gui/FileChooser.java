package uva.sc.ql.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings({ "serial" })
public class FileChooser extends JPanel implements ActionListener {

    private JButton chooseFileButton;
    private JFileChooser fileChooser;
    private static JFrame frame;

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
	    openFileAction();
	}
    }

    private void openFileAction() {
	if (fileChooser.showOpenDialog(FileChooser.this) == JFileChooser.APPROVE_OPTION) {
	    File file = fileChooser.getSelectedFile();
	    try {
		generateQuestionnaire(file);
	    } catch (IOException e1) {
		handleIOException();
	    }
	}
    }

    private void generateQuestionnaire(File file) throws IOException {
	frame.setVisible(false);
	this.setVisible(false);
	QuestionnaireForm questionnaireForm = new QuestionnaireForm();
	questionnaireForm.drawQuestionnaireFormManager(file);
    }

    private void handleIOException() {
	String title = "File not found";
	String message = "Please check the path of the file and retry.";
	JOptionPane.showMessageDialog(this, message, title,
		JOptionPane.ERROR_MESSAGE);
	createAndShowGUI();
    }

    private static void createAndShowGUI() {
	frame = new JFrame("QL File Chooser");
	frame.add(new FileChooser());
	frame.pack();
	frame.setLocationRelativeTo(null);
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
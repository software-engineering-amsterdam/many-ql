package gui.errors;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorDialog {
	private List<TaZQLError> errorCollection;
	private List<TaZQLWarning> warningCollection;
	private JLabel errorLabel, warningLabel;
	
	
	public ErrorDialog(List<TaZQLError> errorCollection, List<TaZQLWarning> warningCollection) {
		this.errorCollection = errorCollection;
		this.warningCollection = warningCollection;
		errorDialog();
	}
	
	public void errorDialog() {	
		JDialog dialog = new JDialog();
		Container contentPane = dialog.getContentPane();
		contentPane.setLayout(new GridLayout(0, 1));
		errorLabel = new JLabel("Errors found", JLabel.CENTER);
		errorLabel.setForeground(Color.red);
		errorLabel.setVisible(false);
		contentPane.add(errorLabel);
		
		for(TaZQLError errorMessage : this.errorCollection) {
			if (errorMessage !=null) {
				errorLabel.setVisible(true);
			}
			System.out.println("Errors: " + errorMessage);
			contentPane.add(addErrorLabel(errorMessage));
		
		}
		
		warningLabel = new JLabel("Warnings found", JLabel.CENTER);
		warningLabel.setForeground(Color.red);
		warningLabel.setVisible(false);
		contentPane.add(warningLabel);
		
		for(TaZQLWarning warningMessage : this.warningCollection) {
			if (warningMessage !=null) {
				warningLabel.setVisible(true);
			}
			contentPane.add(addWarningLabel(warningMessage));
		}
		
		contentPane.setBackground(Color.white);
		contentPane.setVisible(true);
		dialog.setTitle("Typechecker: errors found");
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setMinimumSize(new Dimension(400,200));
		dialog.setVisible(true);
	}
	
	public JLabel addErrorLabel(TaZQLError error) {
		return new JLabel("  " + error.getMessage() + " ");
	}
	
	public JLabel addWarningLabel(TaZQLWarning warn) {
		return new JLabel("  "+ warn.getMessage() + " ");
	}

}

package typechecker.errors;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorDialog {
	private List<TaZQLError> errorCollection;
	private List<TaZQLWarning> warningCollection;
	
	public ErrorDialog(List<TaZQLError> errorCollection, List<TaZQLWarning> warningCollection) {
		this.errorCollection = errorCollection;
		this.warningCollection = warningCollection;
		errorDialog();
	}
	
	public void errorDialog() {	
		JDialog dialog = new JDialog();
		Container contentPane = dialog.getContentPane();
		
		for(TaZQLError errorMessage : this.errorCollection) {
			contentPane.add(addErrorLabel(errorMessage));
		}
		
		for(TaZQLWarning warningMessage : this.warningCollection) {
			contentPane.add(addWarningLabel(warningMessage));
		}
		
		contentPane.setBackground(Color.white);
		dialog.setTitle("Typechecker: errors found");
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setMinimumSize(new Dimension(300,100));
		dialog.setVisible(true);
	}
	
	public JLabel addErrorLabel(TaZQLError error) {
		return new JLabel(error.getErrorMessage());
	}
	
	public JLabel addWarningLabel(TaZQLWarning warn) {
		return new JLabel(warn.getWarningMessage());
	}

}

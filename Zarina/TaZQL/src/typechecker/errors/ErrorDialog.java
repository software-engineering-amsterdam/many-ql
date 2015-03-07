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
	
	public ErrorDialog(List<TaZQLError> errorCollection) {
		this.errorCollection = errorCollection;
		errorDialog();
	}
	
	public void errorDialog() {	
		JDialog dialog = new JDialog();
		Container contentPane = dialog.getContentPane();
		
		for(TaZQLError error : this.errorCollection) {
			contentPane.add(new JLabel(error.getErrorMessage()));
		}
		
		contentPane.setBackground(Color.white);
		dialog.setTitle("Typechecker: errors found");
		dialog.pack();
		dialog.setLocationRelativeTo(null);
		dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		dialog.setMinimumSize(new Dimension(150,150));
		dialog.setVisible(true);
	}
	
	public JLabel addErrorLabel(TaZQLError error) {
		return new JLabel(error.getErrorMessage());
	}
}

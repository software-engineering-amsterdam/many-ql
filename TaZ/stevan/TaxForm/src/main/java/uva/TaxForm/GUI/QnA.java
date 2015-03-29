package uva.TaxForm.GUI;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class QnA extends JComponent{

	public QnA(String labelName) {
		
		JLabel label = new JLabel(labelName);
		label.setSize(100, 30);
		
		JTextField t = new JTextField();
		t.setSize(100, 30);
	}
}

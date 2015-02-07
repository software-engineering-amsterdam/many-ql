package anotherOne.gui.input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ExtendedListener implements ActionListener {

	String from;
	String to;
	JTextField fieldFrom;
	JTextField fieldTo;
	
	public ExtendedListener(String from){
		this.from = from;
	}

	public ExtendedListener(JTextField from){
//		this.from = from;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		to = from;
		System.out.println();
		// TODO Auto-generated method stub
	}
	
}

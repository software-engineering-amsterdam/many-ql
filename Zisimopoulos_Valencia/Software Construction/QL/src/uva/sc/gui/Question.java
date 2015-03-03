package uva.sc.gui;

import java.awt.Component;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Question extends JFrame{

	public abstract Component drawQuestion(String id, String label, String value);
	
}

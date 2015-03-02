package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;

public abstract class Widget extends Observable implements Observer {
	public abstract JComponent getComponent();
	
	@Override
	public void update(Observable o, Object arg) {} 
}

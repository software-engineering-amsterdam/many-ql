package gui;

import java.util.Observable;

import javax.swing.JComponent;

import cons.Value;

@SuppressWarnings("rawtypes")
public abstract class Widget<T extends Value> extends Observable {	
	public Widget() {}
	
	public abstract T getValue();
	public abstract void setValue(T value);
	
	public abstract JComponent getComponent();
}

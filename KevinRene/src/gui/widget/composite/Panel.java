package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;

import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.Value;
import cons.ql.ast.expression.Identifier;
import cons.value.UndefinedValue;

public class Panel extends Composite implements Observer {
	private JPanel panel;
	
	public Panel() {
		super(new Identifier("Block"));
		
		this.panel = new JPanel();
		this.panel.setLayout(new BoxLayout(this.panel, BoxLayout.Y_AXIS));
	}
	
	@SuppressWarnings("rawtypes")
	public void addComponent(Widget component) {
		component.addObserver(this);
		panel.add(component.getComponent());
		component.getComponent().setAlignmentX(Component.LEFT_ALIGNMENT);
	}
	
	@Override
	public UndefinedValue getValue() {
		return new UndefinedValue();
	}

	@Override
	public JComponent getComponent() {
		return panel;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void setValue(Value value) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void update(Observable changedSubject, Object arguments) {
		System.out.println("SOMETHING CHANGED IN MA BLOCKZ");
		// Don't care pass it on.
		notifyObservers();		
	}
}

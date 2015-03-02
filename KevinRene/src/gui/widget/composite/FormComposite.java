package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;

import java.awt.Component;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JPanel;

import cons.ql.ast.expression.Identifier;

public class FormComposite extends Composite {
	private JPanel formPanel;
	private Widget widgetPanel;
	
	public FormComposite(Widget panel) {
		super(new Identifier("Form"));
		
		this.widgetPanel = panel;
		this.widgetPanel.addObserver(this);
		
		this.formPanel = new JPanel();
		this.formPanel.setLayout(new BoxLayout(this.formPanel, BoxLayout.Y_AXIS));
		this.formPanel.add(widgetPanel.getComponent());
		widgetPanel.getComponent().setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	@Override
	public void update(Observable changedSubject, Object arguments) {
		System.out.println("Repaint form");

		widgetPanel.getComponent();
		formPanel.repaint();
	}

	@Override
	public JComponent getComponent() {
		return formPanel;
	}
}

package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;

import java.awt.Component;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;
import cons.ql.ast.expression.Identifier;

public class FormComposite extends Composite {
	private JFrame frame;
	private JPanel formPanel;
	private Widget widgetPanel;
	
	public FormComposite(JFrame frame, Widget panel) {
		super(new Identifier("Form"));
		this.frame = frame;
		
		this.widgetPanel = panel;
		this.widgetPanel.addObserver(this);
		
		this.formPanel = new JPanel();
		this.formPanel.setLayout(new BoxLayout(this.formPanel, BoxLayout.Y_AXIS));
		this.formPanel.add(widgetPanel.getComponent());
		this.formPanel.setLayout(new MigLayout("insets 0, hidemode 2"));
		this.formPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	@Override
	public void update(Observable changedSubject, Object arguments) {
		formPanel.removeAll();		
		formPanel.add(widgetPanel.getComponent());
		formPanel.repaint();
		
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public JComponent getComponent() {
		return formPanel;
	}
}

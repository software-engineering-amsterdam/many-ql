package gui.widget.composite;

import gui.Widget;
import gui.widget.Composite;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;
import cons.Value;
import cons.ql.ast.expression.Identifier;

public class FormComposite extends Composite {
	private JFrame frame;
	private JPanel formPanel;
	private Widget widgetPanel;
	
	public FormComposite(JFrame frame, Widget panel) {
		super(new Identifier("Form"));
		this.frame = frame;
		
		this.widgetPanel = panel;
		this.widgetPanel.setHandler(this);
		
		this.formPanel = new JPanel(new MigLayout("insets 0, hidemode 2"));
		this.formPanel.add(widgetPanel.getComponent());
		this.formPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void handleChange(Value changedValue) {		
		updateComponent();
	}

	@Override
	public void updateComponent() {
		widgetPanel.updateComponent();
		
		formPanel.revalidate();
		formPanel.repaint();
		
		frame.setVisible(true);
	}
	
	@Override
	public JComponent getComponent() {
		return new JScrollPane(formPanel);
	}	
}

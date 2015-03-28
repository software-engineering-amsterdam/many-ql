package org.uva.ql.view.panel;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public abstract class Panel {

	private final JPanel panel;

	public Panel() {
		panel = new JPanel();
		panel.setLayout(new MigLayout());
	}

	public void addComponent(Component component) {
		panel.add(component);
	}

	public void addComponent(Component component, String arg) {
		panel.add(component, arg);
	}

	public void addPanel(Panel panel) {
		addComponent(panel.getPanel());
	}

	public void addPanel(Panel panel, String arg) {
		addComponent(panel.getPanel(), arg);
	}

	public void setVisible(boolean show) {
		panel.setVisible(show);
	}

	public void setBackground(Color color) {
		panel.setBackground(color);
	}

	public JPanel getPanel() {
		return panel;
	}

}

package org.uva.ql.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class QuestionPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private final Dimension size;
	protected final ArrayList<Panel> panels;

	public QuestionPanel(ArrayList<Panel> panels) {
		super();
		this.panels = panels;
		size = new Dimension(350, 50);
		setLayout(new FlowLayout());
		setSize(size);
		setPreferredSize(size);
		setBackground(Color.LIGHT_GRAY);
		for (Panel questionPanel : panels) {
			int width = (int) getSize().getWidth();
			int height = (int) getSize().getHeight() + 50;
			setSize(new Dimension(width, height));
			setPreferredSize(new Dimension(width, height));
			add(questionPanel);
		}
	}

	public ArrayList<Panel> getPanels() {
		return panels;
	}
}
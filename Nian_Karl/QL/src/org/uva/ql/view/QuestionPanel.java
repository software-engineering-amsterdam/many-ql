package org.uva.ql.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class QuestionPanel extends Panel {

	private static final long serialVersionUID = 1L;
	private final Dimension size;
	private final ArrayList<Panel> baseComponents;

	public QuestionPanel(ArrayList<Panel> baseComponents) {
		super();
		this.baseComponents = baseComponents;
		size = new Dimension(350, 50);
		setLayout(new FlowLayout());
		setSize(size);
		setPreferredSize(size);
		setBackground(Color.LIGHT_GRAY);
		for (Panel questionPanel : baseComponents) {
			int width = (int) getSize().getWidth();
			int height = (int) getSize().getHeight() + 50;
			setSize(new Dimension(width, height));
			setPreferredSize(new Dimension(width, height));
			add(questionPanel);
		}
	}

	public ArrayList<Panel> getBaseComponents() {
		return baseComponents;
	}
}
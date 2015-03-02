package org.uva.ql.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

public class QLQuestionPanel extends QLPanel {

	private static final long serialVersionUID = 1L;
	private final Dimension size;
	private final ArrayList<QLPanel> baseComponents;

	public QLQuestionPanel(ArrayList<QLPanel> baseComponents) {
		super();
		this.baseComponents = baseComponents;
		size = new Dimension(350, 50);
		setLayout(new FlowLayout());
		setSize(size);
		setPreferredSize(size);
		setBackground(Color.LIGHT_GRAY);
		for (QLPanel questionPanel : baseComponents) {
			int width = (int) getSize().getWidth();
			int height = (int) getSize().getHeight() + 50;
			setSize(new Dimension(width, height));
			setPreferredSize(new Dimension(width, height));
			add(questionPanel);
		}
	}

	public ArrayList<QLPanel> getBaseComponents() {
		return baseComponents;
	}
}
package com.form.language.ast.widget;

import java.util.ArrayList;
import java.util.List;

import com.form.language.ast.ASTNode;
import com.form.language.ast.style.Style;

import javax.swing.JComponent;

public interface Widget extends JComponent implements ASTNode {
	
	private String label;
	private Style style;
	private final List<Style> styleProperties;
	
	public final static int DEFAULT_WIDTH = 400;
	public final static String DEFAULT_FONT = "Arial";
    public final static int DEFAULT_FONT_SIZE = 14;
    public final static String DEFAULT_COLOR = "#999999";
  	
	public abstract void addStyle(Style style);
	
	public Widget()
	{
		styleProperties = new ArrayList<Style>();	
	}

}

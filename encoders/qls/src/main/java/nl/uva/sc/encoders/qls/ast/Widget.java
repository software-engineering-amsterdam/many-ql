package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Widget extends AstNode {

	private final String type;
	private int width = 150;
	private int fontSize = 12;
	private String color = "#666666";

	public Widget(TextLocation textLocation, String type, int width, int fontSize, String color) {
		super(textLocation);
		this.type = type;
		this.setWidth(width);
		this.setFontSize(fontSize);
		this.setColor(color);
	}

	public String getWidgetType() {
		return type;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getFontSize() {
		return fontSize;
	}

	public void setFontSize(int fontSize) {
		this.fontSize = fontSize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}

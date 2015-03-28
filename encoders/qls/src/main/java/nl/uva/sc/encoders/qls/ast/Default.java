package nl.uva.sc.encoders.qls.ast;

import nl.uva.sc.encoders.ql.ast.TextLocation;

public class Default extends AstNode {

	private String datatype;
	private int width = 150;
	private int fontSize = 12;
	private String font = "Arial";
	private String color = "#666666";
	private Widget widget;

	public Default(TextLocation textLocation, String datatype, int width, int fontSize, String font, String color, Widget widget) {
		super(textLocation);
		this.datatype = datatype;
		this.width = width;
		this.fontSize = fontSize;
		this.font = font;
		this.color = color;
		this.widget = widget;

	}

	public String getDataType() {
		return datatype;
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

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Widget getWidget() {
		return widget;
	}

	public void setWidget(Widget widget) {
		this.widget = widget;
	}

}

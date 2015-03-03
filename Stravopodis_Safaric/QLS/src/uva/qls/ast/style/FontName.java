package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.value.StringValue;

import java.util.ArrayList;
import java.util.List;
import java.awt.GraphicsEnvironment;

public class FontName extends Font{

	private String value;
	
	public FontName(String _value, CodeLines _codeLines) {
		super(_codeLines);
		this.value = this.fontValid(_value);
	}

	private String fontValid(String _value){
		List<Object> availableFonts = new ArrayList<Object>();
		availableFonts.toArray(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		return availableFonts.contains(_value) ? _value : "Arial";
	}
	
	@Override
	public StringValue evaluate() {
		return new StringValue(this.value);
	}

	@Override
	public String toString() {
		return "FontName(" + this.value + ")";
	}
}

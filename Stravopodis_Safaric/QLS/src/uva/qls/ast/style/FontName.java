package uva.qls.ast.style;

import uva.qls.ast.CodeLines;
import uva.qls.ast.literal.StringLiteral;
import uva.qls.ast.statements.visitor.StatementVisitor;
import uva.qls.ast.value.StringValue;

import java.util.ArrayList;
import java.util.List;
import java.awt.GraphicsEnvironment;

public class FontName extends Font{

	private StringLiteral value;
	
	public FontName(StringLiteral _value, CodeLines _codeLines) {
		super(_codeLines);

		this.value = new StringLiteral(this.fontValid(_value.toString()), _codeLines);
	}

	private String fontValid(String _value){
		List<Object> availableFonts = new ArrayList<Object>();
		String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		for (int i=0; i< fonts.length; i++){
			availableFonts.add(fonts[i]);
		}
	
		return availableFonts.contains(_value) ? _value : "Arial";
	}

	@Override
	public <T> T accept(StatementVisitor<T> visitor) {
		return visitor.visitFontName(this);
	}
	
	@Override
	public StringValue evaluate() {
		return new StringValue(this.value.toString());
	}
	
	@Override
	public String getStyleType() {
		return this.getClass().getName();
	}

	@Override
	public String toString() {
		return "FontName(" + this.value + ")";
	}
}

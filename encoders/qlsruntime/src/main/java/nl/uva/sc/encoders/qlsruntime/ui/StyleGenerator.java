package nl.uva.sc.encoders.qlsruntime.ui;

import nl.uva.sc.encoders.qls.ast.property.Color;
import nl.uva.sc.encoders.qls.ast.property.Font;
import nl.uva.sc.encoders.qls.ast.property.FontSize;
import nl.uva.sc.encoders.qls.ast.property.Width;
import nl.uva.sc.encoders.qls.visitor.DefaultPropertyVisitor;

public class StyleGenerator implements DefaultPropertyVisitor<String> {

	@Override
	public String visit(Color color) {
		return "-fx-text-fill: #" + color.getValue() + ";";
	}

	@Override
	public String visit(Width width) {
		return "-fx-width: " + width.getValue() + ";";
	}

	@Override
	public String visit(Font font) {
		return "-fx-font-family: " + font.getValue() + ";";
	}

	@Override
	public String visit(FontSize fontSize) {
		return "-fx-font-size: " + fontSize.getValue() + "px;";
	}

}

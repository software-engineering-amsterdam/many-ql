package nl.uva.sc.encoders.qls.visitor;

import nl.uva.sc.encoders.qls.ast.property.Color;
import nl.uva.sc.encoders.qls.ast.property.Font;
import nl.uva.sc.encoders.qls.ast.property.FontSize;
import nl.uva.sc.encoders.qls.ast.property.Width;

public interface DefaultPropertyVisitor<T> {

	T visit(Color color);

	T visit(Width width);

	T visit(Font font);

	T visit(FontSize fontSize);
}

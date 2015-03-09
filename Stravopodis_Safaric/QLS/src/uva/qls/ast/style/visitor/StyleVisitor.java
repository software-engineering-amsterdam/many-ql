package uva.qls.ast.style.visitor;

import uva.qls.ast.style.Color;
import uva.qls.ast.style.Font;
import uva.qls.ast.style.FontName;
import uva.qls.ast.style.FontSize;
import uva.qls.ast.style.Height;
import uva.qls.ast.style.Style;
import uva.qls.ast.style.Width;

public interface StyleVisitor<T> {

	public T visitStyle(Style style);
	public T visitColor(Color color);
	public T visitFont(Font font);
	public T visitFontsize(FontSize fontSize);
	public T visitFontName(FontName fontName);
	public T visitHeight(Height height);
	public T visitWidth(Width width);
	
}

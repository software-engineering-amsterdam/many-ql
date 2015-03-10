package org.uva.qls.visitor;

import org.uva.qls.ast.style.Color;
import org.uva.qls.ast.style.Font;
import org.uva.qls.ast.style.Fontsize;
import org.uva.qls.ast.style.Height;
import org.uva.qls.ast.style.Width;


public interface StyleVisitor<T> {

	public T visit(Height height);
	
	public T visit(Width width);

	public T visit(Fontsize fontsize);

	public T visit(Font font);

	public T visit(Color color);
	

}

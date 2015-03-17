package org.uva.qls.visitor;

import org.uva.qls.ast.sheet.Page;
import org.uva.qls.ast.sheet.Question;
import org.uva.qls.ast.sheet.Section;
import org.uva.qls.ast.sheet.Sheet;
import org.uva.qls.ast.sheet.Style;

public interface SheetVisitor<T> {

	public T visit(Page page);

	public T visit(Question question);

	public T visit(Section section);

	public T visit(Sheet sheet);

	public T visit(Style style);

}

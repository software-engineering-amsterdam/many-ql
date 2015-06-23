package nl.uva.sc.encoders.qls.visitor;

import nl.uva.sc.encoders.qls.ast.Question;
import nl.uva.sc.encoders.qls.ast.Section;

public interface AstVisitor<T> {

	T visit(Section section);

	T visit(Question question);
}

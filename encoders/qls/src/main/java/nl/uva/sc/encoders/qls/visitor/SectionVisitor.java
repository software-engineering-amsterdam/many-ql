package nl.uva.sc.encoders.qls.visitor;

import nl.uva.sc.encoders.qls.ast.Section;

public interface SectionVisitor<T> {

	T visit(Section section);

}

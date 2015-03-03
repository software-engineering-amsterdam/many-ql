package qls.ast.visitor;

import qls.ast.Page;
import qls.ast.Question;
import qls.ast.Section;
import qls.ast.Stylesheet;
import qls.ast.literal.BooleanLiteral;
import qls.ast.literal.FloatLiteral;
import qls.ast.literal.IntegerLiteral;
import qls.ast.literal.StringLiteral;

public interface Visitor<T> {

	T visit(Stylesheet stylesheet);
	T visit(Page page);
	T visit(Section section);
	T visit(Question question);
	
	
	T visit(BooleanLiteral booleanLiteral);
	T visit(FloatLiteral floatLiteral);
	T visit(IntegerLiteral integerLiteral);
	T visit(StringLiteral stringLiteral);
}

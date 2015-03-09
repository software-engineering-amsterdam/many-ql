package qls.ast.visitor;

import ql.ast.expression.literal.BooleanLiteral;
import ql.ast.expression.literal.FloatLiteral;
import ql.ast.expression.literal.IntegerLiteral;
import ql.ast.expression.literal.StringLiteral;

import qls.ast.statement.Page;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;

public interface Visitor<T> {
	public T visit(Stylesheet stylesheet);
	public T visit(Page page);
	public T visit(Section section);
	public T visit(Question question);
	
	public T visit(BooleanLiteral booleanLiteral);
	public T visit(FloatLiteral floatLiteral);
	public T visit(IntegerLiteral integerLiteral);
	public T visit(StringLiteral stringLiteral);
}

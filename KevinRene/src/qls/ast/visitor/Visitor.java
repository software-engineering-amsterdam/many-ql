package qls.ast.visitor;

import qls.ast.literal.BooleanLiteral;
import qls.ast.literal.FloatLiteral;
import qls.ast.literal.IntegerLiteral;
import qls.ast.literal.StringLiteral;
import qls.ast.statement.Page;
import qls.ast.statement.Question;
import qls.ast.statement.Section;
import qls.ast.statement.Stylesheet;
import qls.ast.type.QLSBoolean;
import qls.ast.type.QLSError;
import qls.ast.type.QLSFloat;
import qls.ast.type.QLSForm;
import qls.ast.type.QLSInteger;
import qls.ast.type.QLSNumeric;
import qls.ast.type.QLSString;

public interface Visitor<T> {
	public T visit(Stylesheet stylesheet);
	public T visit(Page page);
	public T visit(Section section);
	public T visit(Question question);
	
	public T visit(BooleanLiteral booleanLiteral);
	public T visit(FloatLiteral floatLiteral);
	public T visit(IntegerLiteral integerLiteral);
	public T visit(StringLiteral stringLiteral);
	
	public T visit(QLSBoolean booleanType);
	public T visit(QLSError errorType);
	public T visit(QLSFloat floatType);
	public T visit(QLSForm formType);
	public T visit(QLSInteger integerType);
	public T visit(QLSNumeric numericType);
	public T visit(QLSString stringType);
}

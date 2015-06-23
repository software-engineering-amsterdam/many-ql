package uva.qls.ast.literal.visitor;

import uva.qls.ast.literal.*;
import uva.qls.ast.type.Type;

public interface LiteralVisitor<T> {

	public T visitBooleanLiteral(BooleanLiteral literal);
	public T visitIntLiteral(IntLiteral literal);
	public T visitIdentifier(Identifier identifier);
	public T visitLiteral(Literal literal);
	public T visitMoneyLiteral(MoneyLiteral literal);
	public T visitStringLiteral(StringLiteral literal);
	public T visitType(Type type);
	
}

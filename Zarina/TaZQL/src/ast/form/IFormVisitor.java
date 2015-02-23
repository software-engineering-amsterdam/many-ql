package ast.form;

import ast.expression.IExpressionVisitor;
import ast.question.IQuestionVisitor;
import ast.type.ITypeVisitor;

public interface IFormVisitor<T> extends IQuestionVisitor<T>, IExpressionVisitor<T>, ITypeVisitor<T> {
	public T visit(Form form);
}

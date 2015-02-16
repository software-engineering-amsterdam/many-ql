package org.fugazi.ast;

import org.fugazi.ast.form.Form;
import org.fugazi.ast.statement.IStatementVisitor;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.literal.ILiteralVisitor;
import org.fugazi.ast.type.ITypeVisitor;

public interface IASTVisitor<T> extends IExpressionVisitor<T>, ITypeVisitor<T>, IStatementVisitor<T>, ILiteralVisitor<T> {

    public T visitForm(Form form);
}

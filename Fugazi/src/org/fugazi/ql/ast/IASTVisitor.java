package org.fugazi.ql.ast;

import org.fugazi.ql.ast.expression.IExpressionVisitor;
import org.fugazi.ql.ast.form.Form;
import org.fugazi.ql.ast.statement.IStatementVisitor;
import org.fugazi.ql.ast.type.ITypeVisitor;

public interface IASTVisitor<T> extends IExpressionVisitor<T>, ITypeVisitor<T>, IStatementVisitor<T> {

    public T visitForm(Form form);
}

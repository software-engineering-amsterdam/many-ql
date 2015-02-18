package org.fugazi.ast.expression;

import org.fugazi.ast.AbstractASTNode;
import org.fugazi.ast.type.Type;

import java.util.List;

public abstract class Expression extends AbstractASTNode {

    public abstract String toString();

    public abstract List<Type> getSupportedTypes();

    public abstract <T> T accept(IExpressionVisitor<T> visitor);
}
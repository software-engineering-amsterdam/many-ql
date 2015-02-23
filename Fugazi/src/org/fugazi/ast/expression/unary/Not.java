package org.fugazi.ast.expression.unary;

import org.fugazi.ast.expression.Expression;
import org.fugazi.ast.expression.IExpressionVisitor;
import org.fugazi.ast.type.BoolType;

import java.util.ArrayList;
import java.util.List;

public class Not extends Unary {

    private final List<Class> supportedTypes;

    public Not(Expression _expr, int _lineNum) {
        super(_expr, _lineNum);

        Class boolTypeClass = BoolType.class;
        this.supportedTypes = new ArrayList<Class>();
        this.supportedTypes.add(boolTypeClass);
    }

    @Override
    public String toString() {
        return "! " + this.expr.toString();
    }

    @Override
    public List<Class> getSupportedTypes() {
        return this.supportedTypes;
    }

    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visitNot(this);
    }
}
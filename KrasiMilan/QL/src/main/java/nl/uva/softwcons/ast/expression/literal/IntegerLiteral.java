package nl.uva.softwcons.ast.expression.literal;

import java.math.BigInteger;

import nl.uva.softwcons.ast.expression.Expression;
import nl.uva.softwcons.ast.expression.ExpressionVisitor;

public class IntegerLiteral extends Expression {

    private BigInteger value;

    public IntegerLiteral(int value) {
        this.value = BigInteger.valueOf(value);
    }

    @Override
    public <T> T accept(ExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public BigInteger getValue() {
        return value;
    }

}

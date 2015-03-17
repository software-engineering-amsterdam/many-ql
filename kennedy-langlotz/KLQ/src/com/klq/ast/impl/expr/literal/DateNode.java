package com.klq.ast.impl.expr.literal;

import com.klq.ast.impl.Location;
import com.klq.ast.IExpressionVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.IdentifierNode;
import com.klq.ast.impl.value.DateValue;
import com.klq.ast.impl.value.Value;

import java.util.Date;
import java.util.Map;

/**
 * Created by juriaan on 17-2-15.
 */
public class DateNode extends AExpression {
    private Date date;

    public DateNode(Date date, Location location) {
        super(location);
        this.date = date;
    }

    public DateNode(Date date) {
        this.date = date;
    }

    @Override
    public <T> T accept(IExpressionVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Date getDate() {
        return date;
    }

    @Override
    public Value evaluate(Map<IdentifierNode, Value> variables) {
        return new DateValue(date);
    }
}

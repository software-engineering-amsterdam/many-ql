package com.klq.ast.impl.expr.literal;

import com.common.ast.Location;
import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.ast.impl.expr.value.DateValue;
import com.klq.ast.impl.expr.value.Value;

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
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Date getDate() {
        return date;
    }

    @Override
    public Value evaluate(Map<String, Value> variables) {
        return new DateValue(date);
    }
}

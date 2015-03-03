package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;
import com.klq.ast.impl.expr.AExpression;
import com.klq.logic.value.DateValue;
import com.klq.logic.value.IdentifierValue;
import com.klq.logic.value.Value;

import java.time.LocalDate;
import java.util.Date;
import java.util.Map;

/**
 * Created by juriaan on 17-2-15.
 */
public class DateNode extends AExpression {
    private Date date;

    public DateNode(Date date, String location) {
        super(null, null, location);
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
    public Value evaluate(Map<IdentifierValue, Value> variables) {
        return new DateValue(date);
    }
}

package com.klq.ast.impl.expr.literal;

import com.klq.ast.IVisitor;

import java.util.Date;
import java.util.Map;

/**
 * Created by juriaan on 17-2-15.
 */
public class DateNode extends AValueNode<Date> {
    public DateNode(Date date, String location) {
        super(date, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    @Override
    public AValueNode evaluate(Map<String, AValueNode> variableTable) {
        return this;
    }
}

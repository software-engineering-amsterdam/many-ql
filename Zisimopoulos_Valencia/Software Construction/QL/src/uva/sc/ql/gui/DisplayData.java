package uva.sc.ql.gui;

import uva.sc.core.types.Type;
import uva.sc.ql.expression.Expression;

public class DisplayData {
    Expression value;
    Expression condition;
    Type type;

    public Expression getValue() {
	return value;
    }

    public Expression getCondition() {
	return condition;
    }

    public Type getType() {
	return type;
    }

    public DisplayData(Expression v) {
	value = v;
    }

    public DisplayData(Expression v, Expression c, Type t) {
	value = v;
	condition = c;
	type = t;
    }
}

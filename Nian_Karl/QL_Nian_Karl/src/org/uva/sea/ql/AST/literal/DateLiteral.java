package org.uva.sea.ql.AST.literal;

import java.util.Date;

import org.uva.sea.ql.AST.value.AbstractValue;
import org.uva.sea.ql.AST.value.DateValue;

public class DateLiteral extends AbstractLiteral {
	private final Date date;

	public DateLiteral(Date date) {
		this.date = date;
	}
	
	@Override
	public AbstractValue<?> interpretExpression() {
		return new DateValue(date);
	}

}

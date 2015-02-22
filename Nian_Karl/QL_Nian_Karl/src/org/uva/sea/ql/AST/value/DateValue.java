package org.uva.sea.ql.AST.value;

import java.util.Date;

public class DateValue extends AbstractValue<Date> {

	private Date date;

	public DateValue(Date date) {
		this.date = date;
	}

	
	@Override
	public Date getValue() {
		return date;
	}

}

package org.uva.sea.ql.AST.literal;

import java.util.Date;

import org.uva.sea.ql.AST.visitor.Visitor;

public class DateLiteral extends AbstractLiteral {
	private final Date date;

	public DateLiteral(Date date) {
		this.date = date;
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);		
	}
	
}

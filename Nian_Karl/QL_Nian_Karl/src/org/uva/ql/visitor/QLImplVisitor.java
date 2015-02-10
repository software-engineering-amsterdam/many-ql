package org.uva.ql.visitor;

import org.uva.ql.antlr.QLBaseVisitor;

public class QLImplVisitor extends QLBaseVisitor<String> {
		
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		if (aggregate == null) {
			return nextResult;
		}
		if (nextResult == null) {
			return aggregate;
		}
		return aggregate + "\n" + nextResult;
	}
}

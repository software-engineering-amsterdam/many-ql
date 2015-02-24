package org.uva.ql.factory;

import org.antlr.v4.runtime.atn.SemanticContext.Operator;
import org.uva.ql.antlr.QLParser.QuestionComputeContext;
import org.uva.ql.antlr.QLParser.QuestionNormalContext;
import org.uva.ql.ast.builder.QLImplVisitor;
import org.uva.ql.ast.expression.Expression;
import org.uva.ql.ast.statement.QuestionCompute;
import org.uva.ql.ast.statement.QuestionNormal;
import org.uva.ql.ast.type.QuestionType;

public class QLFactory implements IQLFactory {

	private final String INT = "Int";
	private final String CUR = "Cur";
	private final String STR = "Str";
	private final String BOOL= "Bool";

	@Override
	public QuestionNormal getQuestionNormal(QuestionNormalContext ctx) {
		QuestionType type = getQuestionType(ctx.questionType().getText());
		String identifier = ctx.questionName().getText();
		// Escape the "" in the beginning of the questionlabel.
		String label = ctx.questionLabel().getText();
		
		return new QuestionNormal(type, identifier, label);
	}
	
	@Override
	public QuestionCompute getQuestionCompute(QuestionComputeContext ctx) {
		QuestionType type = getQuestionType(ctx.questionType().getText());
		String identifier = ctx.questionName().getText();
		String label = ctx.questionLabel().getText();
		Expression expr = ((Expression) ctx.expression().accept(new QLImplVisitor()));
		return new QuestionCompute(type, identifier, label,expr);
	}

	@Override
	public QuestionType getQuestionType(String s) {
		switch (s) {
		case INT:
			return QuestionType.INT;
		case CUR:
			return QuestionType.CUR;
		case STR:
			return QuestionType.STR;
		case BOOL:
			return QuestionType.BOOL;
		default:
			return QuestionType.NO_TYPE;
		}
	}

	public boolean stringToBoolean(String s) {
		if (s.equals("true")) {
			return true;
		} else {
			return false;
		}
	}

	public Operator getOperator(String s) {
//		for (Operator operator : Operator.values()) {
//			if (operator.getOperatorString().equals(s)) {
//				return operator;
//			}
//		}
		return null;
	}


}

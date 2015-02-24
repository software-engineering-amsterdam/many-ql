package org.uva.ql.factory;

import org.antlr.v4.runtime.atn.SemanticContext.Operator;
import org.uva.ql.antlr.QLParser.QuestionNormalContext;
import org.uva.ql.ast.statement.QuestionStatement;
import org.uva.ql.ast.type.QuestionType;

public class QLFactory implements IQLFactory {

	private final String INT = "Int";
	private final String CUR = "Cur";
	private final String STR = "Str";
	private final String BOOL= "Bool";

	@Override
	public QuestionStatement getQuestion(QuestionNormalContext ctx) {
		QuestionType type = getQuestionType(ctx.questionType().getText());
		String questionIdentifier = ctx.questionName().getText();
		// Escape the "" in the beginning of the questionlabel.
		String questionLabel = ctx.questionLabel().getText();
		
		return new QuestionStatement(type, questionIdentifier, questionLabel);
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

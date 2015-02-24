package org.uva.sea.ql.factory;

import org.uva.sea.ql.AST.QuestionType;
import org.uva.sea.ql.AST.expression.Expression;
import org.uva.sea.ql.AST.expression.Operator;
import org.uva.sea.ql.AST.statement.QuestionStatement;
import org.uva.sea.ql.parser.antlr.QLParser.ExpressionContext;
import org.uva.sea.ql.parser.antlr.QLParser.QuestionContext;

public class QLFactory implements IQLFactory {

	private final String INT = "Int";
	private final String CUR = "Cur";
	private final String STR = "Str";
	private final String BOOL= "Bool";

	@Override
	public QuestionStatement getQuestion(QuestionContext ctx) {
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
		for (Operator operator : Operator.values()) {
			if (operator.getOperatorString().equals(s)) {
				return operator;
			}
		}
		return null;
	}

}

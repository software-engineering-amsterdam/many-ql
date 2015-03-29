package nl.uva.se.ql.gui.builders;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.type.BooleanType;
import nl.uva.se.ql.ast.type.DecimalType;
import nl.uva.se.ql.ast.type.IntegerType;
import nl.uva.se.ql.ast.type.StringType;
import nl.uva.se.ql.ast.type.TypeVisitor;
import nl.uva.se.ql.ast.type.UndefinedType;
import nl.uva.se.ql.gui.mediators.Mediator;
import nl.uva.se.ql.gui.widgets.questions.BaseQuestion;
import nl.uva.se.ql.gui.widgets.questions.BooleanQuestion;
import nl.uva.se.ql.gui.widgets.questions.DecimalQuestion;
import nl.uva.se.ql.gui.widgets.questions.IntegerQuestion;
import nl.uva.se.ql.gui.widgets.questions.TextQuestion;
import nl.uva.se.ql.gui.widgets.questions.UndefinedQuestion;

public class QuestionBuilder implements TypeVisitor<BaseQuestion> {

	private final Question question;
	private final Mediator mediator;

	public QuestionBuilder(Question question, Mediator mediator) {
		this.question = question;
		this.mediator = mediator;
	}

	@Override
	public BooleanQuestion visit(BooleanType booleanType) {
		return new BooleanQuestion(this.question, mediator);
	}

	@Override
	public DecimalQuestion visit(DecimalType decimalType) {
		return new DecimalQuestion(this.question, mediator);
	}

	@Override
	public IntegerQuestion visit(IntegerType integerType) {
		return new IntegerQuestion(this.question, mediator);
	}

	@Override
	public TextQuestion visit(StringType stringType) {
		return new TextQuestion(this.question, mediator);
	}

	@Override
	public UndefinedQuestion visit(UndefinedType undefinedType) {
		return new UndefinedQuestion(this.question, mediator);
	}
}

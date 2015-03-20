package nl.uva.se.ql.gui.builders;

import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.type.BooleanType;
import nl.uva.se.ql.ast.type.DecimalType;
import nl.uva.se.ql.ast.type.IntegerType;
import nl.uva.se.ql.ast.type.StringType;
import nl.uva.se.ql.ast.type.TypeVisitor;
import nl.uva.se.ql.ast.type.UndefinedType;
import nl.uva.se.ql.gui.mediators.IMediator;
import nl.uva.se.ql.gui.widgets.questions.calculated.*;

@SuppressWarnings("rawtypes")
public class CalculatedQuestionBuilder implements TypeVisitor<BaseCalculatedQuestion> {

	private final Question question;
	private final IMediator mediator;

	public CalculatedQuestionBuilder(Question question, IMediator mediator) {
		this.question = question;
		this.mediator = mediator;
	}

	@Override
	public BooleanCalculatedQuestion visit(BooleanType booleanType) {
		return new BooleanCalculatedQuestion(this.question, mediator);
	}

	@Override
	public DecimalCalculatedQuestion visit(DecimalType decimalType) {
		return new DecimalCalculatedQuestion(this.question, mediator);
	}

	@Override
	public IntegerCalculatedQuestion visit(IntegerType integerType) {
		return new IntegerCalculatedQuestion(this.question, mediator);
	}

	@Override
	public TextCalculatedQuestion visit(StringType stringType) {
		return new TextCalculatedQuestion(this.question, mediator);
	}

	@Override
	public UndefinedCalculatedQuestion visit(UndefinedType undefinedType) {
		return new UndefinedCalculatedQuestion(this.question, mediator);
	}
}

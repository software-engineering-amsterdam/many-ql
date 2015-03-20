package nl.uva.se.ql.evaluation;

import nl.uva.se.ql.ast.form.Form;
import nl.uva.se.ql.ast.form.FormVisitor;
import nl.uva.se.ql.ast.statement.CalculatedQuestion;
import nl.uva.se.ql.ast.statement.Condition;
import nl.uva.se.ql.ast.statement.Question;
import nl.uva.se.ql.ast.statement.StatementVisitor;
import nl.uva.se.ql.ast.type.BooleanType;
import nl.uva.se.ql.ast.type.DecimalType;
import nl.uva.se.ql.ast.type.IntegerType;
import nl.uva.se.ql.ast.type.StringType;
import nl.uva.se.ql.ast.type.Type;
import nl.uva.se.ql.ast.type.TypeVisitor;
import nl.uva.se.ql.ast.type.UndefinedType;
import nl.uva.se.ql.evaluation.value.Value;

public class Evaluator implements FormVisitor, StatementVisitor, TypeVisitor<Value> {

	private ValueTable values;
	private Value currentValue;
	
	private Evaluator() {
		values = new ValueTable();
	}
	
	private Evaluator(ValueTable values) {
		this.values = values;
	}
	
	public static ValueTable evaluate(Form form, ValueTable values) {
		Evaluator evaluator = new Evaluator(values);
		form.accept(evaluator);
		
		return evaluator.values;
	}

	public void visit(Form form) {
		form.visitChildren(this);
	}

	public void visit(Question question) {
		if (values.containsKey(question.getId())) {
			values.addValue(question.getId(), values.getValue(question.getId()));
		} else {
			Type questionType = question.getType();
			values.addValue(question.getId(), questionType.getDefaultValue());
		}
	}

	public void visit(CalculatedQuestion calculatedQuestion) {
		Value exprValue = ExpressionEvaluator.evaluate(calculatedQuestion.getExpression(), values);
		currentValue = exprValue;
		Type questionType = calculatedQuestion.getType();
		Value promotedValue = questionType.accept(this);
		
		values.addValue(calculatedQuestion.getId(), promotedValue);
	}

	public void visit(Condition condition) {
		condition.visitChildren(this);
	}

	@Override
	public Value visit(BooleanType booleanType) {
		return currentValue;
	}

	@Override
	public Value visit(DecimalType decimalType) {
		return currentValue.promote();
	}

	@Override
	public Value visit(IntegerType integerType) {
		return currentValue;
	}

	@Override
	public Value visit(StringType stringType) {
		return currentValue;
	}

	@Override
	public Value visit(UndefinedType undefinedType) {
		return currentValue;
	}

}

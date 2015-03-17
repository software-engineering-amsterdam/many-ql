package nl.uva.sc.encoders.qlruntime.runtime;

import java.util.ArrayList;
import java.util.List;

import nl.uva.sc.encoders.ql.ast.Questionnaire;
import nl.uva.sc.encoders.ql.ast.expression.Expression;
import nl.uva.sc.encoders.ql.ast.statement.ConditionalBlock;
import nl.uva.sc.encoders.ql.ast.statement.Question;
import nl.uva.sc.encoders.ql.ast.statement.Statement;
import nl.uva.sc.encoders.ql.ast.type.BooleanType;
import nl.uva.sc.encoders.ql.ast.type.DataType;
import nl.uva.sc.encoders.ql.ast.type.IntegerType;
import nl.uva.sc.encoders.ql.ast.type.StringType;
import nl.uva.sc.encoders.ql.visitor.DataTypeVisitor;
import nl.uva.sc.encoders.ql.visitor.StatementVisitor;
import nl.uva.sc.encoders.qlruntime.runtime.model.RuntimeQuestion;
import nl.uva.sc.encoders.qlruntime.runtime.value.BooleanValue;
import nl.uva.sc.encoders.qlruntime.runtime.value.IntegerValue;
import nl.uva.sc.encoders.qlruntime.runtime.value.StringValue;
import nl.uva.sc.encoders.qlruntime.runtime.value.Value;

public class QuestionnaireToRuntimeQuestions implements StatementVisitor<List<RuntimeQuestion>>, DataTypeVisitor<Value> {

	public List<RuntimeQuestion> createRuntimeQuestions(Questionnaire questionnaire) {
		List<Statement> statements = questionnaire.getStatements();
		List<RuntimeQuestion> runtimeQuestions = new ArrayList<>();
		for (Statement statement : statements) {
			runtimeQuestions.addAll(statement.accept(this));
		}
		return runtimeQuestions;
	}

	@Override
	public List<RuntimeQuestion> visit(Question question) {
		ArrayList<RuntimeQuestion> result = new ArrayList<>();
		DataType dataType = question.getDataType();
		Value defaultValue = dataType.accept(this);
		result.add(new RuntimeQuestion(question, defaultValue));
		return result;
	}

	@Override
	public List<RuntimeQuestion> visit(ConditionalBlock conditionalBlock) {
		List<RuntimeQuestion> result = new ArrayList<>();
		List<Question> questions = conditionalBlock.getQuestions();
		Expression condition = conditionalBlock.getCondition();
		for (Question question : questions) {
			DataType dataType = question.getDataType();
			Value defaultValue = dataType.accept(this);
			result.add(new RuntimeQuestion(question, condition, defaultValue));
		}
		return result;
	}

	@Override
	public BooleanValue visit(BooleanType qlBoolean) {
		return new BooleanValue(false);
	}

	@Override
	public IntegerValue visit(IntegerType qlInteger) {
		return new IntegerValue(0);
	}

	@Override
	public StringValue visit(StringType qlString) {
		return new StringValue("");
	}
}

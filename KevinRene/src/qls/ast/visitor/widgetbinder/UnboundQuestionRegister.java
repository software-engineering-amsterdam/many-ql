package qls.ast.visitor.widgetbinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ql.ast.QLType;
import ql.ast.type.QLBoolean;
import ql.ast.type.QLFloat;
import ql.ast.type.QLInteger;
import ql.ast.type.QLMoney;
import ql.ast.type.QLString;
import qls.ast.statement.Question;
import qls.ast.visitor.WidgetEnvironment;

public class UnboundQuestionRegister {
	private Map<QLType, List<Question>> environment;
	private UnboundQuestionRegister parentEnvironment;

	public UnboundQuestionRegister() {
		environment = new HashMap<QLType, List<Question>>();
		
		environment.put(new QLBoolean(), new ArrayList<Question>());
		environment.put(new QLFloat(), new ArrayList<Question>());
		environment.put(new QLInteger(), new ArrayList<Question>());
		environment.put(new QLMoney(), new ArrayList<Question>());
		environment.put(new QLString(), new ArrayList<Question>());
	}

	public UnboundQuestionRegister(UnboundQuestionRegister parent) {
		this();
		parentEnvironment = parent;
	}

	public void register(QLType type, Question questionInstance) {
		List<Question> unboundQuestions = environment.get(type);
		
		unboundQuestions.add(questionInstance);

		environment.put(type, unboundQuestions);
	}

	public void mergeQuestions(QLType type, List<Question> questions) {
		List<Question> unboundQuestions = environment.get(type);
		
		unboundQuestions.addAll(questions);
		
		environment.put(type, unboundQuestions);
	}
	
	public void bindWidgets(QLType type, WidgetEnvironment widgetEnvironment, DefaultWidgetEnvironment defaultWidgets) {
		List<Question> unboundQuestions = environment.get(type);

		unboundQuestions.stream()
				.forEach(unbound -> widgetEnvironment.store(unbound.getIdentifier(), defaultWidgets.resolve(type)));

		environment.put(type, new ArrayList<Question>());
	}

	public UnboundQuestionRegister getParent() {
		if (parentEnvironment == null) {
			return this;
		}
		
		// Give all still unbound questions to the parent scope.
		environment.keySet()
				.stream()
				.forEach(
					type -> parentEnvironment.mergeQuestions(type, environment.get(type))
				);

		return parentEnvironment;
	}
}

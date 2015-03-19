package uva.sc.ql.gui.questions;

import java.awt.Component;
import java.util.List;
import java.util.Map;

import uva.sc.core.types.Boolean;
import uva.sc.core.types.Type;
import uva.sc.ql.evaluator.EvaluatorVisitor;

public class QuestionFactory {

    public Question questionType(uva.sc.ql.statements.Question question,
	    Map<String, List<String>> dependentElements,
	    EvaluatorVisitor evaluator, List<Component> componentList) {
	Type type = question.getType();
	uva.sc.ql.gui.questions.Question questionType = null;
	if (type.equals(new Boolean())) {
	    questionType = new CheckBoxQuestion(dependentElements, evaluator,
		    componentList);
	} else if (type.equals(new String())) {
	    questionType = new TextBoxQuestion(dependentElements, evaluator,
		    componentList);
	} else {// (type.equals(new Number())) {
	    questionType = new CalculatedQuestion(dependentElements, evaluator,
		    componentList);
	}
	return questionType;
	// else {
	// throw new Exception("Unkown type exception.");
	// }
    }
}

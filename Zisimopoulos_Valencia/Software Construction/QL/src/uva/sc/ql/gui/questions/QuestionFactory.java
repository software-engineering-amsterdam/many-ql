package uva.sc.ql.gui.questions;

import java.awt.Component;
import java.util.List;
import java.util.Map;

import uva.sc.core.types.Boolean;
import uva.sc.core.types.Type;
import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.EvaluatorVisitor;

public class QuestionFactory {

    public Question questionType(uva.sc.ql.statements.Question question,
	    Map<ID, List<ID>> patronElements,
	    EvaluatorVisitor evaluator, List<Component> componentList) {
	Type type = question.getType();
	Question questionType = null;
	if (type.equals(new Boolean())) {
	    questionType = new CheckBoxQuestion(patronElements, evaluator,
		    componentList);
	} else if (type.equals(new String())) {
	    questionType = new TextBoxQuestion(patronElements, evaluator,
		    componentList);
	} else {// (type.equals(new Number())) {
	    questionType = new CalculatedQuestion(patronElements, evaluator,
		    componentList);
	}
	return questionType;
	// else {
	// throw new Exception("Unkown type exception.");
	// }
    }
}

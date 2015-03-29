package uva.sc.ql.gui.questions;

import java.awt.Component;
import java.util.List;
import java.util.Map;

import uva.sc.core.types.Boolean;
import uva.sc.core.types.Type;
import uva.sc.ql.atom.ID;
import uva.sc.ql.evaluator.QuestionsPropertiesVisitor;

public class QuestionFactory {

    public Question questionType(uva.sc.ql.statements.Question question, QuestionsPropertiesVisitor questionProperties,
	    Map<ID, List<ID>> patronElements,
	    List<Component> componentList) {
	Type type = question.getType();
	Question questionType = null;
	if (type.equals(new Boolean())) {
	    questionType = new CheckBoxQuestion(patronElements, questionProperties,
		    componentList);
	} else if (type.equals(new String())) {
	    questionType = new TextBoxQuestion(patronElements, questionProperties,
		    componentList);
	} else {
	    questionType = new CalculatedQuestion(patronElements, questionProperties,
		    componentList);
	}
	return questionType;
    }
}

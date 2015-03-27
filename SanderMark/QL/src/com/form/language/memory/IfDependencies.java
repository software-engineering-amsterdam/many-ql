package com.form.language.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.form.language.ast.expression.Expression;
import com.form.language.gui.components.QuestionComponent;

public class IfDependencies {
    private Map<Expression, List<QuestionComponent>> ifConditions;

    public IfDependencies() {
	this.ifConditions = new HashMap<Expression, List<QuestionComponent>>();
    }

    public List<QuestionComponent> get(Expression condition) {
	if (ifConditions.containsKey(condition)) {
	    return ifConditions.get(condition);
	} else {
	    return new ArrayList<QuestionComponent>();
	}
    }

    public void add(Expression key, QuestionComponent value) {
	List<QuestionComponent> tempList = this.get(key);
	tempList.add(value);
	ifConditions.put(key, tempList);
    }
}

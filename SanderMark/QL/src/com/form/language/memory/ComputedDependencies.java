package com.form.language.memory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.form.language.gui.components.ComputedQuestionComponent;

public class ComputedDependencies {
    private Map<String, List<ComputedQuestionComponent>> dependingQuestions;

    public ComputedDependencies() {
    	this.dependingQuestions = new HashMap<String, List<ComputedQuestionComponent>>();
    }

    public List<ComputedQuestionComponent> get(String questionId) {
		if (dependingQuestions.containsKey(questionId)) {
		    return dependingQuestions.get(questionId);
		} else {
		    return new ArrayList<ComputedQuestionComponent>();
		}
    }

    public void add(String key, ComputedQuestionComponent value) {
		List<ComputedQuestionComponent> tempList = get(key);
		tempList.add(value);
		dependingQuestions.put(key, tempList);
    }
}

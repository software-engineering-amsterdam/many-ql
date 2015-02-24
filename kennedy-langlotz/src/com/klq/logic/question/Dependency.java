package com.klq.logic.question;

import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timon on 23.02.2015.
 */
public class Dependency implements IKLQItem{
    private Map<Id, AExpression> dependencyMap;

    public Dependency() {
        dependencyMap = new HashMap<Id, AExpression>();
    }

    public void add(Id questionId, AExpression expression){
        dependencyMap.put(questionId, expression);
    }
}

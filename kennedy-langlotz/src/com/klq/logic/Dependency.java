package com.klq.logic;

import com.klq.logic.expression.AExpression;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Timon on 23.02.2015.
 */
public class Dependency {
    private Map<Id, AExpression> dependencyMap;

    public Dependency() {
        dependencyMap = new HashMap<Id, AExpression>();
    }

    public void add(Id questionId, AExpression expression){
        dependencyMap.put(questionId, expression);
    }
}

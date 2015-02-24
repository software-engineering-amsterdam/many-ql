package com.klq.logic.controller;

import com.klq.logic.question.Id;
import com.klq.logic.question.Question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Timon on 23.02.2015.
 */
public class Store {
    private List<Id> order;
    private Map<Id, Question> store;

    public Store() {
        order = new ArrayList<Id>();
        store = new HashMap<Id, Question>();
    }

    public Question add(Id questionId, Question question){
        order.add(questionId);
        return store.put(questionId, question);
    }

    public Question get(Id questionId){
        return store.get(questionId);
    }

    public List<Question> getOrderedQuestions(){
        List<Question> result = new ArrayList<Question>();
        for (Id id : order) {
            result.add(store.get(id));
        }
        return result;
    }
}

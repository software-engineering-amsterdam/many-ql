package com.klq.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class AnswerSet implements Iterable {
    private List<Answer> answers;
    public static final AnswerSet BOOLEAN = createAnswerSet(Type.BOOLEAN);

    public AnswerSet() {
        answers = new ArrayList<Answer>();
    }

    private static AnswerSet createAnswerSet(Type type){
        AnswerSet result = new AnswerSet();
        switch (type) {
            case BOOLEAN:
                result.add(Answer.YES);
                result.add(Answer.NO);
                break;
        }
        return result;
    }

    public boolean add(Answer answer) {
        return answers.add(answer);
    }

    public int size() {
        return answers.size();
    }

    public Answer get(int index) {
        return answers.get(index);
    }

    public Answer remove(int index) {
        return answers.remove(index);
    }

    @Override
    public Iterator iterator() {
        return answers.iterator();
    }
}

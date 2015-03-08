package com.klq.logic.question;

import com.klq.ast.impl.expr.value.*;
import com.klq.logic.IKLQItem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class OptionSet implements Iterable, IKLQItem {
    private List<Value> answers;
    public static final OptionSet BOOLEAN = createAnswerSet(Type.BOOLEAN);

    public OptionSet() {
        answers = new ArrayList<>();
    }

    public static OptionSet createAnswerSet(Type type){
        OptionSet result = new OptionSet();
        switch (type) {
            case BOOLEAN:
                result.add(new BooleanValue(true));
                result.add(new BooleanValue(false));
                break;
        }
        return result;
    }

    public boolean add(Value answer) {
        return answers.add(answer);
    }

    public void add(int index, Value answer){
        answers.add(index, answer);
    }

    public int size() {
        return answers.size();
    }

    public Value get(int index) {
        return answers.get(index);
    }

    public Value remove(int index) {
        return answers.remove(index);
    }

    @Override
    public Iterator iterator() {
        return answers.iterator();
    }
}

package com.klq.logic.question;

import com.klq.logic.IKLQItem;
import com.klq.logic.expression.AExpression;
import com.klq.logic.expression.terminal.*;
import com.klq.logic.expression.terminal.Boolean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class OptionSet implements Iterable, IKLQItem {
    private List<AExpression> answers;
    public static final OptionSet BOOLEAN = createAnswerSet(Type.BOOLEAN);

    public OptionSet() {
        answers = new ArrayList<AExpression>();
    }

    private static OptionSet createAnswerSet(Type type){
        OptionSet result = new OptionSet();
        switch (type) {
            case BOOLEAN:
                result.add(Boolean.getTrue());
                result.add(Boolean.getFalse());
                break;
        }
        return result;
    }

    public boolean add(AExpression answer) {
        return answers.add(answer);
    }

    public int size() {
        return answers.size();
    }

    public AExpression get(int index) {
        return answers.get(index);
    }

    public AExpression remove(int index) {
        return answers.remove(index);
    }

    @Override
    public Iterator iterator() {
        return answers.iterator();
    }
}

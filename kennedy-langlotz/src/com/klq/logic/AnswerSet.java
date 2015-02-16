package com.klq.logic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Timon on 10.02.2015.
 */
public class AnswerSet<E> implements Iterable {
    private List<E> answers;

    public AnswerSet() {
        answers = new ArrayList<E>();
    }

    public boolean add(E answer) {
        return answers.add(answer);
    }

    public int size() {
        return answers.size();
    }

    public E get(int index) {
        return answers.get(index);
    }

    public E remove(int index) {
        return answers.remove(index);
    }

    /*public AnswerSet<E> subsection(int[] indizes) {
        AnswerSet<E> result = this.clone();
    }*/

    @Override
    public Iterator iterator() {
        return answers.iterator();
    }
}

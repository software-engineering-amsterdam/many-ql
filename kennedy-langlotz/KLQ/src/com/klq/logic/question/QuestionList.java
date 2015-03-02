package com.klq.logic.question;

import com.klq.logic.IKLQItem;

import java.util.ArrayList;

/**
 * Created by juriaan on 24-2-15.
 */
public class QuestionList implements IKLQItem {
    private ArrayList<Question> list;

    public QuestionList(){
        list = new ArrayList<Question>();
    }

    public Question get(int index){
        return list.get(index);
    }

    public void add(Question question){
        list.add(question);
    }

    public ArrayList<Question> getList() {
        return list;
    }
}

package com.klq.gui;

import com.klq.gui.control.ARenderedQuestion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 24-2-15.
 */
public class QuestionList implements IKLQItem {
    private List<ARenderedQuestion> list;

    public QuestionList(){
        list = new ArrayList<>();
    }

    public ARenderedQuestion get(int index){
        return list.get(index);
    }

    public void add(ARenderedQuestion question){
        list.add(question);
    }

    public List<ARenderedQuestion> getList() {
        return list;
    }
}

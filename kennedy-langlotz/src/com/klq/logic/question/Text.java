package com.klq.logic.question;

import com.klq.logic.IKLQItem;

/**
 * Created by Timon on 16.02.2015.
 */
public class Text implements IKLQItem{
    private String text;

    public Text(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

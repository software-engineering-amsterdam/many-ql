package com.klq.logic.expression.terminal;

import com.klq.logic.expression.AExpression;

import java.lang.String;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Timon on 23.02.2015.
 */
public class Date extends AExpression {
    private final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private final String content;

    public Date(String content) {
        super(null, null, AExpression.DATE);
        this.content = content;
    }

    @Override
    public AExpression evaluate() {
        return this;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Date){
            try {
                java.util.Date d1 = sdf.parse(content);
                java.util.Date d2 = sdf.parse(((Date) o).getContent());
                return d1.compareTo(d2);
            } catch (ParseException p) {
                p.printStackTrace();
            }
        }
        return AExpression.UNCOMPARABLE;
    }
}

package com.klq.logic.expression.comparison;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by Timon on 22.02.2015.
 */
public class KLQDate extends AComparator {
    public static final String SEPARATORS = "[.-/]";
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd" + SEPARATORS + "MM" + SEPARATORS + "yyyy");

    public KLQDate(String content) {
        super(AComparator.DATE, content);
    }

    @Override
    public int compareTo(AComparator o) {
        if (o.getType() == AComparator.DATE){
            try {
                java.util.Date d1 = sdf.parse(content);
                java.util.Date d2 = sdf.parse(o.content);
                return d1.compareTo(d2);
            } catch (ParseException p) {}
        }
        return AComparator.UNCOMPARABLE;
    }
}

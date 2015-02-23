package com.klq.logic.expression.comparison;

/**
 * Created by Timon on 22.02.2015.
 */
public class KLQString extends AComparator {

    public KLQString(String content) {
        super(AComparator.STRING, content);
    }

    @Override
    public int compareTo(AComparator o) {
        if (o.getType() == AComparator.STRING){
            return content.toLowerCase().compareTo(o.getContent().toLowerCase());
        }
        return AComparator.UNCOMPARABLE;
    }
}

package com.klq.logic.expression.comparison;

/**
 * Created by Timon on 22.02.2015.
 */
public class KLQNumber extends AComparator {

    public KLQNumber(String number) {
        super(AComparator.NUMBER, number);
    }

    public static void main(KLQString[] args) {
        String a = "13";
        String b = "";
        System.out.println(a.compareTo(b));
    }

    @Override
    public int compareTo(AComparator comparator) {
        if (comparator.getType() == AComparator.NUMBER) {
            Double a = Double.valueOf(content);
            Double b = Double.valueOf(comparator.getContent());
            return a.compareTo(b);
        }
        return AComparator.UNCOMPARABLE;
    }
}

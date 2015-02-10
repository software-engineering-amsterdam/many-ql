package nl.uva.bromance.questionnaire.ranges;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public class Between implements Range {

    private double lower;
    private double higher;

    public Between(double lower, double higher) {
        this.lower = lower;
        this.higher = higher;
    }

    public Between(int lower, int higher) {
        this.lower = (double) lower;
        this.higher = (double) higher;
    }

    public boolean valueConformsToRange(double value) {
        if (value >= this.lower && value <= this.higher)
            return true;
        else
            return false;
    }

    public boolean valueConformsToRange(int value) {
        return valueConformsToRange((double) value);
    }

    public String toString() {
        return ">=" + lower + " & <=" + higher;
    }
}

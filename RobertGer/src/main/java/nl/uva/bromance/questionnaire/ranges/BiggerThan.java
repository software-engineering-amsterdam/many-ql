package nl.uva.bromance.questionnaire.ranges;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public class BiggerThan implements Range {

    double val;

    public BiggerThan(double value) {
        this.val = value;
    }

    public BiggerThan(int value) {
        this.val = (double) value;
    }

    public boolean valueConformsToRange(double value) {
        if (value > this.val)
            return true;
        else
            return false;
    }

    public boolean valueConformsToRange(int value) {
        return this.valueConformsToRange((double) value);
    }

    public String toString() {
        return "> " + val;
    }
}

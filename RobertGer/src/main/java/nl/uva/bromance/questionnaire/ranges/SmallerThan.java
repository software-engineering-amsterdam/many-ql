package nl.uva.bromance.questionnaire.ranges;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public class SmallerThan implements Range {

    double val;

    public SmallerThan(double value) {
        this.val = value;
    }

    public SmallerThan(int value) {
        this.val = (double) value;
    }

    public boolean valueConformsToRange(double value) {
        if (value < this.val)
            return true;
        else
            return false;
    }

    public boolean valueConformsToRange(int value) {
        return this.valueConformsToRange((double) value);
    }

    public String toString() {
        return "< " + val;
    }
}

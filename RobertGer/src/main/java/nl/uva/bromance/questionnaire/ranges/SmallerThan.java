package nl.uva.bromance.questionnaire.ranges;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public class SmallerThan implements Range {

    double val;

    public SmallerThan(double value){
        this.val = value;
    }
    public SmallerThan(int value){
        this.val = (double) value;
    }

    @Override
    public boolean valueConformsToRange(double value) {
        if (value < this.val)
            return true;
        else
            return false;
    }

    @Override
    public boolean valueConformsToRange(int value) {
        return this.valueConformsToRange((double) value);
    }

    @Override
    public String toString(){
        return "< "+val;
    }
}

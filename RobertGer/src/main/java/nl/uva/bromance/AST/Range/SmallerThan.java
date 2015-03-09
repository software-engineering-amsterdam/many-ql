package nl.uva.bromance.ast.range;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public class SmallerThan implements Range {

    int val;

    public SmallerThan(int value) {
        this.val = value;
    }

    public boolean valueConformsToRange(int value) {
        if (value < this.val)
            return true;
        else
            return false;
    }

    public String toString() {
        return "< " + val;
    }
}

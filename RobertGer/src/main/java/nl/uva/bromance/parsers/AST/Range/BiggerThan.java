package nl.uva.bromance.parsers.AST.Range;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public class BiggerThan implements Range {

    int val;

    public BiggerThan(int value) {
        this.val = value;
    }

    public boolean valueConformsToRange(int value) {
        if (value > this.val)
            return true;
        else
            return false;
    }

    public String toString() {
        return "> " + val;
    }
}

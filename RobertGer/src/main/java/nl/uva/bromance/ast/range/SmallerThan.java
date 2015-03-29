package nl.uva.bromance.ast.range;

public class SmallerThan implements Range {

    int val;

    public SmallerThan(int value) {
        this.val = value;
    }

    public boolean valueConformsToRange(int value) {
        return value < this.val;
    }

    public String toString() {
        return "< " + val;
    }
}

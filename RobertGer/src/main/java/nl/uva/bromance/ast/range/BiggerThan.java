package nl.uva.bromance.ast.range;

public class BiggerThan implements Range {

    private int val;

    public BiggerThan(int value) {
        this.val = value;
    }

    public boolean valueConformsToRange(int value) {
        return value > this.val;
    }

    public String toString() {
        return "> " + val;
    }
}

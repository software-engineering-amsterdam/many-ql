package nl.uva.bromance.ast.range;

public class Between implements Range {

    private int lower;
    private int higher;

    public Between(int lower, int higher) {
        this.lower = lower;
        this.higher = higher;
    }

    public boolean valueConformsToRange(int value) {
        return value >= this.lower && value <= this.higher;
    }

    public String toString() {
        return ">=" + lower + " & <=" + higher;
    }
}

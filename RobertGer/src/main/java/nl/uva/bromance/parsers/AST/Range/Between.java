package nl.uva.bromance.parsers.AST.Range;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public class Between implements Range {

    private int lower;
    private int higher;

    public Between(int lower, int higher) {
        this.lower = lower;
        this.higher = higher;
    }

    public boolean valueConformsToRange(int value) {
        if (value >= this.lower && value <= this.higher)
            return true;
        else
            return false;
    }

    public String toString() {
        return ">=" + lower + " & <=" + higher;
    }
}

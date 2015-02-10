package nl.uva.bromance.parsers.questionnaire.ranges;

/**
 * Created by Gerrit Krijnen on 2/9/2015.
 */
public interface Range {
    public boolean valueConformsToRange(double value);

    public boolean valueConformsToRange(int value);
}

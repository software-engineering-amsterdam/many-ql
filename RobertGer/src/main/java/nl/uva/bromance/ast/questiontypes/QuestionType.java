package nl.uva.bromance.ast.questiontypes;

import nl.uva.bromance.ast.conditionals.Result;

/**
 * Created by Robert on 9-3-2015.
 */
public abstract class QuestionType {
    public abstract String getTypeString();

    public abstract Result getCorrespondingResultType();
}

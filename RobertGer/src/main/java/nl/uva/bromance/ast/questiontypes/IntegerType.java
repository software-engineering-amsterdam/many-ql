package nl.uva.bromance.ast.questiontypes;

import nl.uva.bromance.ast.conditionals.IntResult;
import nl.uva.bromance.ast.conditionals.Result;

/**
 * Created by Robert on 9-3-2015.
 */
public class IntegerType extends QuestionType {

    public String getTypeString() {
        return "integer";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new IntResult(0);
    }
}

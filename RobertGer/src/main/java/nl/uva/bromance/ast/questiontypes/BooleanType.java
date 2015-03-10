package nl.uva.bromance.ast.questiontypes;

import nl.uva.bromance.ast.conditionals.BooleanResult;
import nl.uva.bromance.ast.conditionals.Result;

/**
 * Created by Robert on 9-3-2015.
 */
public class BooleanType extends QuestionType {
    public String getTypeString() {
        return "boolean";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new BooleanResult(false);
    }

}

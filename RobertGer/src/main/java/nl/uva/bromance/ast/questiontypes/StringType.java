package nl.uva.bromance.ast.questiontypes;

import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;

/**
 * Created by Robert on 9-3-2015.
 */
public class StringType extends QuestionType {

    public String getTypeString() {
        return "string";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new StringResult("");
    }
}

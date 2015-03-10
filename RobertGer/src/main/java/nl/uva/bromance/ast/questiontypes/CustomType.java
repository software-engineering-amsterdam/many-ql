package nl.uva.bromance.ast.questiontypes;

import nl.uva.bromance.ast.conditionals.CustomResult;
import nl.uva.bromance.ast.conditionals.Result;
import nl.uva.bromance.ast.conditionals.StringResult;

import java.util.Arrays;

/**
 * Created by Robert on 9-3-2015.
 */
public class CustomType extends QuestionType {

    @Override
    public String getTypeString() {
        return "custom";
    }

    @Override
    public Result getCorrespondingResultType() {
        return new CustomResult(Arrays.asList(new StringResult("")));
    }
}

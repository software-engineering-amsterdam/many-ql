package nl.uva.bromance.ast.conditionals;

import java.util.List;

public class CustomResult extends Result {
    private StringResult currentResult;

    public CustomResult(List<StringResult> options) {
        if (currentResult == null) {
            currentResult = options.get(0);
        }
    }

    @Override
    public Result isEqual(Result r) {
        BooleanResult result = new BooleanResult(false);
        if ((r instanceof CustomResult)) {
            if (this.getResult().equals(((CustomResult) r).getResult())) {
                result = new BooleanResult(true);
            }
        } else if (r instanceof StringResult) {
            if (((StringResult) r).getResult().equals(getResult().getResult())) {
                result = new BooleanResult(true);
            }
        }
        return result;
    }

    public StringResult getResult() {
        return currentResult;
    }

    public void setResult(StringResult currentResult) {
        this.currentResult = currentResult;
    }
}

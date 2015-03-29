package nl.uva.bromance.ast.conditionals;

public class StringResult extends Result {

    private String result;

    public StringResult(String result) {
        if (result != null && result.length() > 0 && result.charAt(0) == '\"') {
            this.result = result.substring(1, result.length() - 1);
        } else {
            this.result = result;
        }
    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return result;
    }

    @Override
    public Result isEqual(Result r) {
        if (!(r instanceof StringResult) || !result.equals(((StringResult) r).getResult())) {
            return new BooleanResult(false);
        } else {
            return new BooleanResult(true);
        }
    }
}

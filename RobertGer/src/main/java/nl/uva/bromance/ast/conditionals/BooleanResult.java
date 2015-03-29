package nl.uva.bromance.ast.conditionals;

public class BooleanResult extends Result {

    private boolean result;

    public BooleanResult(boolean result) {
        this.result = result;
    }

    public boolean getResult() {
        return result;
    }

    public Result flip() {
        return new BooleanResult(!result);
    }

    public Result or(BooleanResult br) {
        return new BooleanResult((result || br.getResult()));
    }

    public Result and(BooleanResult br) {
        return new BooleanResult((result && br.getResult()));
    }

    @Override
    public String toString() {
        if (result) {
            return "true";
        } else {
            return "false";
        }
    }


    @Override
    public Result isEqual(Result r) {
        if (!(r instanceof BooleanResult) || result != ((BooleanResult) r).getResult()) {
            return new BooleanResult(false);
        } else {
            return new BooleanResult(true);
        }
    }
}

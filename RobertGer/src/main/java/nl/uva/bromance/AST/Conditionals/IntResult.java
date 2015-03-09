package nl.uva.bromance.ast.conditionals;

/**
 * Created by Ger on 24-2-2015.
 */
public class IntResult extends Result {

    private int result;

    IntResult(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public Result add(IntResult r) {
        return new IntResult(result + r.getResult());
    }

    public Result minus(IntResult r) {
        return new IntResult(result - r.getResult());
    }

    public Result multiply(IntResult r) {
        return new IntResult(result * r.getResult());
    }

    public Result divide(IntResult r) {
        return new IntResult(result / r.getResult());
    }

    public Result largerThan(IntResult r) {
        return new BooleanResult(result > r.getResult());
    }

    public Result smallerThan(IntResult r) {
        return new BooleanResult(result < r.getResult());
    }

    @Override
    public String toString() {
        return "" + result;
    }

    @Override
    public Result isEqual(Result r) {
        if (!(r instanceof IntResult) || result != ((IntResult) r).getResult()) {
            return new BooleanResult(false);
        } else {
            return new BooleanResult(true);
        }
    }
}

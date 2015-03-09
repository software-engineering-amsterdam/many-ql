package nl.uva.bromance.ast.conditionals;

/**
 * Created by Ger on 24-2-2015.
 */
public class StringResult extends Result{

    private String result;

    public StringResult(String result){
        this.result = result;
    }

    public String getResult(){
        return result;
    }
    @Override
    public String toString() {
        return result;
    }

    @Override
    public Result isEqual(Result r) {
        if (!(r instanceof StringResult) || !result.equals(((StringResult) r).getResult())){
            return new BooleanResult(false);
        } else {
            return new BooleanResult(true);
        }
    }
}

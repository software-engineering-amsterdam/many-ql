package nl.uva.bromance.ast.conditionals;

/**
 * Created by Ger on 24-2-2015.
 */
public class BooleanResult extends Result{

    private boolean result;

    BooleanResult(boolean result){
        this.result = result;
    }

    public boolean getResult(){
        return result;
    }

    public Result flip(){
        if (result)
            return new BooleanResult(false);
        else
            return new BooleanResult(true);
    }

    public Result or(BooleanResult br){
        if (result == true || br.getResult() == true)
            return new BooleanResult(true);
        else
            return new BooleanResult(false);
    }
    public Result and(BooleanResult br){
        if (result == true && br.getResult() == true)
            return new BooleanResult(true);
        else
            return new BooleanResult(false);
    }

    @Override
    public String toString() {
        if(result){
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

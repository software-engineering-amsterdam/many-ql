package nl.uva.bromance.ast.conditionals;

/**
 * Created by Ger on 24-2-2015.
 */
public abstract class Result {
    public void printClass(){
        System.out.println("Classname of result :"+this.getClass().getSimpleName());
    }
    public abstract Result isEqual(Result r);
}

package nl.uva.bromance.AST.Conditionals;

/**
 * Created by Ger on 24-2-2015.
 */
public abstract class Result {
    public void printClass(){
        System.out.println("Classname of result :"+this.getClass().getSimpleName());
    }
    public abstract String toString();
    public abstract Result isEqual(Result r);
}

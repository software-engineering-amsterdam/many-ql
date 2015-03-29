package nl.uva.bromance.ast.conditionals;

public abstract class Result {
    public void printClass() {
        System.out.println("Classname of result :" + this.getClass().getSimpleName());
    }

    public abstract Result isEqual(Result r);
}

package nl.uva.bromance.AST;
/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Calculation extends Node {
    private static final String[] parentsAllowed = {"Form"};
    private String identifier;

    public Calculation(int lineNumber, String id){
        super(lineNumber,"Calculation");
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Calculation Error: No identifier specified");
        }
    }
    @Override
    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[Calculation] { Name : "+this.identifier+" }\n");
        for (Node n :children){
            n.printDebug(i+1);
        }
    }

}

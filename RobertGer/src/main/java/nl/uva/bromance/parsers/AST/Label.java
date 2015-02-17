package nl.uva.bromance.parsers.AST;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Label extends Node {
    private static final String[] parentsAllowed = {"Form"};
    private String identifier;

    public Label(int lineNumber, String id){
        super(lineNumber,"Label");
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Label Error: No identifier specified");
        }
    }

    @Override
    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[Label] { Name : "+this.identifier+" }\n");
        for (Node n :children) {
            n.printDebug(i + 1);
        }
    }

}

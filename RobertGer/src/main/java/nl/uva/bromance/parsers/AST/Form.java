package nl.uva.bromance.parsers.AST;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Form extends Node {
    private static final String[] parentsAllowed = {"Questionnaire"};
    private String identifier;

    public Form(int lineNumber, String id){
        super(lineNumber,"Form");
        this.setAcceptedParents(parentsAllowed);
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Form Error: No identifier specified");
        }
    }
    @Override
    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[Form] { Name : "+this.identifier+" }\n");
        for (Node n :children){
            n.printDebug(i+1);
        }

    }

}

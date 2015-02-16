package nl.uva.bromance.parsers.AST;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Root extends Node {
    private String identifier;

    public Root(String id) {
        super();
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    @Override
    public void addChild(Node child) {
        if (child.parentIsAccepted("Questionnaire")) {
            super.addChild(child);
        } else {
            System.err.println("Invalid Node Error: " + child.getClass() + " is not a valid child for a Root node");
        }
    }
    public String getIdentifier(){
        return this.identifier;
    }
    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("[Root] { Name : " + this.identifier + " }\n");
        for (Node n :children){
            n.printDebug(i+1);
        }
    }
}

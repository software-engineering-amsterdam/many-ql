package nl.uva.bromance.AST;

public class Questionnaire extends Node {
    private String identifier;

    public Questionnaire(int lineNumber, String id) {
        super(lineNumber, Questionnaire.class);
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Root] { Name : " + this.identifier + " }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }
    }
}

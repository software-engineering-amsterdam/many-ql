package nl.uva.bromance.AST;

import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class Root extends Node {
    private String identifier;

    public Root(int lineNumber, String id) {
        super(lineNumber, "Questionnaire");
        if (id != null) {
            this.identifier = id;
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public String getIdentifier() {
        return this.identifier;
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Root] { Name : " + this.identifier + " }\n");
        for (Node n : children) {
            n.printDebug(i + 1);
        }
    }

    public List<Node> getChildren() {
        return children;

    }

}

package nl.uva.bromance.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QLSQuestion extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<>(Arrays.asList(QLSPage.class,QLSSection.class));
	private String identifier;
    public QLSQuestion(int lineNumber, String id) {
        super(lineNumber, QLSQuestion.class);
        super.setAcceptedParents(parentsAllowed);
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
        System.out.print("[Question] { Name: "+identifier+" }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }
    }
}

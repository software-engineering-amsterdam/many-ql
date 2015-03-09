package nl.uva.bromance.ast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QLSPage extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<>(Arrays.asList(QLSStylesheet.class));
	private String identifier;
    public QLSPage(int lineNumber, String id) {
        super(lineNumber, QLSPage.class);
        this.setAcceptedParents(parentsAllowed);
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
        System.out.print("[Page] { Name: "+identifier+" }\n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }
    }
}

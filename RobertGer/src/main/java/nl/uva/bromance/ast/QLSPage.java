package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.NodeVisitor;

public class QLSPage extends QLSNode {
	private String identifier;
    public QLSPage(int lineNumber, String id) {
        super(lineNumber, QLSPage.class);
        if (id != null) {
            this.identifier = id.substring(1, id.length() - 1).toLowerCase();
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    public String getIdentifier(){
        return identifier;
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Page] { Name: " + identifier + " }\n");
        for (QLSNode n : getChildren()) {
            n.printDebug(i + 1);
        }
    }
}

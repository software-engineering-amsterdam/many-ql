package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.NodeVisitor;

public class Questionnaire extends QLNode {
    private String identifier;

    public Questionnaire(int lineNumber, String id) {
        super(lineNumber, Questionnaire.class);
        this.identifier = id;
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Root] { Name : " + this.identifier + " }\n");
        for (QLNode n : getChildren()) {
            n.printDebug(i + 1);
        }
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }

}

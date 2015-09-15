package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;

public class Label extends QLNode{
    private String identifier;

    public Label(int ln, String identifier) {
        super(ln);
        this.identifier = identifier;
    }
}

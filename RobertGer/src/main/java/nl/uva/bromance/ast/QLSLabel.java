package nl.uva.bromance.ast;

import nl.uva.bromance.ast.visitors.QLSNodeVisitor;

import java.util.List;
import java.util.UUID;

public class QLSLabel extends QLSNode {
    private Label labelNode;

    public QLSLabel(int lineNumber, String id, AST qlAST) {
        super(lineNumber);

        List<Label> labels = qlAST.getAllChildrenOfType_ForAst(Label.class);
        id = id.substring(1,id.length() -1);
        if (id != null) {
            for (Label l : labels) {
                if (id.equals(l.getIdentifier())) {
                    labelNode = l;
                }
            }
            if (labelNode == null) {
                System.err.println("QLS Error @ line " + getLineNumber() + " Reference to undefined label :" + id);
            }
        } else {
            System.err.println("Root Error: No identifier specified");
        }
    }

    @Override
    public void accept(QLSNodeVisitor visitor) {
        visitor.visit(this);
        for (QLSNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }

    public Label getLabelNode() {
        return labelNode;
    }
}

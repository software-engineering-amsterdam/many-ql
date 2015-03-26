package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.visitors.NodeVisitor;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public class ElseStatement extends QLNode {

    public ElseStatement(int lineNumber) {
        super(lineNumber);
    }

    @Override
    public void accept(NodeVisitor visitor) {
        visitor.visit(this);
        for(QLNode child: this.getChildren()) {
            child.accept(visitor);
        }
    }
}

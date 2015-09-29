package nl.uva.bromance.QL.controlstructures;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;

public class IfSequence extends QLNode
{
    public IfSequence(int ln)
    {
        super(ln);
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren())
        {
            child.accept(visitor);
        }
        visitor.exit(this);

    }
}

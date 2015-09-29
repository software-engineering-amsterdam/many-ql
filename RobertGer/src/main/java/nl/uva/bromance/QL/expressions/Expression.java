package nl.uva.bromance.QL.expressions;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;

public abstract class Expression extends QLNode implements Evaluable
{
    public Expression(int ln)
    {
        super(ln);
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor)
    {
        for (QLNode child : this.getChildren())
        {
            child.accept(visitor);
        }
    }
}

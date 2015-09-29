package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;

public class Questionnaire extends QLNode {


    public Questionnaire(String identifier, int ln)
    {
        super(ln);
    }

    @Override
    public void accept(QLNodeVisitorInterface visitor)
    {
        visitor.visit(this);
        for (QLNode child : this.getChildren())
        {
            child.accept(visitor);
        }
    }
}

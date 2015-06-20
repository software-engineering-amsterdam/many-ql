package nl.uva.bromance.QL.ast.nodes;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;

/**
 * Created by Robert on 2-6-2015.
 */
public class Questionnaire extends QLNode {


    public Questionnaire(String identifier, int ln) {
        super(ln);
    }

    public void accept(QLNodeVisitorInterface visitor) {
        visitor.visit(this);
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
    }
}

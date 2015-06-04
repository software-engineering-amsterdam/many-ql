package nl.uva.bromance.QL.ast.nodes;


import nl.uva.bromance.QL.ast.QLNode;

public class Question extends QLNode {

    public Question(String identifier, int ln) {
        super(ln);
    }
}

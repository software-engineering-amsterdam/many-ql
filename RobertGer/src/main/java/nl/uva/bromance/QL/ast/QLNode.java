package nl.uva.bromance.QL.ast;

public abstract class QLNode extends Node<QLNode> {

    public QLNode(int ln) {
        super(ln);
    }
}
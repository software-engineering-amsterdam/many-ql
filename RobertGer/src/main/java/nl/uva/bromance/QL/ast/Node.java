package nl.uva.bromance.QL.ast;


import java.util.ArrayList;
import java.util.List;

public class Node<TYPE extends Node> {
    private List<TYPE> children;
    private final int lineNumber;

    public Node(int ln) {
        this(ln, new ArrayList<>());
    }

    public Node(int ln, List<TYPE> children) {
        this.lineNumber = ln;
        this.children = children;
    }

    public void addChild(TYPE child) {
        this.children.add(child);
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public boolean hasChildren() {
        return children.size() > 0;
    }

    public List<TYPE> getChildren() {
        return children;
    }
}
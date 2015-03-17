package nl.uva.bromance.ast;

import nl.uva.bromance.typechecking.ReferenceMap;
import nl.uva.bromance.typechecking.TypeCheckingException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert on 16-3-2015.
 */
public class Node<TYPE extends Node> {
    private List<TYPE> children;
    private final int lineNumber;
    private final Class type;

    public Node(int ln, Class type) {
        this(ln, type, new ArrayList<>());
    }

    public Node(int ln, Class type, List<TYPE> children) {
        this.lineNumber = ln;
        this.children = children;
        this.type = type;
    }

    public void addChild(TYPE child) {
        this.children.add(child);
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void printDebug() {
        printDebug(0);
    }

    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[" + type + "]\n");
        for (Node n : children) {
            n.printDebug(i + 1);
        }
    }

    public boolean hasChildren() {
        return children.size() > 0;
    }

    public List<TYPE> getChildren() {
        return children;
    }
}

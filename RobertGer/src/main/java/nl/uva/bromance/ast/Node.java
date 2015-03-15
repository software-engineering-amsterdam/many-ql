package nl.uva.bromance.ast;

import javafx.scene.layout.Pane;
import nl.uva.bromance.typechecking.ReferenceMap;
import nl.uva.bromance.typechecking.TypeCheckable;
import nl.uva.bromance.typechecking.TypeCheckingException;
import nl.uva.bromance.visualization.Visualizable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Node implements Visualizable, TypeCheckable {
    private List<Node> children;
    private final int lineNumber;
    private final Class<? extends Node> type;

    public Node(int ln, Class<? extends Node> type) {
        this(ln, type, new ArrayList<>());
    }

    public Node(int ln, Class<? extends Node> type, List<Node> children) {
        this.lineNumber = ln;
        this.children = children;
        this.type = type;
    }

    public void addChild(Node child) {
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

    public List<Node> getChildren() {
        return children;
    }

    @Override
    public void typeCheck() throws TypeCheckingException {
    }

    @Override
    public void addReference(ReferenceMap referenceMap) throws TypeCheckingException {
    }

    @Override
    public Optional<? extends Pane> visualize(Pane parent) {

        return Optional.empty();
    }

    @Override
    public void isVisible(boolean visible) {
        
    }
}

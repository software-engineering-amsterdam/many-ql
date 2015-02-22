package nl.uva.bromance.AST;

import javafx.scene.layout.Pane;
import javafx.util.Pair;
import nl.uva.bromance.AST.Conditionals.Expression;
import nl.uva.bromance.typechecking.ReferenceMap;
import nl.uva.bromance.typechecking.TypeCheckable;
import nl.uva.bromance.typechecking.TypeCheckingException;
import nl.uva.bromance.visualization.Visualizable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Node implements Visualizable, TypeCheckable {
    private List<Node> children;
    private List<Class<? extends Node>> acceptedParents;
    private final int lineNumber;
    private final Class<? extends Node> type;

    public Node(int ln, Class<? extends Node> type) {
        this(ln, type, new ArrayList<Node>());
    }

    public Node(int ln, Class<? extends Node> type, List<Node> children) {
        this.lineNumber = ln;
        this.children = children;
        this.type = type;
    }

    public void addChild(Node child) {
        if (child.parentIsAccepted(type)) {
            this.children.add(child);
        } else {
            System.err.println("Invalid Node Error @ Line " + child.getLineNumber() + " : " + child.getClass() + " is not a valid child for a " + type + " node");
        }
    }

    protected boolean parentIsAccepted(Class<? extends Node> parent) {
        for (Class<? extends Node> p : this.acceptedParents) {
            if (parent.equals(p))
                return true;
        }
        return false;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    protected void setAcceptedParents(List<Class<? extends Node>> parents) {
        this.acceptedParents = parents;
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


}

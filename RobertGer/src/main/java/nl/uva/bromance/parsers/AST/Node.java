package nl.uva.bromance.parsers.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public abstract class Node {
    private Node parent;
    protected List<Node> children;
    private String[] acceptedParents;

    public Node() {
        this.parent = null;
        this.children = new ArrayList();
    }

    public Node(Node parent, List children) {
        this.parent = parent;
        this.children = children;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }

    public boolean parentIsAccepted(String parent) {
        for (String p : this.acceptedParents) {
            if (parent.equals(p))
                return true;
        }
        return false;
    }

    protected void setAcceptedParents(String[] parents) {
        this.acceptedParents = parents;
    }

    public void printDebug(){
        printDebug(0);
    };

    public abstract void printDebug(int i);

}

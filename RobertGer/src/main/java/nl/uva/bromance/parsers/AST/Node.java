package nl.uva.bromance.parsers.AST;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gerrit Krijnen on 2/16/2015.
 */
public abstract class Node {
    protected List<Node> children;
    private String[] acceptedParents;
    private final int lineNumber;
    private final String type;

    public Node(int ln, String type) {
        this.children = new ArrayList();
        this.lineNumber = ln;
        this.type = type;
    }

    public Node(int ln, String type, List children) {
        this.lineNumber = ln;
        this.children = children;
        this.type = type;
    }

    public void addChild(Node child) {
        if (child.parentIsAccepted(type)) {
            this.children.add(child);
        } else {
            System.err.println("Invalid Node Error @ Line "+child.getLineNumber()+" : " + child.getClass() + " is not a valid child for a " + type + " node");
        }
    }

    public boolean parentIsAccepted(String parent) {
        for (String p : this.acceptedParents) {
            if (parent.equals(p))
                return true;
        }
        return false;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    protected void setAcceptedParents(String[] parents) {
        this.acceptedParents = parents;
    }

    public void printDebug() {
        printDebug(0);
    }

    public void printDebug(int i){
        for (int j=0; j < i; j++){
            System.out.print("\t");
        }
        System.out.print("["+type+"]\n");
        for (Node n :children){
            n.printDebug(i+1);
        }
    }
}

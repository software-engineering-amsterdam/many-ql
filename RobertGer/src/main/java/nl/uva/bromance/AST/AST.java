package nl.uva.bromance.AST;

/**
 * Created by Robert on 3/2/2015.
 */
public class AST {

    private Node root;

    public AST(Node root) {
        this.root = root;
    }

    public void printDebug() {
        root.printDebug();
    }

    public Node getRoot() {
        return root;
    }
}

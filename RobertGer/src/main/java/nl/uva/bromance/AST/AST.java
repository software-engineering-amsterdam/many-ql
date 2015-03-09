package nl.uva.bromance.ast;

import java.util.ArrayList;
import java.util.List;

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

    public <T extends Node> List<T> getFirstEncounteredChildrenOfType_ForAST_DeepSearch(Class<T> clazz) {
        return getFirstEncounteredChildrenOfType_ForNode_DeepSearch(getRoot(), clazz);
    }

    public <T extends Node> List<T> getFirstEncounteredChildrenOfType_ForNode_DeepSearch(Node node, Class<T> clazz) {
        List<T> firstBranchChildrenOfType = new ArrayList<>();
        for (Node child : node.getChildren()) {
            if (child.getClass().equals(clazz)) {
                addFirstEncounteredChild(firstBranchChildrenOfType, (T) child);
            } else {
                addAndSearchForDeeperChildrenOfType(clazz, firstBranchChildrenOfType, child);
            }
        }
        return firstBranchChildrenOfType;
    }

    private <T extends Node> void addAndSearchForDeeperChildrenOfType(Class<T> clazz, List<T> firstBranchChildrenOfType, Node node) {
        firstBranchChildrenOfType.addAll(getFirstEncounteredChildrenOfType_ForNode_DeepSearch(node, clazz));
    }

    private <T extends Node> void addFirstEncounteredChild(List<T> firstBranchChildrenOfType, T child) {
        firstBranchChildrenOfType.add(child);
    }

    public <T extends Node> List<T> getAllChildrenOfType_ForAst(Class<T> clazz) {
        return getAllChildrenOfType_ForNode(clazz, getRoot());
    }

    private <T extends Node> List<T> getAllChildrenOfType_ForNode(Class<T> clazz, Node node) {
        List<T> foundNodes = new ArrayList<>();
        for (Node child : node.getChildren()) {
            if (child.getClass().equals(clazz)) {
                foundNodes.add((T) child);
            }
            foundNodes.addAll(getAllChildrenOfType_ForNode(clazz, child));
        }
        return foundNodes;
    }
}

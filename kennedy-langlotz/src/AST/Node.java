package AST;

import java.util.ArrayList;

/**
 * Created by juriaan on 9-2-15.
 */
public abstract class Node {
    private String loc;
    private Node parent;
    private ArrayList<Node> children;

    public Node(){}

    public Node(String loc){
        this.loc = loc;
        parent = null;
        children = new ArrayList<Node>();
    }

    public Node getParent() {
        return parent;
    }

    //Set the parent node and change the children property of the parent.
    public void setParent(Node parent) {
        removeParent();
        if(parent != null) {
            this.parent = parent;
            parent.getChildren().add(this);
        }
    }

    public void removeParent(){
        if(parent != null) {
            parent.getChildren().remove(this);
            parent = null;
        }
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public abstract void accept(Visitor visitor);
}
